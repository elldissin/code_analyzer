package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameGiverTest {

	@Test
	public void giveNameTest() {
		NameGiver nameGiverTest = new NameGiver();
		String givenName;
		CodeElement elementTest = new Table("Table(Name,0,\"\")");
		givenName = nameGiverTest.giveNameTo(elementTest);
		assertTrue("Expected name NameTable, got " + givenName, givenName.equals("Name"));
	}

}
