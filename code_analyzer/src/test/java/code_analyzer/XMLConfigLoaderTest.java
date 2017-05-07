package code_analyzer;

import static org.junit.Assert.fail;

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
		}
		fail("Not yet implemented");
	}

}
