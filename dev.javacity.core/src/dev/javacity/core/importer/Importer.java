package dev.javacity.core.importer;

import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import dev.javacity.core.models.TestDataModel;

public class Importer {

	public TestDataModel importFromFile(final InputStream stream) {
		try {
			// setting up reader
			final XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			final InputSource inputSource = new InputSource(stream);
			xmlReader.setContentHandler(new TestContentHandler());

			InputSource test = new InputSource();

			xmlReader.parse(inputSource);
		} catch (Exception e) {
			System.out.println(stream);
		}
		return null;

	}

}
