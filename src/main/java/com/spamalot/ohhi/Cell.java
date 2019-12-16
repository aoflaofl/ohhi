package com.spamalot.ohhi;

/**
 * Hold an individual cell.
 * 
 * @author johannsg
 *
 */
class Cell {

  /** The value in this cell. */
  private CellValue value = CellValue.EMPTY;

  /**
   * Get this cell's value.
   * 
   * @return the Cell's value.
   */
  public final CellValue getCellValue() {
    return this.value;
  }

  /**
   * Check if a cell is empty.
   * 
   * @return True if this cell has no color
   */
  public boolean isEmpty() {
    return this.value == CellValue.EMPTY;
  }

  /**
   * Set the cell's color.
   * 
   * @param c the color to set the cell to
   */
  public final void setCellValue(final CellValue c) {
    this.value = c;
  }

  @Override
  public String toString() {
    return this.value.toString();
  }

  public boolean hasSameColorAs(Cell cell) {
    return this.value == cell.getCellValue();
  }
}
