/***************************************************************************
 * This file is part of Synchrovis - A prototypical implementation of the
 * visualization approach described in the author's master's thesis titled
 *
 * 							 Visualisierung von
 * 					Synchronisationspunkten in Kombination
 * 						  mit der Statik und Dynamik
 *							 eines Softwaresystems
 *
 * written at Software Engineering Group, Department of Computer Science at
 * Christian-Albrechts-University of Kiel.
 *
 * Author: Philipp D�hring, October 2012
 ***************************************************************************/

package dev.javacity.core.importer.kdm;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import data.statics.ClassType;
import data.statics.CodeElement;
import data.statics.Relation;
import data.statics.RelationType;
import data.statics.SClass;
import data.statics.SMethod;
import data.statics.SPackage;
import data.statics.impl.StaticsFactoryImpl;
import data.statics.impl.StaticsPackageImpl;
import dev.javacity.core.importer.exception.KDMImportException;
import dev.javacity.core.models.data.DataModel;
import dev.javacity.core.utils.LoggerUtils;

/**
 * A KDM content handler class for SAX parsers, which parses any given KDM file and extracts the relevant static informations to fill the data model.
 *
 * @author pdo
 *
 * @see DataModel
 *
 */
public final class KDMContentHandler implements ContentHandler {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(KDMContentHandler.class);

	/** The {@link DataModel} object into which the parsed static information will be written. */
	private final DataModel dataModel;

	/** The stack of elements currently being imported. */
	private List<CodeElement> stack = new LinkedList<CodeElement>();

	/** A flag indicating whether the entity currently being processed is enclosed by an {@code ParameterUnit} entity. */
	private boolean withinParamUnit = false;

	/** A flag indicating whether the entity currently being processed is enclosed by an {@code StorableUnit} entity. */
	private boolean withinStorUnit = false;

	/** The number of 'codeElement' end tags to ignore. */
	private int ignore = 0;

	/**
	 * A list of all identified code relations (i.e. class associations, implementations and extensions) in the KDM file along with the KDM-ID of their target
	 * {@link SClass} instance. This temporary storage is required, since a relation often points at a target class which has not been parsed yet.
	 */
	private final List<Pair<Relation, String>> relations = new LinkedList<Pair<Relation, String>>();

	// ========================== Constructor =================================

	/**
	 * Public constructor. It creates a new {@link KDMContentHandler} instance.
	 *
	 * @param dataModel
	 *            The {@link DataModel} instance to write the parsed KDM objects into.
	 * @throws IllegalArgumentException
	 *             If the data model passed in is {@code null}.
	 */
	public KDMContentHandler(final DataModel dataModel) throws IllegalArgumentException {

		if (dataModel == null) {
			throw new IllegalArgumentException("You cannot import data into a null model.");
		}

		StaticsPackageImpl.init();
		StaticsFactoryImpl.init();
		this.dataModel = dataModel;
	}

	// ==================== XML-Entity Handling Methods =====================

	@Override
	public void startElement(final String uri, final String localName, final String qName, final Attributes atts) throws SAXException {

		if ("codeElement".equalsIgnoreCase(localName) && this.ignore == 0) {
			final String type = this.getValueByLocalName(atts, "type");
			if (type.endsWith("Package")) {
				this.parsePackage(atts);
			} else if (type.endsWith("ClassUnit")) {
				this.parseClass(atts, ClassType.REGULAR);
			} else if (type.endsWith("InterfaceUnit")) {
				this.parseClass(atts, ClassType.INTERFACE);
			} else if (type.endsWith("MethodUnit")) {
				this.parseMethod(atts);
			} else if (type.endsWith("StorableUnit")) {
				final String kind = this.getValueByLocalName(atts, "kind");
				if (kind.endsWith("global") || kind.endsWith("static")) {
					final SClass clazz = (SClass) this.getStackElement(SClass.class);
					clazz.setNumAttributes(clazz.getNumAttributes() + 1);
				}
				this.withinStorUnit = true;
			} else {
				this.ignore++;
			}
		} else if ("source".equalsIgnoreCase(localName) && this.hasAttribute(atts, "snippet")) {
			this.parseSignature(atts);
		} else if ("codeRelation".equalsIgnoreCase(localName) && !this.withinParamUnit && this.getStackElement(SMethod.class) == null
				&& this.getStackElement(SClass.class) != null) {
			this.parseRelation(atts);
		} else if ("parameterUnit".equalsIgnoreCase(localName)) {
			this.withinParamUnit = true;
		}
	}

	/**
	 * Parse the package currently being processed by the SAX parser.
	 *
	 * @param atts
	 *            The attribute set containing the package information.
	 * @throws KDMImportException
	 *             If the given attribute set does not contain all attributes belonging to a package element (i.e. a 'name' and 'id' attribute).
	 */
	private void parsePackage(final Attributes atts) throws KDMImportException {

		final SPackage pack = StaticsFactoryImpl.eINSTANCE.createSPackage();
		pack.setKdmId(this.getValueByLocalName(atts, "id"));
		String name = this.getValueByLocalName(atts, "name");
		final SPackage parent = (SPackage) this.getStackElement(SPackage.class);
		if (parent != null) {
			name = parent.getName() + "." + name;
		}
		pack.setName(name);
		this.stack.add(0, pack);
	}

