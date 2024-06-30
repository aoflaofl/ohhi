
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

  private void setCell(CellValue color, int row, int col) {
    cells[row][col].setValue(color);
  }

  @Override
  public String toString() {
    StringBuilder boardRepresentation = new StringBuilder();
    for (Cell[] cellRow : this.cells) {
      appendRowToString(cellRow, boardRepresentation);
    }
    return boardRepresentation.toString();
  }

  private void appendRowToString(Cell[] cellRow, StringBuilder boardRepresentation) {
    for (Cell cell : cellRow) {
      boardRepresentation.append(cell);
    }
    boardRepresentation.append('\n');
  }

  private void initializeBoard() {
    initializeCellGroups();
    createAndAssignCells();
  }

  private void initializeCellGroups() {
    for (int i = 0; i < size; i++) {
      this.rows[i] = new CellGroup(size);
      this.columns[i] = new CellGroup(size);
    }
  }

  private void createAndAssignCells() {
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        Cell cell = new Cell();
        assignCellToBoard(cell, row, column);
      }
    }
  }

  private void assignCellToBoard(Cell cell, int row, int column) {
    this.cells[row][column] = cell;
    this.rows[row].addCell(cell, column);
    this.columns[column].addCell(cell, row);
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

  void setInitialCells(CellValue cellValue, int[][] cells) {
    setCells(cellValue, cells);
  }

  private void setCells(CellValue cellValue, int[][] cells) {
    for (int[] cell : cells) {
      setCell(cellValue, cell[0], cell[1]);
    }
  }
}
