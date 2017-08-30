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

/************************
 * 8月12日　佐々木改定
 * dynamicsLoad関連の削除
 */

package dev.javacity.core.models.data;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import data.statics.SClass;
import data.statics.SMethod;
import data.statics.SPackage;
import data.statics.impl.StaticsFactoryImpl;
import dev.javacity.core.importer.utils.KDMSignatureUtils;
import dev.javacity.core.importer.utils.SimplifiedSignatureUtils;
import dev.javacity.core.observer.AbstractObservable;
import dev.javacity.core.observer.ObservableAction;
import dev.javacity.core.utils.LoggerUtils;

/**
 * A data model to store the data objects parsed by a {@link IKdmImporter} and {@link KiekerImportFilter}.
 *
 * @author pdo
 *
 */
public class DataModel extends AbstractObservable {

	// =========================== Attributes =================================

	/** A logger to log relevant actions in this class. */
	private static final Logger LOGGER = Logger.getLogger(DataModel.class);

	/** The common regular base package of all packages in this data set. To be set manually by invoking {link {@link #setRootPackage(SPackage)}. */
	private SPackage rootPackage;

	/*
	 * The following attributes are not part of our data model definition. However, they serve to increase the performance of this data model making insert and read
	 * find operations much faster.
	 */

	/** A list of all {@link SClass} instances in this data model. */
	private final List<SClass> classes = new LinkedList<SClass>();

	/** A mapping from package KdmIds to their corresponding {@link SPackage} objects. */
	private final Map<String, SPackage> kdmToPackage = new HashMap<String, SPackage>(30);

	/** A mapping from class KdmIds to their corresponding {@link SClass} objects. */
	private final Map<String, SClass> kdmToClass = new LinkedHashMap<String, SClass>(100);

	/** A mapping from simple package names to their corresponding {@link SPackage} objects. */
	private final Map<String, SPackage> nameToPackage = new HashMap<String, SPackage>(30);

	/** A mapping from Kieker class signatures to their corresponding {@link SClass} objects. */
	private final Map<String, SClass> kiekerSignatureToClass = new HashMap<String, SClass>(100);

	/** A mapping from the KDM id of a class to a mapping of all its methods simple signatures to their method instances. */
	private final Map<String, Map<String, SMethod>> classKdmToMethods = new HashMap<String, Map<String, SMethod>>(100);

	// ========================== Constructor =================================

	/**
	 * Creates a new {@link DataModel} instance.
	 */
	public DataModel() {

		super();
	}

	// ============================ Methods ===================================

	/**
	 * Removes all objects in this {@link DataModel} instance. This data model will be empty after the call of this method returns.
	 */
	public void clearAll() {

		this.classes.clear();
		this.kdmToClass.clear();
		this.kdmToPackage.clear();
		this.nameToPackage.clear();
		this.classKdmToMethods.clear();
		this.kiekerSignatureToClass.clear();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully removed all objects from this model.");
		}

