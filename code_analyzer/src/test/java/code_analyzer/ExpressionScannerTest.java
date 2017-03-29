package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExpressionScannerTest {

	@Test
	public void test() {
		// BatchFileReader batchFileReader = new BatchFileReader();
		// String testString = batchFileReader.readFilesContent(new
		// SourceFolderScanner().getFileList());
		String testString = "dgaht  erfg   // %f ;  \\srthgrhy: ";
		ExpressionScanner expressionScanner = new ExpressionScanner(testString);
		String result = expressionScanner.getNextExpression();
		System.out.println(result);
		assertTrue("wrong result: " + result, result.equals("dgaht erfg // %f"));
		result = expressionScanner.getNextExpression();
		assertTrue("wrong result: " + result, result.equals("\\srthgrhy:"));
		System.out.println(result);
	}

}
