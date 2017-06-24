package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLConfigLoaderTest {

	@Test
	public void testGetDoc() {
		XMLConfigLoader xMLConfigLoader = new XMLConfigLoader();
		Element root;
		root = xMLConfigLoader.getDoc().getDocumentElement();
		System.out.println(root.getNodeName());
		System.out.println(root.getTagName());
		NodeList NodeList = root.getChildNodes();
		System.out.println(NodeList.getLength() + "  " + NodeList.item(3).getNodeName());
		for (int i = 0; i < NodeList.getLength(); i++) {
			if (NodeList.item(i).getNodeName() == "tablekeyword")
				assertTrue("Wrong XML node name", NodeList.item(i).getTextContent().equals("tableStart"));
			if (NodeList.item(i).getNodeName() == "fieldkeyword")
				assertTrue("Wrong XML node name", NodeList.item(i).getTextContent().equals("field"));
		}
	}

}
