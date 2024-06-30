
package com.spamalot.ohhi;

import java.util.Arrays;
import java.util.EnumMap;

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

  boolean fillEmptyWith(CellValue color) {
    boolean changeMade = false;
    for (Cell cell : this.cells) {
      if (cell.isEmpty()) {
        cell.setValue(color);
        changeMade = true;
      }
    }
    return changeMade;
  }

  void fixCellGroup(CellGroup cellGroup) {
    for (int i = 0; i < this.size; i++) {
      if (this.cells[i].isEmpty()) {
        this.cells[i].setValue(cellGroup.cells[i].getValue().opposite());
      }
    }
  }

  CellValue getCellValue(int i) {
    if (i < 0 || i >= this.size) {
      return CellValue.EMPTY;
    } else {
      return this.cells[i].getValue();
    }
  }

  Cell getCell(int i) {
    return this.cells[i];
  }

  EnumMap<CellValue, Integer> getCountMap() {
    EnumMap<CellValue, Integer> countMap = new EnumMap<>(CellValue.class);
    for (Cell cell : this.cells) {
      if (cell.getValue() != null && cell.getValue() != CellValue.EMPTY) {
        countMap.put(cell.getValue(), countMap.getOrDefault(cell.getValue(), 0) + 1);
      }
    }
    return countMap;
  }

  int getSize() {
    return this.size;
  }

  @Override
  public String toString() {
    return "CellGroup [size=" + this.size + ", cells=" + Arrays.toString(this.cells) + "]";
  }
}
