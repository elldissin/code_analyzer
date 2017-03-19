package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void saySomethingTest() {
		HelloWorld helloWorldTest1 = new HelloWorld();
		String result;
		result = helloWorldTest1.saySomething();
		assertTrue(result.equals("Hello World"));
	}

}
