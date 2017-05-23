package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.NodeList;

public class XMLConfigLoaderTest {

	@Test
	public void testGetDoc() {
		XMLConfigLoader xMLConfigLoader = new XMLConfigLoader();
		NodeList NodeList = xMLConfigLoader.getDoc().getElementsByTagName("tablestart");
		for (int i = 0; i < NodeList.getLength(); i++) {
			System.out.println(NodeList.item(i).getNodeName());
			System.out.println(NodeList.item(i).getTextContent());
			assertTrue("Wrong XML node name", NodeList.item(i).getNodeName().equals("tablestart"));
			if (i == 0) {
				assertTrue("Wrong XML node name", NodeList.item(i).getTextContent().equals("one"));
			}
			if (i == 1) {
				assertTrue("Wrong XML node name", NodeList.item(i).getTextContent().equals("two"));
			}
		}
	}

}
