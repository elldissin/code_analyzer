package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExpressionScannerTest {

	@Test
	public void getNextExpressionTest() {
		List<BufferedReader> bufferedReadersList = new ArrayList<BufferedReader>();
		bufferedReadersList.add(new BufferedReader(new StringReader("expr1;expr2();\n\rexpr3;")));
		bufferedReadersList.add(new BufferedReader(new StringReader("\rexpr4(0,1,2);\n\rexpr5();")));
		bufferedReadersList.add(new BufferedReader(new StringReader("expr6;\r\nexpr7();expr8(3,4,5)\n;")));
		ExpressionScanner expressionScanner = new ExpressionScanner(bufferedReadersList);

		Expression expression = expressionScanner.getNextExpression();
		assertTrue("expected expr1 but got " + expression.toString(), expression.toString().equals("expr1"));
		expression = expressionScanner.getNextExpression();
		assertTrue("expected expr2() but got " + expression.toString(), expression.toString().equals("expr2()"));
		for (int i = 0; i < 2; i++) {
			expression = expressionScanner.getNextExpression();
		}
		assertTrue("expected expr4(0,1,2) but got " + expression.toString(),
				expression.toString().equals("expr4(0,1,2)"));
		for (int i = 0; i < 4; i++) {
			expression = expressionScanner.getNextExpression();
		}
		assertTrue("expected expr8(3,4,5) but got " + expression.toString(),
				expression.toString().equals("expr8(3,4,5)"));
		expression = expressionScanner.getNextExpression();
		assertTrue("expected empty string but got " + expression.toString(), expression.toString().equals(""));
	}

}