	/**
	 * Parse the class currently being processed by the SAX parser.
	 *
	 * @param atts
	 *            The attribute set containing the class information. Has to be either {@link ClassType#REGULAR} or {@link ClassType#INTERFACE}.
	 * @param type
	 *            The {@link ClassType} of the class to import.
	 * @throws KDMImportException
	 *             If the given attribute set does not contain all attributes belonging to a class element (i.e. a 'name' and 'id' attribute).
	 */
	private void parseClass(final Attributes atts, final ClassType type) throws KDMImportException {

		final SClass clazz = StaticsFactoryImpl.eINSTANCE.createSClass();
		clazz.setKdmId(this.getValueByLocalName(atts, "id"));
		clazz.setName(this.getValueByLocalName(atts, "name"));
		final SPackage currentPack = (SPackage) this.getStackElement(SPackage.class);
		clazz.setSPackage(currentPack);
		clazz.setType(type);
		if (!"<anonymous>".equals(clazz.getName())) {
			currentPack.getSClasses().add(clazz);
		}
		this.stack.add(0, clazz);

		if (type != ClassType.INTERFACE && "true".equalsIgnoreCase(this.getValueByLocalName(atts, "isAbstract"))) {
			clazz.setType(ClassType.ABSTRACT);
		}
	}

	/**
	 * Parse the method currently being processed by the SAX parser.
	 *
	 * @param atts
	 *            The attribute set containing the method information.
	 * @throws KDMImportException
	 *             If the given attribute set does not contain all attributes belonging to a method element (i.e. a 'id', 'name' and 'kind' attribute).
	 */
	private void parseMethod(final Attributes atts) throws KDMImportException {

		final SMethod method = StaticsFactoryImpl.eINSTANCE.createSMethod();
		method.setKdmId(this.getValueByLocalName(atts, "id"));
		method.setName(this.getValueByLocalName(atts, "name"));
		final SClass currentClass = (SClass) this.getStackElement(SClass.class);
		if (currentClass != null) {
			method.setSClass(currentClass);
			currentClass.getSMethods().add(method);
			this.stack.add(0, method);
		}
	}

