package com.spamalot.ohhi;

import com.spamalot.ohhi.Cell.Color;

/**
 * The Puzzle Class.
 * 
 * @author johannsg
 *
 */
class Puzzle {
  /**
   * Hold the Cells.
   */
  private Cell[][] cells;
  /**
   * The rows CellGroups.
   */
  private CellGroup[] rows;
  /**
   * The Columns Cell Groups.
   */
  private CellGroup[] columns;

  /**
   * Size of the puzzle.
   */
  private int size;

  /**
   * Instantiate a Puzzle.
   * 
   * @param size
   *          The size of the Puzzle.
   */
  Puzzle(final int size) {
    this.size = size;
    cells = new Cell[size][size];
    rows = new CellGroup[size];
    columns = new CellGroup[size];

    for (int i = 0; i < size; i++) {
      rows[i] = new CellGroup(size);
      columns[i] = new CellGroup(size);
    }

    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        Cell cell = new Cell();
        cells[row][column] = cell;
        rows[row].addCell(cell, column);
        columns[column].addCell(cell, row);
      }
    }
  }

  /**
   * Set a cell's color.
   * 
   * @param color
   *          Color to set
   * @param row
   *          Row the cell is in
   * @param col
   *          Column the cell is in
   */
  final void setCell(final Cell.Color color, final int row, final int col) {
    cells[row][col].setColor(color);
  }

  @Override
  public final String toString() {
    StringBuffer ret = new StringBuffer();

    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        ret.append(cells[row][column]);
      }
      ret.append("\n");
    }
    return ret.toString();
  }

  /**
   * Handle Case of three in a row.
   */
  final void threeInARow() {
    for (int i = 0; i < size; i++) {
      rows[i].findEmpty(Color.BLUE);
      rows[i].findEmpty(Color.RED);
      columns[i].findEmpty(Color.BLUE);
      columns[i].findEmpty(Color.RED);
    }
  }

  /**
   * Handle case where number of Red and Blue cells must be the same.
   */
  final void evenNumber() {
    for (int i = 0; i < size; i++) {
      rows[i].evenNumber();
      columns[i].evenNumber();
    }
  }
}
