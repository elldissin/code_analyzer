package code_analyzer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArgumentFinderTest {

	@Test
	public void testGetArgumentListFor() {
		Configuration configTest = new Configuration();
		ArgumentFinder argumentFinderTest = new ArgumentFinder(configTest.getArgumentFinderRegex());
		List<ExpressionArgument> argumentListTest = new ArrayList<ExpressionArgument>();
		argumentListTest = argumentFinderTest.getArgumentListFor("Something(\"aa\",0,\"dd\")");
		String firstArgumentName, firstArgumentValue, firstArgumentType;
		firstArgumentName = argumentListTest.get(0).getName();
		firstArgumentValue = argumentListTest.get(0).getValue();
		firstArgumentType = argumentListTest.get(0).getType();
		assertTrue("Wrong argument name:" + firstArgumentName, firstArgumentName.equals("StubName"));
		assertTrue("Wrong argument type:" + firstArgumentType, firstArgumentType.equals("StubType"));
		assertTrue("Wrong argument value:" + firstArgumentValue, firstArgumentValue.equals("\"aa\""));
	}

}
