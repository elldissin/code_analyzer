package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TableListMakerTest {

	@Test
	public void test() {
		String fullFile = "tableStart(Name, 0, \" \")";
		String result1[], result2[];
		int i = 0;
		result1 = fullFile.split("tableStart");

		result2 = result1[1].split(",");
		for (i = 0; i < result2.length; i++) {
			result2[i] = result2[i].trim();
		}
		StringBuffer stringBuffer = new StringBuffer(result2[0]);
		stringBuffer.deleteCharAt(0);
		result2[0] = stringBuffer.toString();

		int lastSymbol = result2[2].length() - 1;
		stringBuffer = new StringBuffer(result2[2]);
		stringBuffer.deleteCharAt(lastSymbol);
		result2[2] = stringBuffer.toString();

		for (i = 0; i < result2.length; i++) {
			System.out.println(result2[i]);
		}
		assertTrue("name not found", result2[0].equals("Name"));
	}

}
