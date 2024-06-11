package com.spamalot.ohhi;

class Cell {
	private CellValue value = CellValue.EMPTY;

	public CellValue getValue() {
		return this.value;
	}

	public boolean isEmpty() {
		return this.value == CellValue.EMPTY;
	}

	public void setValue(CellValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	public boolean isSameColor(Cell other) {
		return this.value == other.getValue();
	}
}
