package com.spamalot.ohhi;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Handle the logic for solving an Ohhi puzzle.
 * 
 * @author gej
 *
 */
final class PuzzleSolver {

  /**
   * Do not instantiate this.
   */
  private PuzzleSolver() {
  }

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
    while (evenNumber(puzzleBoard)) {
      System.out.println("Made change using even strategy.  Making another pass.");
    }

    System.out.println(puzzleBoard);
    System.out.println("Rows before 3 processing:");
    for (CellGroup cg : rows) {
      System.out.println(cg);
    }
    while (solveThree(rows) || solveThree(columns)) {
      // Just keep doing it.
    }
    System.out.println("Rows after 3 processing:");
    for (CellGroup cg : rows) {
      System.out.println(cg);
    }
    // puzzleBoard.threeInARow();
    System.out.println(puzzleBoard);
    evenNumber(puzzleBoard);
    System.out.println(puzzleBoard);
    puzzleBoard.domehtingSeomthing();
    System.out.println(puzzleBoard);

  }

  /**
   * Solve a three cell group.
   * 
   * @param group The group
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
      if (c2.hasSameColorAs(c3)) {
        c1.setCellValue(c2.getCellValue().opposite());
        return true;
      }
    }
    if (c2.isEmpty()) {
      if (c1.hasSameColorAs(c3)) {
        c2.setCellValue(c1.getCellValue().opposite());
        return true;
      }
    }
    if (c3.isEmpty()) {
      if (c1.hasSameColorAs(c2)) {
        c3.setCellValue(c1.getCellValue().opposite());
        return true;
      }
    }
    return false;
  }

  /**
   * Handle Rule that the number of Red and Blue cells must be the same.
   * 
   * @param cg The group
   */
  private static boolean evenNumber(final CellGroup cg) {
    // TODO: Need to handle odd size groups.
    int fillSize = cg.getSize() / 2;

    HashMap<CellValue, Integer> m = cg.getCountMap();
    System.out.println(m);

    Integer[] x1 = m.values().toArray(new Integer[0]);
    if (x1.length == 2 && x1[0].intValue() + x1[1].intValue() == cg.getSize()) {
      // No change was made.
      return false;
    }

    for (Entry<CellValue, Integer> x : m.entrySet()) {
      int qqq = x.getValue().intValue();
      if (qqq == fillSize) {
        System.out.println("Need to fill in empties with: " + x.getKey().opposite());
        cg.fillEmptyWith(x.getKey().opposite());
        return true;
      }
    }
    return false;
  }

  /**
   * Handle case where number of Red and Blue cells must be the same.
   */
  private static boolean evenNumber(final PuzzleBoard p) {
    boolean changed = false;
    for (int i = 0; i < p.getSize(); i++) {
      changed = PuzzleSolver.evenNumber(p.getRowCellGroups()[i]) || changed;
      changed = PuzzleSolver.evenNumber(p.getColumnCellGroups()[i]) || changed;
      // this.rows[i].evenNumber();
      // this.columns[i].evenNumber();
    }
    return changed;
  }
}
