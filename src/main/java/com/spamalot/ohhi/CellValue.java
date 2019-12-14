package com.spamalot.ohhi;

/**
 * Possible Cell values.
 * 
 * @author johannsg
 *
 */
enum CellValue {
  /** The color Blue. */
  BLUE("B"),
  /** The color Red. */
  RED("R"),
  /** The no color color. */
  EMPTY(".");

  /**
   * What this color looks like when printed.
   */
  private String stringVal;

  /**
   * Color enum constructor.
   * 
   * @param val String representation for this Color.
   */
  CellValue(final String val) {
    this.stringVal = val;
  }

  /**
   * Get the opposite color.
   * 
   * @return the opposite color
   * 
   * 
   */
  public CellValue opposite() {
    if (this == RED) {
      return CellValue.BLUE;
    }
    return CellValue.RED;
  }

  @Override
  public String toString() {
    return this.stringVal;
  }
}