	/**
	 * Parse the signature of a KDM element and add it as attribute value to the currently parsed method or class entity.
	 *
	 * @param atts
	 *            The attribute set, which contains the signature information (i.e. a 'snippet' attribute value) to parse.
	 * @throws KDMImportException
	 *             If the given attribute set does not contain a 'snippet' attribute.
	 */
	private void parseSignature(final Attributes atts) throws KDMImportException {

		if (!this.stack.isEmpty() && this.stack.get(0) instanceof CodeElement) {
			String signature = this.getValueByLocalName(atts, "snippet");
			if (signature.endsWith(" {}")) {
				// remove "{}" at snippet end
				signature = signature.substring(0, signature.length() - 2).trim();
			}

			final CodeElement element = (CodeElement) this.stack.get(0);
			if (element != null && element.getKdmSignature() == null) {
				element.setKdmSignature(signature);

				if (element instanceof Relation) {
					this.stack.remove(0);

					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("Successfully parsed relation " + LoggerUtils.toLogString(element) + ".");
					}
				}
			}
		}
	}

	/**
	 * Parse the relation currently being processed by the SAX parser.
	 *
	 * @param atts
	 *            The attribute set containing the relation information.
	 * @throws KDMImportException
	 *             If the given attribute set does not contain all attributes belonging to a relation element (i.e. a 'to', 'type' and 'id' attribute).
	 */
	private void parseRelation(final Attributes atts) throws KDMImportException {

		final String type = this.getValueByLocalName(atts, "type");
		if (type.endsWith("Extends") || type.endsWith("Implements") || type.endsWith("HasType")) {
			final String target = this.getValueByLocalName(atts, "to");
			final Relation relation = StaticsFactoryImpl.eINSTANCE.createRelation();
			relation.setKdmId(this.getValueByLocalName(atts, "id"));
			relation.setName("<n/e>");
			relation.setType(RelationType.ASSOCIATION);
			relation.setSource((SClass) this.getStackElement(SClass.class));
			this.relations.add(Pair.of(relation, target));

			if (type.endsWith("Extends") || type.endsWith("Implements")) {
				relation.setType(RelationType.EXTENSION);
				if (type.endsWith("Implements")) {
					relation.setType(RelationType.IMPLEMENTATION);
				}
			} else {
				this.stack.add(0, relation);
			}
		}
	}

	@Override
	public void endElement(final String uri, final String localName, final String qName) throws SAXException {

		if ("codeElement".equalsIgnoreCase(localName)) {
			if (this.withinStorUnit) {
				this.withinStorUnit = false;
			} else if (this.ignore > 0) {
				this.ignore--;
			} else if (!this.stack.isEmpty()) {
				while (this.stack.get(0) instanceof Relation) {
					this.stack.remove(0);
				}
				final CodeElement element = this.stack.remove(0);
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Successfully parsed " + LoggerUtils.toLogString(element) + ".");
				}

				if (element instanceof SPackage) {
					this.dataModel.addPackage((SPackage) element);
				}
			}
		} else if ("parameterUnit".equalsIgnoreCase(localName)) {
			this.withinParamUnit = false;
		} else if ("storableUnit".equalsIgnoreCase(localName)) {
			this.withinStorUnit = false;
		}
	}

	/**
	 * Sets the target class attribute of each {@link Relation} instance in {@code this.relations} and adds all relations to the data model. This method is
	 * automatically invoked after the end of the KDM file has been reached by the parser.
	 *
	 * @throws SAXException
	 *             If an error occurred while parsing the KDM file.
	 */
	public void endDocument() throws SAXException {

		this.addRelations();
		this.withinStorUnit = false;
		this.withinParamUnit = false;
		this.relations.clear();
		this.stack.clear();
		this.ignore = 0;
	}

	// ============================= Helper Methods ===========================

	/**
	 * Add the list of all identified code relations ({@code this.relations}) to the data model ({@code this.dataModel}). The previously missing target value of each
	 * relation will be added automatically.
	 */
	private void addRelations() {

		for (Pair<Relation, String> entry : this.relations) {
			final SClass target = this.dataModel.getClassByKdmId(entry.getRight());
			if (target != null) {
				final Relation relation = entry.getLeft();
				relation.setTarget(target);
				relation.getSource().getRelations().add(relation);
				target.getRelations().add(relation);

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Successfully added relation " + LoggerUtils.toLogString(relation) + " to data model.");
				}
			}
		}
	}

	/**
	 * Get the value of an attribute given by its local name. If multiple attributes with the same local name (but different namespace prefixes) exist, the value of
	 * the attribute with no namespace URI will be returned, otherwise, if all attributes are namespace qualified, the first attribute with that local name will be
	 * returned. A {@link KDMImportException} will be thrown, if the given attribute set does not contain the given local attribute name.
	 *
	 * @param atts
	 *            The set of attributes.
	 * @param localName
	 *            The local name of the attribute to get its value.
	 * @return The value of the attribute with the given local name.
	 * @throws KDMImportException
	 *             If the given attribute set does not contain the given local attribute name.
	 */
	private String getValueByLocalName(final Attributes atts, final String localName) throws KDMImportException {

		for (int i = 0; i < atts.getLength(); i++) {
			if (atts.getLocalName(i).equalsIgnoreCase(localName)) {
				String value = atts.getValue(i);
				if (value.startsWith(":")) {
					value = value.substring(1);
				}
				return value;
			}
		}
		final String error = "KDM file is currupt. Attribute set matching KDM id = " + atts.getValue(atts.getLength() - 1)
				+ " does not contain an attribute with local name = " + localName + ", but by specification it should do.";
		LOGGER.error(error);
		throw new KDMImportException(error);
	}

	/**
	 * Indicates whether the specified attribute set contains an attribute with the given local name.
	 *
	 * @param atts
	 *            The attribute set in which the specified attribute is to be searched.
	 * @param localName
	 *            The attribute's local name to determine its presence in the given attribute set.
	 * @return {@code True}, if the given attribute set contains the specified attribute, {@code false} otherwise.
	 */
	private boolean hasAttribute(final Attributes atts, final String localName) {

		for (int i = 0; i < atts.getLength(); i++) {
			if (atts.getLocalName(i).equalsIgnoreCase(localName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a {@link CodeElement} instance of the given class in the current stack ({@link #stack}). If multiple objects of this class are contained in the stack,
	 * the first element from top to stack bottom will be returned. If no such element could be found in the stack, {@code null} will be returned.
	 *
	 * @param clazz
	 *            The class of which the returned object is supposed to be.
	 * @return The first object in the stack of the specified class searched for from stack top to bottom or {@code null}, if no such object could be found.
	 */
	private CodeElement getStackElement(final Class<? extends CodeElement> clazz) {

		for (CodeElement element : this.stack) {
			if (clazz.isInstance(element)) {
				return element;
			}
		}
		return null;
	}

	// ============================= Unused Methods ===========================

	/*
	 * The following methods handle XML elements which have no special meaning for our purpose. However, they have to be implemented as declared in the
	 * 'ContentHandler' interface. Therefore, their class bodies remain empty.
	 */

	@Override
	public void startDocument() throws SAXException { /* nothing to do */}

	@Override
	public void setDocumentLocator(final Locator locator) { /* nothing to do */}

	@Override
	public void startPrefixMapping(final String prefix, final String uri) throws SAXException { /* nothing to do */}

	@Override
	public void endPrefixMapping(final String prefix) throws SAXException { /* nothing to do */}

	@Override
	public void characters(final char[] charac, final int start, final int length) throws SAXException { /* nothing to do */}

	@Override
	public void ignorableWhitespace(final char[] charac, final int start, final int length) throws SAXException { /* nothing to do */}

	@Override
	public void processingInstruction(final String target, final String data) throws SAXException { /* nothing to do */}

	@Override
	public void skippedEntity(final String name) throws SAXException { /* nothing to do */}

}
