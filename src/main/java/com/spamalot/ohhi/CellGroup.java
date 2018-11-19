package com.spamalot.ohhi;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Hold a collection of Cells and do operations on them. A CellGroup represents
 * a row or column of cells, in order.
 * 
 * @author johannsg
 *
 */
class CellGroup {
  /** The cells in this group. */
  private Cell[] cells;

  /** The number of Cells in the Group. */
  private int size;

  /**
   * Instantiate a cell group.
   * 
   * @param groupSize
   *          How big this cell group is.
   */
  CellGroup(final int groupSize) {
    this.size = groupSize;

    this.cells = new Cell[this.size];
  }

  /**
   * Add a cell to the group.
   * 
   * @param cell
   *          The cell to add
   * @param idx
   *          Where to add it
   */
  @Deprecated
  public final void addCell(final Cell cell, final int idx) {
    this.cells[idx] = cell;
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
    for (int i = 0; i < this.size; i++) {
      if (!this.cells[i].isEmpty()) {
        if (!this.cells[i].equals(cellGroup.cells[i])) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Count the empty cells.
   * 
   * @return the count of empty cells
   */
  public int emptyCount() {
    int cnt = 0;

    for (int i = 0; i < this.size; i++) {
      if (this.cells[i].isEmpty()) {
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
  void fillEmptyWith(final CellValue color) {
    for (int i = 0; i < this.size; i++) {
      if (this.cells[i].isEmpty()) {
        this.cells[i].setColor(color);
      }
    }

  }

  /**
   * Use a full cell group to fix this.
   * 
   * @param cellGroup
   *          CellGroup to use to fix
   */
  public void fixCellGroup(final CellGroup cellGroup) {
    for (int i = 0; i < this.size; i++) {
      System.out.print("     Checking cell " + i + " ... ");

      if (this.cells[i].isEmpty()) {

        this.cells[i].setColor(cellGroup.cells[i].getCellValue().opposite());

      } else {
        System.out.println("Cell " + i + " is good");
      }
    }
  }

  /**
   * Get a cell.
   * 
   * @param i
   *          index of Cell to return
   * @return the Cell.
   */
  public Cell getCell(final int i) {
    return this.cells[i];
  }

  /**
   * Count the values in the cell group.
   * 
   * @return a Map of Cell Values to their count.
   */
  HashMap<CellValue, Integer> getCountMap() {
    HashMap<CellValue, Integer> m = new HashMap<>();

    for (int i = 0; i < this.size; i++) {

      CellValue c = this.cells[i].getCellValue();

      if (c == null) {
        continue;
      }

      if (m.get(c) == null) {
        m.put(c, Integer.valueOf(1));
        continue;
      }

      int p = m.get(c).intValue();
      m.put(c, Integer.valueOf(p + 1));
    }

    return m;
  }

  /**
   * Get the size of the Group.
   * 
   * @return the number of Cells in the Group.
   */
  public int getSize() {
    return this.size;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CellGroup [size=" + this.size + ", cells=" + Arrays.toString(this.cells) + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(this.cells);
    return prime * result + this.size;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    CellGroup other = (CellGroup) obj;
    if (!Arrays.equals(this.cells, other.cells)) {
      return false;
    }
    if (this.size != other.size) {
      return false;
    }
    return true;
  }
}
