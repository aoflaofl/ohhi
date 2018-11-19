package com.spamalot.ohhi;

/**
 * Hold an individual cell.
 * 
 * @author johannsg
 *
 */
class Cell {

  /** The value in this cell. */
  private CellValue value;

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
    Cell other = (Cell) obj;
    if (other.value == null) {
      return false;
    }
    if (this.value != other.value) {
      return false;
    }
    return true;
  }

  /**
   * Get this cell's value.
   * 
   * @return the Cell's value.
   */
  public final CellValue getCellValue() {
    return this.value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    return prime * result + ((this.value == null) ? 0 : this.value.hashCode());
  }

  /**
   * Check if a cell is empty.
   * 
   * @return True if this cell has no color
   */
  public boolean isEmpty() {
    return this.value == null;
  }

  /**
   * Set the cell's color.
   * 
   * @param c
   *          the color to set the cell to
   */
  public final void setColor(final CellValue c) {
    this.value = c;
  }

  @Override
  public String toString() {
    if (this.value != null) {
      return this.value.toString();
    }
    return ".";
  }

}
