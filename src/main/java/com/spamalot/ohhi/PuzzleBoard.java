package com.spamalot.ohhi;

/**
 * The Puzzle Class.
 * 
 * @author johannsg
 *
 */
class PuzzleBoard {
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
  PuzzleBoard(final int size) {
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
//  final void threeInARow() {
//    for (int i = 0; i < size; i++) {
//      rows[i].findEmpty();
//      columns[i].findEmpty();
//    }
//  }

  /**
   * Handle case where number of Red and Blue cells must be the same.
   */
  final void evenNumber() {
    for (int i = 0; i < size; i++) {
      rows[i].evenNumber();
      columns[i].evenNumber();
    }
  }

  void domehtingSeomthing() {
    duplicateGroups(rows);
    duplicateGroups(columns);
  }

  private void duplicateGroups(final CellGroup[] group) {
    for (int i = 0; i < size; i++) {
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

  private CellGroup findDuplicate(final CellGroup[] rows2, final CellGroup cellGroup) {
    CellGroup ret = null;
    for (int i = 0; i < size; i++) {
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
    return rows;
  }

  public CellGroup[] getColumnCellGroups() {
    return columns;
  }
}
