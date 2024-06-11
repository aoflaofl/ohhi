
package com.spamalot.ohhi;

import java.util.Arrays;
import java.util.HashMap;

class CellGroup {
	private Cell[] cells;
	private int size;

	CellGroup(int groupSize) {
		this.size = groupSize;
		this.cells = new Cell[this.size];
	}

	void addCell(Cell cell, int idx) {
		this.cells[idx] = cell;
	}

	boolean compareExistingCells(CellGroup cellGroup) {
		for (int i = 0; i < this.size; i++) {
			if (!this.cells[i].isEmpty() && !this.cells[i].isSameColor(cellGroup.cells[i])) {
				return false;
			}
		}
		return true;
	}

	int emptyCount() {
		int cnt = 0;
		for (Cell cell : this.cells) {
			if (cell.isEmpty()) {
				cnt++;
			}
		}
		return cnt;
	}

	void fillEmptyWith(CellValue color) {
		for (Cell cell : this.cells) {
			if (cell.isEmpty()) {
				cell.setValue(color);
			}
		}
	}

	void fixCellGroup(CellGroup cellGroup) {
		for (int i = 0; i < this.size; i++) {
			if (this.cells[i].isEmpty()) {
				this.cells[i].setValue(cellGroup.cells[i].getValue().opposite());
			}
		}
	}

	Cell getCell(int i) {
		return this.cells[i];
	}

	HashMap<CellValue, Integer> getCountMap() {
		HashMap<CellValue, Integer> m = new HashMap<>();
		for (Cell cell : this.cells) {
			CellValue c = cell.getValue();
			if (c != null) {
				m.put(c, m.getOrDefault(c, 0) + 1);
			}
		}
		return m;
	}

	int getSize() {
		return this.size;
	}

	@Override
	public String toString() {
		return "CellGroup [size=" + this.size + ", cells=" + Arrays.toString(this.cells) + "]";
	}
}
