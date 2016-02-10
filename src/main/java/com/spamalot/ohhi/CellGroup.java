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
   * @param color
   *          Color to scan for.
   */
  public void findEmpty(final Cell.Color color) {
    Cell.Color oppo = color.opposite();

    for (int i = 0; i < size; i++) {
      if (cells[i].isEmpty()) {
        if (i >= 2) {

          if (cells[i - 1].getColor() == oppo && cells[i - 2].getColor() == oppo) {
            cells[i].setColor(color);
          }

        }

        if (i >= 1 && i <= size - 2) {

          if (cells[i - 1].getColor() == oppo && cells[i + 1].getColor() == oppo) {
            cells[i].setColor(color);
          }

        }

      }
    }
  }

  /**
   * Handle Rule that the number of Red and Blue cells must be the same.
   */
  public void evenNumber() {
    int redCnt = 0;
    int blueCnt = 0;

    for (int i = 0; i < size; i++) {
      if (cells[i].getColor() == Cell.Color.RED) {
        redCnt++;
      }
      if (cells[i].getColor() == Cell.Color.BLUE) {
        blueCnt++;
      }
    }

    if (redCnt == size / 2) {
      fillEmptyWith(Cell.Color.BLUE);
    }
    if (blueCnt == size / 2) {
      fillEmptyWith(Cell.Color.RED);

    }

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

}
