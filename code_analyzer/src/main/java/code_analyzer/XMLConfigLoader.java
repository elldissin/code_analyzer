package code_analyzer;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLConfigLoader {
	Document doc;

	XMLConfigLoader() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			File inputFile = new File("xml_config.xml");

			DocumentBuilder builder = factory.newDocumentBuilder();
			// StringBuilder xmlStringBuilder = new StringBuilder();
			// xmlStringBuilder.append;
			// ByteArrayInputStream input = new
			// ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
			doc = builder.parse(inputFile);
			Element root = doc.getDocumentElement();
			System.out.println("Root element :" + root.getNodeName());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Document getDoc() {
		return doc;
	}

}
