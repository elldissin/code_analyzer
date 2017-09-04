package code_analyzer.db_elements;

public enum DBElementType {
	TABLE(0), MODIFIER(1), FIELD(2), FIELD_PROPERTY(3), WRONGTYPE(-1);
	private int value;

	private DBElementType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
