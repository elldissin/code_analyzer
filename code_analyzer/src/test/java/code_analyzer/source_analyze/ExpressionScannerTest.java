package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.source_analyze.Expression;
import code_analyzer.source_analyze.ExpressionScanner;

public class ExpressionScannerTest {

	@Test
	public void getNextExpressionTest() {
		// BatchFileReader batchFileReader = new BatchFileReader();
		// String testString = batchFileReader.readFilesContent(new
		// SourceFolderScanner().getFileList());
		String testString = "dgaht  erfg   // %f ;  \\srthgrhy: ";
		ExpressionScanner expressionScanner = new ExpressionScanner(testString);
		Expression result = expressionScanner.getNextExpression();
		assertTrue("wrong result: " + result.toString(), result.toString().equals("dgaht erfg // %f"));
		result = expressionScanner.getNextExpression();
		assertTrue("wrong result: " + result.toString(), result.toString().equals("\\srthgrhy:"));
		assertTrue("expressionScanner must be empty already", expressionScanner.isEmpty());
	}

}
