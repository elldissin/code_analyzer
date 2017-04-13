package code_analyzer.codeElements;

import code_analyzer.Configuration;

public class NameGiver {

	public String giveNameTo(DBElement element) {
		switch (element.getType()) {
		case TABLE:
			return giveNameToTable(element);
		}
		return null;
	}

	private String giveNameToTable(DBElement element) {
		Configuration configuration = new Configuration();

		String result1[], result2[];
		int i = 0;
		result1 = element.getExpression().toString().split(configuration.getTableKeyword());
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
		return result2[0];
		// FIXME wrong name
	}

}
