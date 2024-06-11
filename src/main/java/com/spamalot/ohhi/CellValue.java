
package com.spamalot.ohhi;

enum CellValue {
	BLUE("B"), RED("R"), EMPTY(".");

	private String stringVal;

	CellValue(String val) {
		this.stringVal = val;
	}

	public CellValue opposite() {
		return this == RED ? CellValue.BLUE : CellValue.RED;
	}

	@Override
	public String toString() {
		return this.stringVal;
	}
}
