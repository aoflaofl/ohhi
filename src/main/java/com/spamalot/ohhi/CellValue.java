package com.spamalot.ohhi;

/**
 * Possible Cell values.
 * 
 * @author johannsg
 *
 */
enum CellValue {
  /**
   * The color Blue.
   */
  BLUE("B"),
  /**
   * The color Red.
   */
  RED("R");

  /**
   * What this color looks like when printed.
   */
  private String stringVal;

  /**
   * Color enum constructor.
   * 
   * @param val
   *          String representation for this Color.
   */
  CellValue(final String val) {
    this.stringVal = val;
  }

  /**
   * Get the opposite color.
   * 
   * @return the opposite color
   * 
   * @deprecated
   */
  @Deprecated
  public CellValue opposite() {
    // TODO: Do this another way so can generalize this Enum.
    switch (this) {
      case RED:
        return CellValue.BLUE;
      case BLUE:
        return CellValue.RED;
      default:
        throw new IllegalStateException("This should never happen: " + this + " has no opposite.");
    }
  }

  @Override
  public String toString() {
    return this.stringVal;
  }
}