		super.notifyObservers(ObservableAction.ALL_CLEARED, null);
		System.gc();
	}

	/**
	 * Indicate, that all static information has been added to this {@link DataModel} instance. For each {@link SClass} instance in this data model a static class
	 * instance will be created and added to the list of class instances.
	 */
	public final void setStaticsLoaded() {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Set statics loaded.");
		}

		DataModelUtils.addInheritedMethods(this.rootPackage);
		for (SClass clazz : this.classes) {
			// import all contained methods
			final Map<String, SMethod> signatureToMethod = new HashMap<String, SMethod>((int) (clazz.getSMethods().size() * 4f / 3)); // ideal hashMap size
			for (SMethod sMethod : clazz.getSMethods()) {
				if (sMethod.getKdmSignature() != null) {
					try {
						final String simpleSig = KDMSignatureUtils.toSimplifiedSignature(sMethod.getKdmSignature());
						sMethod.setSimpleSignature(simpleSig);
						signatureToMethod.put(simpleSig, sMethod);
					} catch (IndexOutOfBoundsException e) {
						LOGGER.warn("Method with KDM id " + sMethod.getKdmId() + " has an invalid signature " + sMethod.getKdmSignature() + ".");
					}
				}

				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Successfully added method " + LoggerUtils.toLogString(sMethod) + " to data model.");
				}
			}

			this.classKdmToMethods.put(clazz.getKdmId(), signatureToMethod);
		}

		super.notifyObservers(ObservableAction.STATICS_LOADED, this.rootPackage);
	}

	/**
	 * Set the {@code rootPackage} attribute of this {@link DataModel} instance.
	 *
	 * @param root
	 *            The value of the root package attribute to set. {@code null} not permitted.
	 * @throws IllegalArgumentException
	 *             If the input package is {@code null} or does not contain any sub-packages.
	 */
	public final void setRootPackage(final SPackage root) throws IllegalArgumentException {

		if (root == null) {
			throw new IllegalArgumentException("You cannot set a null root package.");
		}
		if (root.getSubPackages().isEmpty()) {
			throw new IllegalArgumentException("The given root package does not contain any subpackages.");
		}

		this.rootPackage = root;

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully set package " + LoggerUtils.toLogString(root) + " as root package.");
		}
	}

	/**
	 * Add a {@link SPackage} instance to this {@link DataModel}.
	 *
	 * @param sPackage
	 *            The package to add. {@code Null} packages are not allowed.
	 * @throws IllegalArgumentException
	 *             If the package passed in or its name is {@code null}.
	 */
	public final void addPackage(final SPackage sPackage) throws IllegalArgumentException {

		if (sPackage == null) {
			throw new IllegalArgumentException("You cannot add a null package.");
		}

		if (sPackage.getName() == null) {
			throw new IllegalArgumentException("The name of the package passed in is null.");
		}

		// import package
		this.kdmToPackage.put(sPackage.getKdmId(), sPackage);
		this.nameToPackage.put(sPackage.getName(), sPackage);

		for (SClass sClass : sPackage.getSClasses()) {

			// import all contained classes
			this.kdmToClass.put(sClass.getKdmId(), sClass);
			this.kiekerSignatureToClass.put(sPackage.getName() + "." + sClass.getName(), sClass);

			// add static class object
			this.classes.add(sClass);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Successfully added class " + LoggerUtils.toLogString(sClass) + " to data model.");
			}
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Successfully added package " + LoggerUtils.toLogString(sPackage) + " to data model.");
		}
	}


	/**
	 * Get a list of all {@link SPackage} instances currently contained in this data model. A copy of an original list in this {@link DataModel} instance will be
	 * returned, so that changes in the returned list have no effect on this data model.
	 *
	 * @return A list of all packages in this data model.
	 */
	public final List<SPackage> getPackages() {

		final List<SPackage> retval = new LinkedList<SPackage>();
		for (SPackage pack : this.nameToPackage.values()) {
			retval.add(pack);
		}
		return retval;
	}

	/**
	 * Get a {@link SPackage} instance in this {@link DataModel} instance by its KDM-Id.
	 *
	 * @param kdmId
	 *            The Kdm-Id of the package.
	 * @return The package with the given KDM-Id or {@code null}, if no such package exists in this data set.
	 * @throws IllegalArgumentException
	 *             If the KDM id passed in is {@code null}.
	 */
	public final SPackage getPackageByKdmId(final String kdmId) throws IllegalArgumentException {

		if (kdmId == null) {
			throw new IllegalArgumentException("The KDM id passed in is null.");
		}
		return this.kdmToPackage.get(kdmId);
	}

	/**
	 * Get a {@link SPackage} instance in this {@link DataModel} instance by its name.
	 *
	 * @param name
	 *            The name of the package. <code>null</code> not permitted.
	 * @return The package with the given name or {@code null}, if no such package exists in this data set.
	 * @throws IllegalArgumentException
	 *             If the string passed in is {@code null}.
	 */
	public final SPackage getPackageByName(final String name) throws IllegalArgumentException {

		if (name == null) {
			throw new IllegalArgumentException("Name argument is null.");
		}
		return this.nameToPackage.get(name);
	}

	/**
	 * Get a {@link SClass} instance in this {@link DataModel} instance by its KDM id.
	 *
	 * @param kdmId
	 *            The KDM-Id of the class.
	 * @return The {@link SClass} object with the given KDM id or {@code null}, if no such class exists in this data set.
	 * @throws IllegalArgumentException
	 *             If the KDM id passed in is {@code null}.
	 */
	public final SClass getClassByKdmId(final String kdmId) throws IllegalArgumentException {

		if (kdmId == null) {
			throw new IllegalArgumentException("The KDM id passed in is null.");
		}

		return this.kdmToClass.get(kdmId);
	}

	/**
	 * Get a {@link SClass} instance in this {@link DataModel} instance by its Kieker class signature.
	 *
	 * @param signature
	 *            The Kieker class signature of the class to get.
	 * @return The {@link SClass} object with the given Kieker class signature or {@code null}, if no such class exists in this data set.
	 * @throws IllegalArgumentException
	 *             If the signature passed in is {@code null}.
	 */
	public final SClass getClassByKiekerClassSignature(final String signature) throws IllegalArgumentException {

		if (signature == null) {
			throw new IllegalArgumentException("The Kieker signature passed in is null.");
		}

		return this.kiekerSignatureToClass.get(signature);
	}

	/**
	 * Returns the {@link SMethod} with the given simplified signature of the specified class or {@code null}, if no such class exists.
	 *
	 * @param sClass
	 *            The class the method to return belongs to.
	 * @param signature
	 *            The simplified signature of the method to get.
	 * @return The method with the given simplified signature being a member of the specified class or {@code null}, if no such method exists in this data set.
	 * @throws IllegalArgumentException
	 *             If either the class or signature passed in is {@code null}.
	 */
	public final SMethod getMethodBySimplifiedSignature(final SClass sClass, final String signature) throws IllegalArgumentException {

		if (sClass == null) {
			throw new IllegalArgumentException("The sClass object passed in is null.");
		}
		if (signature == null) {
			throw new IllegalArgumentException("The simplified signature passed in is null.");
		}

		final Map<String, SMethod> methods = this.classKdmToMethods.get(sClass.getKdmId());
		SMethod method = methods.get(signature);
		if (method == null) {
			final String methodName = SimplifiedSignatureUtils.getMethodName(signature);
			for (Map.Entry<String, SMethod> entry : methods.entrySet()) {
				if (entry.getValue().getName().equals(methodName)) {
					entry.getValue().setSimpleSignature(signature);
					return entry.getValue();
				}
			}

			final String defaultConstrName = sClass.getName() + "()";
			if (defaultConstrName.equals(signature)) {
				// method is default constructor not being declared in the KDM file: create it now.
				method = StaticsFactoryImpl.eINSTANCE.createSMethod();
				method.setKdmId(null);
				method.setSClass(sClass);
				method.setName(sClass.getName());
				method.setKdmSignature(defaultConstrName);
				method.setSimpleSignature(defaultConstrName);
				sClass.getSMethods().add(method);
			} else if (LOGGER.isDebugEnabled()) {
				LOGGER.warn("Found no method named " + methodName + " in class " + sClass.getName() + ".");
			}
		} else {
			method.setSimpleSignature(signature);
		}

		return method;
	}


	/**
	 * Returns the common root package of all {@link SPackage} instances in this data model as set by {@link #setRootPackage(SPackage)}.
	 *
	 * @return The root package in this data model or {@code null}, if no root package has been set.
	 */
	public SPackage getRoot() {
		return this.rootPackage;
	}

}
