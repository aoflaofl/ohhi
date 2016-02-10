package com.spamalot.ohhi;

/**
 * Hold an individual cell.
 * 
 * @author johannsg
 *
 */
class Cell {

  /**
   * Possible Cell colors.
   * 
   * @author johannsg
   *
   */
  enum Color {
    /**
     * The color Red.
     */
    RED("R"),
    /**
     * The color Blue.
     */
    BLUE("B");

    /**
     * Get the opposite color.
     * 
     * @return the opposite color
     */
    public Color opposite() {
      switch (this) {
        case RED:
          return Color.BLUE;
        case BLUE:
          return Color.RED;
        default:
          throw new IllegalStateException("This should never happen: " + this + " has no opposite.");
      }
    }

    /**
     * What this color looks like when printed.
     */
    private String rep;

    /**
     * Color enum constructor.
     * 
     * @param rep
     *          String representation for this Color.
     */
    Color(final String rep) {
      this.rep = rep;
    }

    @Override
    public String toString() {
      return rep;
    }
  }

  /**
   * The color in this cell.
   */
  private Color color;

  /**
   * Get the cell's color.
   * 
   * @return the Cell's color
   */
  public final Color getColor() {
    return color;
  }

  /**
   * Set the cell's color.
   * 
   * @param color
   *          the color to set it to.
   */
  public final void setColor(final Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    String ret = ".";
    if (this.color == Color.RED) {
      ret = "R";
    }
    if (this.color == Color.BLUE) {
      ret = "B";
    }
    return ret;
  }

  /**
   * Check if a cell is empty.
   * 
   * @return True if this cell has no color.
   */
  public boolean isEmpty() {

    return color == null;
  }

}
