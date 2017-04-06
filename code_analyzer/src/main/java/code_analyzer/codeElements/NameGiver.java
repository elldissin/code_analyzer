package code_analyzer.codeElements;

public class NameGiver {

	public String giveNameTo(CodeElement element) {
		switch (element.getType()) {
		case TABLE:
			return giveNameToTable(element);
		}
		return null;
	}

	private String giveNameToTable(CodeElement element) {
		String result1[], result2[];
		int i = 0;
		result1 = element.getExpression().split("Table");
		result2 = result1[1].split(",");
		for (i = 0; i < result2.length; i++) {
			result2[i] = result2[i].trim();
		}
		StringBuffer stringBuffer = new StringBuffer(result2[0]);
		stringBuffer.deleteCharAt(0);
		result2[0] = stringBuffer.toString();

		int lastSymbol = result2[2].length() - 1;
		stringBuffer = new StringBuffer(result2[2]);
		stringBuffer.deleteCharAt(lastSymbol);
		result2[2] = stringBuffer.toString();

		for (i = 0; i < result2.length; i++) {
			System.out.println(result2[i]);
		}
		return result2[0];
	}

}
