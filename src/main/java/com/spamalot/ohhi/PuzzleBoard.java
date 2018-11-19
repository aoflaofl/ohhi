package com.spamalot.ohhi;

import javax.annotation.Nullable;

/**
 * The PuzzleBoard Class. Hold contents of the Puzzle squares.
 * 
 * @author johannsg
 *
 */
class PuzzleBoard {
  /** Hold the Cells. */
  private Cell[][] cells;

  /** The rows CellGroups. */
  private CellGroup[] rows;

  /** The Columns Cell Groups. */
  private CellGroup[] columns;

  // TODO: Puzzles don't have to be square. Allow rectangles.
  /** Size of the puzzle. */
  private int size;

  /**
   * Instantiate a Puzzle.
   * 
   * @param s
   *          The size of the Puzzle.
   */
  PuzzleBoard(final int s) {
    this.size = s;
    this.cells = new Cell[s][s];
    this.rows = new CellGroup[s];
    this.columns = new CellGroup[s];

    for (int i = 0; i < s; i++) {
      this.rows[i] = new CellGroup(s);
      this.columns[i] = new CellGroup(s);
    }

    for (int row = 0; row < s; row++) {
      for (int column = 0; column < s; column++) {
        Cell cell = new Cell();
        this.cells[row][column] = cell;
        this.rows[row].addCell(cell, column);
        this.columns[column].addCell(cell, row);
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
  final void setCell(final CellValue color, final int row, final int col) {
    this.cells[row][col].setColor(color);
  }

  @Override
  public final String toString() {
    StringBuilder ret = new StringBuilder();

    for (int row = 0; row < this.size; row++) {
      for (int column = 0; column < this.size; column++) {
        ret.append(this.cells[row][column]);
      }
      ret.append('\n');
    }
    return ret.toString();
  }

  void domehtingSeomthing() {
    duplicateGroups(this.rows);
    duplicateGroups(this.columns);
  }

  private void duplicateGroups(final CellGroup[] group) {
    for (int i = 0; i < this.size; i++) {
      if (group[i].emptyCount() == 2) {
        System.out.println("Row " + i + " is missing two cells");
        CellGroup cg = findDuplicate(group, group[i]);
        if (cg != null) {
          System.out.println("  Now we have to fix row " + i);
          group[i].fixCellGroup(cg);
        }
      }
    }
  }

  @Nullable
  private CellGroup findDuplicate(final CellGroup[] rows2, final CellGroup cellGroup) {
    CellGroup ret = null;
    for (int i = 0; i < this.size; i++) {
      if (rows2[i].emptyCount() == 0) {
        if (cellGroup.compareExistingCells(rows2[i])) {
          System.out.println("  Row " + i + "  matches");
          return rows2[i];
        }
      }
    }

    return ret;
  }

  public CellGroup[] getRowCellGroups() {
    return this.rows;
  }

  public CellGroup[] getColumnCellGroups() {
    return this.columns;
  }

  /**
   * @return the size
   */
  public int getSize() {
    return this.size;
  }
}
