package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void saySomethingTest() {
		HelloWorld helloWorldTest = new HelloWorld();
		String result;
		result = helloWorldTest.saySomething();
		assertTrue(result.equals("Hello World"));
	}

}
