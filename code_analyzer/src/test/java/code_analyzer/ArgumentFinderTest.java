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
		String secondArgumentName, secondArgumentValue, secondArgumentType;
		String thirdArgumentName, thirdArgumentValue, thirdArgumentType;
		firstArgumentName = argumentListTest.get(0).getName();
		firstArgumentValue = argumentListTest.get(0).getValue();
		firstArgumentType = argumentListTest.get(0).getType();

		secondArgumentName = argumentListTest.get(1).getName();
		secondArgumentValue = argumentListTest.get(1).getValue();
		secondArgumentType = argumentListTest.get(1).getType();

		thirdArgumentName = argumentListTest.get(2).getName();
		thirdArgumentValue = argumentListTest.get(2).getValue();
		thirdArgumentType = argumentListTest.get(2).getType();
		assertTrue("Wrong argument 1 name:" + firstArgumentName, firstArgumentName.equals("StubName"));
		assertTrue("Wrong argument 1 type:" + firstArgumentType, firstArgumentType.equals("StubType"));
		assertTrue("Wrong argument 1 value:" + firstArgumentValue, firstArgumentValue.equals("\"aa\""));

		assertTrue("Wrong argument 2 name:" + secondArgumentName, secondArgumentName.equals("StubName"));
		assertTrue("Wrong argument 2 type:" + secondArgumentType, secondArgumentType.equals("StubType"));
		assertTrue("Wrong argument 2 value:" + secondArgumentValue, secondArgumentValue.equals("0"));

		assertTrue("Wrong argument 3 name:" + thirdArgumentName, thirdArgumentName.equals("StubName"));
		assertTrue("Wrong argument 3 type:" + thirdArgumentType, thirdArgumentType.equals("StubType"));
		assertTrue("Wrong argument 3 value:" + thirdArgumentValue, thirdArgumentValue.equals("\"dd\""));
	}

}
