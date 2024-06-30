
package com.spamalot.ohhi;

class PuzzleBoard {
  private Cell[][] cells;
  private CellGroup[] rows;
  private CellGroup[] columns;
  private int size;

  PuzzleBoard(int s) {
    this.size = s;
    this.cells = new Cell[s][s];
    this.rows = new CellGroup[s];
    this.columns = new CellGroup[s];

    initializeBoard();
  }

  void setCell(CellValue color, int row, int col) {
    this.cells[row][col].setValue(color);
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    for (Cell[] cellRow : this.cells) {
      for (Cell cell : cellRow) {
        ret.append(cell);
      }
      ret.append('\n');
    }
    return ret.toString();
  }

  void processGroups() {
    processCellGroups(this.rows);
    processCellGroups(this.columns);
  }

  private void initializeBoard() {
    for (int i = 0; i < size; i++) {
      this.rows[i] = new CellGroup(size);
      this.columns[i] = new CellGroup(size);
    }

    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        Cell cell = new Cell();
        this.cells[row][column] = cell;
        this.rows[row].addCell(cell, column);
        this.columns[column].addCell(cell, row);
      }
    }
  }

  private void processCellGroups(CellGroup[] group) {
    for (int i = 0; i < this.size; i++) {
      if (group[i].emptyCount() == 2) {
        CellGroup cg = findDuplicate(group, group[i]);
        if (cg != null) {
          group[i].fixCellGroup(cg);
        }
      }
    }
  }

  private CellGroup findDuplicate(CellGroup[] groups, CellGroup cellGroup) {
    for (CellGroup group : groups) {
      if (group.emptyCount() == 0 && cellGroup.compareExistingCells(group)) {
        return group;
      }
    }
    return null;
  }

  public CellGroup[] getRowCellGroups() {
    return this.rows;
  }

  public CellGroup[] getColumnCellGroups() {
    return this.columns;
  }

  public int getSize() {
    return this.size;
  }
}
