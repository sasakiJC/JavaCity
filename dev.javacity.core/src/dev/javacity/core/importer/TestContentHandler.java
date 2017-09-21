package dev.javacity.core.importer;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import dev.javacity.core.importer.kdm.KDMContentHandler;

public class TestContentHandler implements ContentHandler {

	private static final Logger LOGGER = Logger.getLogger(KDMContentHandler.class);

	@Override
	public void characters(final char[] charac, final int start, final int length) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void endDocument() throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
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
	public void startElement(final String uri, final String localName, final String qName, final Attributes atts) throws SAXException {
		System.out.println("URI : " + uri + ", localName : " + localName + ", qName : " + qName + ", atts : " + atts + "\n");

		if ("codeElement".equalsIgnoreCase(localName)) {

		}
	}

	@Override
	public void startPrefixMapping(final String prefix, final String uri) throws SAXException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
