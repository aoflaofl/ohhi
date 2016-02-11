package com.spamalot.ohhi;

import com.spamalot.ohhi.Cell.Color;

/**
 * Hold a collection of Cells and do operations on them.
 * 
 * @author johannsg
 *
 */
class CellGroup {
  /**
   * The number of Cells.
   */
  private int size;

  /**
   * The cells in this group.
   */
  private Cell[] cells;

  /**
   * Instantiate a cell group.
   * 
   * @param groupSize
   *          How big this cell group is.
   */
  CellGroup(final int groupSize) {
    size = groupSize;

    cells = new Cell[size];
  }

  /**
   * Add a cell to the group.
   * 
   * @param cell
   *          The cell to add
   * @param idx
   *          Where to add it
   */
  public final void addCell(final Cell cell, final int idx) {
    cells[idx] = cell;
  }

  /**
   * Handle rule of no three in a row.
   * 
   */
  public void findEmpty() {
    for (int i = 0; i < size - 3; i++) {
      threeCells(cells[i], cells[i + 1], cells[i + 2]);
      threeCells(cells[i + 1], cells[i], cells[i + 2]);
      threeCells(cells[i + 2], cells[i + 1], cells[i]);
    }
  }

  /**
   * Handle three cells in a row such that two are filled and they all three
   * can't be the same color.
   * 
   * @param cell1
   *          If empty, figure out if its color can be determined
   * @param cell2
   *          First cell to check
   * @param cell3
   *          Second cell to check
   */
  private static void threeCells(final Cell cell1, final Cell cell2, final Cell cell3) {
    if (cell1.isEmpty()) {
      if (cell2.equals(cell3)) {
        cell1.setColor(cell2.getColor().opposite());
      }
    }
  }

  /**
   * Handle Rule that the number of Red and Blue cells must be the same.
   */
  public void evenNumber() {
    int redCnt = countColor(Color.RED);
    int blueCnt = countColor(Color.BLUE);

    if (redCnt == size / 2) {
      fillEmptyWith(Cell.Color.BLUE);
    }

    if (blueCnt == size / 2) {
      fillEmptyWith(Cell.Color.RED);
    }
  }

  /**
   * Count color.
   * 
   * @param clr
   *          color to count
   * @return the number of cells with that color in this group
   */
  private int countColor(final Color clr) {
    int cnt = 0;

    for (int i = 0; i < size; i++) {
      if (cells[i].getColor() == clr) {
        cnt++;
      }
    }
    return cnt;
  }

  /**
   * Fill empty cells with a certain color.
   * 
   * @param color
   *          Color to fill empty cells with
   */
  private void fillEmptyWith(final Color color) {
    for (int i = 0; i < size; i++) {
      if (cells[i].isEmpty()) {
        cells[i].setColor(color);
      }
    }

  }

  /**
   * Count the empty cells.
   * 
   * @return the count of empty cells
   */
  public int emptyCount() {
    int cnt = 0;

    for (int i = 0; i < size; i++) {
      if (cells[i].isEmpty()) {
        cnt++;
      }
    }
    return cnt;

  }

  /**
   * Compare this CellGroup to another one, ignoring the empty cells in this
   * group.
   * 
   * @param cellGroup
   *          Group to compare to.
   * @return true if they match
   */
  public boolean compareExistingCells(final CellGroup cellGroup) {
    for (int i = 0; i < size; i++) {
      if (!cells[i].isEmpty()) {
        if (!cells[i].equals(cellGroup.cells[i])) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Use a full cell group to fix this.
   * 
   * @param cellGroup
   *          CellGroup to use to fix
   */
  public void fixCellGroup(final CellGroup cellGroup) {
    for (int i = 0; i < size; i++) {
      System.out.print("     Checking cell " + i + " ... ");

      if (cells[i].isEmpty()) {

        cells[i].setColor(cellGroup.cells[i].getColor().opposite());

      } else {
        System.out.println("Cell " + i + " is good");
      }

    }

  }

}
