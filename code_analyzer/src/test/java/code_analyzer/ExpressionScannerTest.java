package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExpressionScannerTest {

	@Test
	public void getNextExpressionTest() {
		// BatchFileReader batchFileReader = new BatchFileReader();
		// String testString = batchFileReader.readFilesContent(new
		// SourceFolderScanner().getFileList());
		Configuration configuration = new Configuration();
		String testString = "dgaht  erfg   // %f ;  \\srthgrhy: ";
		ExpressionScanner expressionScanner = new ExpressionScanner(testString, configuration);
		Expression result = expressionScanner.getNextExpression();
		assertTrue("wrong result: " + result.toString(), result.toString().equals("dgaht erfg // %f"));
		result = expressionScanner.getNextExpression();
		assertTrue("wrong result: " + result.toString(), result.toString().equals("\\srthgrhy:"));
		assertTrue("expressionScanner must be empty already", expressionScanner.isEmpty());
	}

}
