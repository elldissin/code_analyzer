package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code_analyzer.source_analyze.ArgumentFinder;
import code_analyzer.source_analyze.Configuration;
import code_analyzer.source_analyze.ExpressionArgument;

public class ArgumentFinderTest {

	@Test
	public void testGetArgumentListFor() {
		ArgumentFinder argumentFinderTest = new ArgumentFinder(Configuration.getProperty("ArgumentFinderRegex"));
		List<ExpressionArgument> argumentListTest = new ArrayList<ExpressionArgument>();
		// test for no parameters
		argumentListTest = argumentFinderTest.getArgumentListFor("Something");
		assertTrue("Must have no parameters, but has " + argumentListTest.size(), argumentListTest.size() == 0);

		// test for three and four arguments, spaces made intentionally
		argumentListTest = argumentFinderTest.getArgumentListFor("Something(0, 1, 2)");
		for (int i = 0; i < argumentListTest.size(); i++) {
			ExpressionArgument testedArgument = argumentListTest.get(i);
			assertTrue("Wrong argument " + (i + 1) + " name:" + testedArgument.getName(),
					testedArgument.getName().equals("argument" + (i + 1)));
			assertTrue("Wrong argument " + (i + 1) + " type:" + testedArgument.getType(),
					testedArgument.getType().equals("StubType"));
			assertTrue("Wrong argument " + (i + 1) + " value:" + testedArgument.getValue(),
					testedArgument.getValue().equals("" + i));
		}
		argumentListTest = argumentFinderTest.getArgumentListFor("Something(0  ,1,2  ,3)");
		for (int i = 0; i < argumentListTest.size(); i++) {
			ExpressionArgument testedArgument = argumentListTest.get(i);
			assertTrue("Wrong argument " + (i + 1) + " name:" + testedArgument.getName(),
					testedArgument.getName().equals("argument" + (i + 1)));
			assertTrue("Wrong argument " + (i + 1) + " type:" + testedArgument.getType(),
					testedArgument.getType().equals("StubType"));
			assertTrue("Wrong argument " + (i + 1) + " value:" + testedArgument.getValue(),
					testedArgument.getValue().equals("" + i));
		}
	}

}
