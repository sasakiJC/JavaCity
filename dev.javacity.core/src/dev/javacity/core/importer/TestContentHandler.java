package dev.javacity.core.importer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import dev.javacity.core.importer.exception.KDMImportException;
import dev.javacity.core.importer.kdm.KDMContentHandler;
import dev.javacity.core.models.TargetClass;
import dev.javacity.core.models.TargetClass.ClassType;
import dev.javacity.core.models.TargetEntity;
import dev.javacity.core.models.TargetMethod;
import dev.javacity.core.models.TargetPackage;

public class TestContentHandler implements ContentHandler {

	private static final Logger LOGGER = Logger.getLogger(KDMContentHandler.class);

	private Stack<TargetEntity> stack = new Stack<TargetEntity>();
	private Map<Integer, TargetEntity> idMap = new HashMap<Integer, TargetEntity>();

	@Override
	public void characters(final char[] charac, final int start, final int length) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void ignorableWhitespace(final char[] charac, final int start, final int length) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void processingInstruction(final String target, final String data) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void startDocument() throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void startPrefixMapping(final String prefix, final String uri) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}


	private void testCodeElementPrint(Attributes atts) {
		String temp = "<codeElement";
		for(int j=0;j<atts.getLength();j++) {
			temp += " " + atts.getQName(j) + "=" + atts.getValue(j);
		}
		temp += ">";
		System.out.println(temp);
//		for (int j = 0; j < atts.getLength(); j++) {
//		if (atts.getLocalName(j).equalsIgnoreCase("type")) {
//			System.out.println(atts.getValue(j));
//		}
//	}


//	System.out.println("qName : " + atts.getQName(i)+ ", URI : " + atts.getURI(i));
//	System.out.println("value: " + atts.getValue("xsi:type"));
	}


	@Override
	public void startElement(final String uri, final String localName, final String qName, final Attributes atts) throws SAXException {
		if ("codeElement".equalsIgnoreCase(localName)) {
			this.parseCodeElement(uri, localName, qName, atts);
		} else if("source".equalsIgnoreCase(localName)) {
//			this.parseSignature(atts);
		} else if("region".equalsIgnoreCase(localName)) {
			this.parseRegion(atts);
		} else if("codeRelation".equalsIgnoreCase(localName)) {

		} else if("parameterUnit".equalsIgnoreCase(localName)) {

		} else if ("itemUnit".equalsIgnoreCase(localName)) {

		}

//		if ("codeElement".equalsIgnoreCase(localName) && this.ignore == 0) {
//			final String type = this.getValueByLocalName(atts, "type");
//			if (type.endsWith("Package")) {
//				this.parsePackage(atts);
//			} else if (type.endsWith("ClassUnit")) {
//				this.parseClass(atts, ClassType.REGULAR);
//			} else if (type.endsWith("InterfaceUnit")) {
//				this.parseClass(atts, ClassType.INTERFACE);
//			} else if (type.endsWith("MethodUnit")) {
//				this.parseMethod(atts);
//			} else if (type.endsWith("StorableUnit")) {
//				final String kind = this.getValueByLocalName(atts, "kind");
//				if (kind.endsWith("global") || kind.endsWith("static")) {
//					final SClass clazz = (SClass) this.getStackElement(SClass.class);
//					clazz.setNumAttributes(clazz.getNumAttributes() + 1);
//				}
//				this.withinStorUnit = true;
//			} else {
//				this.ignore++;
//			}
//		} else if ("source".equalsIgnoreCase(localName) && this.hasAttribute(atts, "snippet")) {
//			this.parseSignature(atts);
//		} else if ("codeRelation".equalsIgnoreCase(localName) && !this.withinParamUnit && this.getStackElement(SMethod.class) == null
//				&& this.getStackElement(SClass.class) != null) {
//			this.parseRelation(atts);
//		} else if ("parameterUnit".equalsIgnoreCase(localName)) {
//			this.withinParamUnit = true;
//		}
	}





//	private void parseSignature(final Attributes atts) throws KDMImportException {
//		TargetMethod method = null;
//		if(!this.stack.isEmpty() && this.stack.peek() instanceof TargetMethod) {
//			method = (TargetMethod) this.stack.peek();
//		}
//
//		String signature = atts.getValue("snippet");
//		if(signature.endsWith("{}")) {
//			signature = signature.substring(0, signature.length() - 2).trim();
//		}
//
//		method.setSignature(signature);
//	}



	private void parseCodeElement(final String uri, final String localName, final String qName, final Attributes atts) {
		String type = atts.getValue("xsi:type");
		System.out.println(atts.getValue("xsi:type"));

		if(type.endsWith("Package")) {
			this.parsePackage(atts);
		} else if(type.endsWith("ClassUnit")) {
			this.parseClass(atts, ClassType.CONCRETE);
		} else if(type.endsWith("InterfaceUnit")) {
			this.parseClass(atts, ClassType.INTERFACE);
		} else if(type.endsWith("MethodUnit")) {
			this.parseMethod(atts);
		} else if(type.endsWith("StorableUnit")) {
			this.parseField(atts);
		}
	}

	private void parseField(final Attributes atts) throws KDMImportException {

	}


	private void parseMethod(final Attributes atts) throws KDMImportException {

		TargetEntity parent = null;
		if(!this.stack.empty()) {
			parent = this.stack.peek();
		}

		TargetMethod method = new TargetMethod(atts.getValue("name"));

		method.setParent(parent);
		parent.addChild(method);

		this.stack.add(0, method);
		this.idMap.put(Integer.valueOf(atts.getValue("xmi:id")), method);
	}

	private void parseClass(final Attributes atts, final ClassType type) throws KDMImportException {
		TargetEntity parent = null;
		if(!this.stack.empty()) {
			parent = this.stack.peek();
		}

		TargetClass clazz = new TargetClass(atts.getValue("name"), type);

		clazz.setParent(parent);
		parent.addChild(clazz);

		this.stack.add(0, clazz);
		this.idMap.put(Integer.valueOf(atts.getValue("xmi:id")), clazz);

//		if (!"<anonymous>".equals(clazz.getName())) {
//			currentPack.getSClasses().add(clazz);
//		}
//
//		if (type != ClassType.INTERFACE && "true".equalsIgnoreCase(this.getValueByLocalName(atts, "isAbstract"))) {
//			clazz.setType(ClassType.ABSTRACT);
//		}
	}

	private void parsePackage(final Attributes atts) throws KDMImportException {
		TargetEntity parent = null;
		if(!this.stack.empty()) {
			parent = this.stack.peek();
		}

		TargetPackage pack = new TargetPackage(atts.getValue("name"));

		pack.setParent(parent);
		parent.addChild(pack);

		this.stack.push(pack);
		this.idMap.put(Integer.valueOf(atts.getValue("xmi:id")), pack);
	}

	@Override
	public void endElement(final String uri, final String localName, final String qName) throws SAXException {
//		if(!this.stack.isEmpty()) {
//			TargetEntity element = this.stack.get(0);
//			this.stack.remove(0);
//		}
		if ("codeElement".equalsIgnoreCase(localName)) {
			TargetEntity element = this.stack.pop();
			this.stack.peek().addChild(element);
		} else if ("parameterUnit".equalsIgnoreCase(localName)) {
//			this.withinParamUnit = false;
		} else if ("storableUnit".equalsIgnoreCase(localName)) {
//			this.withinStorUnit = false;
		}

	}


}
