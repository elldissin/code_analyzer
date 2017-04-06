package code_analyzer.codeElements;

public enum CodeElementType {
	TABLE(0), MODIFIER(1), FIELD(2), FIELD_PROPERTY(3), WRONGTYPE(-1);
	private int value;

	private CodeElementType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
