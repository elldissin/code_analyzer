package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class DBStructureMakerTest {
	DBStructureMaker dBStructureMaker = new DBStructureMaker();
	CodeElement codeElement = new Table();
	CodeElement codeElement1 = new Field();

	@Test
	public void putTableTest() {

		List<CodeElement> tableList = dBStructureMaker.getTableList();
		dBStructureMaker.putCodeElement(codeElement);
		assertTrue("wrong Table in DB " + tableList.get(0).getClass().getSimpleName(),
				tableList.get(0).getClass().getSimpleName().equals("Table"));
	}

	// @Test
	// public void putElementToParentTest() {
	// dBStructureMaker.putElementToParent(codeElement1);
	// List<CodeElement> tableList = dBStructureMaker.getTableList();
	// tableList.get(tableList.size()).getFieldList();
	//
	// }

}
