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
    Color(final String val) {
      stringVal = val;
    }

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

    @Override
    public String toString() {
      return stringVal;
    }
  }

  /**
   * The color in this cell.
   */
  private Color color;

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
    if (other.color == null) {
      return false;
    }
    if (color != other.color) {
      return false;
    }
    return true;
  }

  /**
   * Get this cell's color.
   * 
   * @return the Cell's color
   */
  public final Color getColor() {
    return color;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    return result;
  }

  /**
   * Check if a cell is empty.
   * 
   * @return True if this cell has no color
   */
  public boolean isEmpty() {
    return color == null;
  }

  /**
   * Set the cell's color.
   * 
   * @param color
   *          the color to set the cell to
   */
  public final void setColor(final Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    if (color != null) {
      return color.toString();
    }
    return ".";
  }

}
