package com.spamalot.ohhi;

/**
 * Handle the logic for solving an Ohhi puzzle.
 * 
 * @author gej
 *
 */
class PuzzleSolver {
  public static void solve(final PuzzleBoard puzzleBoard) {

    System.out.println("Rows:");
    CellGroup[] rows = puzzleBoard.getRowCellGroups();
    for (CellGroup cg : rows) {
      System.out.println(cg);
    }

    System.out.println("Columns:");
    CellGroup[] columns = puzzleBoard.getColumnCellGroups();
    for (CellGroup cg : columns) {
      System.out.println(cg);
    }

    while (solveThree(rows) || solveThree(columns)) {
      System.out.println("Made a change in the last pass, will make another pass.");
    }
    System.out.println("Rows after 3 processing:");
    for (CellGroup cg : rows) {
      System.out.println(cg);
    }

    System.out.println(puzzleBoard);
    // puzzleBoard.threeInARow();
    // System.out.println(puzzleBoard);
    puzzleBoard.evenNumber();

    System.out.println(puzzleBoard);
    System.out.println("Rows before 3 processing:");
    for (CellGroup cg : rows) {
      System.out.println(cg);
    }
    while (solveThree(rows) || solveThree(columns)) {
    }
    System.out.println("Rows after 3 processing:");
    for (CellGroup cg : rows) {
      System.out.println(cg);
    }
    // puzzleBoard.threeInARow();
    System.out.println(puzzleBoard);
    puzzleBoard.evenNumber();
    System.out.println(puzzleBoard);
    puzzleBoard.domehtingSeomthing();
    System.out.println(puzzleBoard);

  }

  /**
   * @param group
   * @return
   */
  private static boolean solveThree(final CellGroup[] group) {
    System.out.println("SolveThree");
    boolean ret = false;
    for (CellGroup cg : group) {
      while (solveThreeInARow(cg)) {
        ret = true;
      }
    }

    return ret;
  }

  private static boolean solveThreeInARow(final CellGroup cellGroup) {
    boolean ret = false;

    int size = cellGroup.getSize();
    for (int i = 0; i < size - 2; i++) {
      if (fixThreeInARow(cellGroup.getCell(i), cellGroup.getCell(i + 1), cellGroup.getCell(i + 2))) {
        ret = true;
      }
    }
    return ret;
  }

  private static boolean fixThreeInARow(final Cell c1, final Cell c2, final Cell c3) {
    if (c1.isEmpty()) {
      if (c2.equals(c3)) {
        c1.setColor(c2.getColor().opposite());
        return true;
      }
    }
    if (c2.isEmpty()) {
      if (c1.equals(c3)) {
        c2.setColor(c1.getColor().opposite());
        return true;
      }
    }
    if (c3.isEmpty()) {
      if (c1.equals(c2)) {
        c3.setColor(c1.getColor().opposite());
        return true;
      }
    }
    return false;
  }

}
