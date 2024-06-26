package com.spamalot.ohhi;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PuzzleSolver {
  private static final Logger LOGGER = LoggerFactory.getLogger(PuzzleSolver.class);

  private PuzzleSolver() {
  }

  public static void solve(PuzzleBoard puzzleBoard) {
    processCellGroups(puzzleBoard.getRowCellGroups());
    // processCellGroups(puzzleBoard.getColumnCellGroups());
    boolean changeMade = true;
    while (changeMade) {
      changeMade = false;
      if (solveThree(puzzleBoard.getRowCellGroups()) || solveThree(puzzleBoard.getColumnCellGroups())) {
        changeMade = true;
      }
      LOGGER.info("\nThree Cell\n{}", puzzleBoard);
    }

    while (evenNumber(puzzleBoard)) {
      LOGGER.info("\nEven Number\n{}", puzzleBoard);
    }

//    while (solveThree(puzzleBoard.getRowCellGroups()) || solveThree(puzzleBoard.getColumnCellGroups())) {
//    }
//
//    evenNumber(puzzleBoard);
//    puzzleBoard.processGroups();
  }

  private static boolean solveThree(CellGroup[] group) {
    boolean changeMade = false;
    for (CellGroup cg : group) {
      while (solveThreeInARow(cg)) {
        LOGGER.info("Solved Three in a row.");
        changeMade = true;
      }
    }
    return changeMade;
  }

  private static boolean solveThreeInARow(CellGroup cellGroup) {
    boolean changeMade = false;
    int size = cellGroup.getSize();
    for (int i = 0; i < size - 2; i++) {
      if (fixThreeInARow(cellGroup, i)) {
        changeMade = true;
      }
    }
    return changeMade;
  }

  private static boolean fixThreeInARow(CellGroup cellGroup, int index) {
    CellValue c0 = cellGroup.getCellValue(index - 1);
    CellValue c1 = cellGroup.getCellValue(index);
    CellValue c2 = cellGroup.getCellValue(index + 1);
    CellValue c3 = cellGroup.getCellValue(index + 2);
    CellValue c4 = cellGroup.getCellValue(index + 3);

    if (c2 != c0 && c1 == CellValue.EMPTY && c2 == c3 && c3 != c4) {
      cellGroup.getCell(index).setValue(c2.opposite());
      return true;
    }
    if (c1 != c0 && c2 == CellValue.EMPTY && c1 == c3 && c3 != c4) {
      cellGroup.getCell(index + 1).setValue(c1.opposite());
      return true;
    }
    if (c1 != c0 && c3 == CellValue.EMPTY && c1 == c2 && c2 != c4) {
      cellGroup.getCell(index + 2).setValue(c1.opposite());
      return true;
    }
    return false;
  }

  private static boolean evenNumber(PuzzleBoard p) {
    boolean changeMade = false;
    for (int i = 0; i < p.getSize(); i++) {
      changeMade = evenNumber(p.getRowCellGroups()[i]) || changeMade;
      changeMade = evenNumber(p.getColumnCellGroups()[i]) || changeMade;
    }
    return changeMade;
  }

  private static boolean evenNumber(CellGroup cg) {
    int fillSize = cg.getSize() / 2;
    HashMap<CellValue, Integer> m = cg.getCountMap();
    for (CellValue color : m.keySet()) {
      if (m.get(color) == fillSize) {
        return cg.fillEmptyWith(color.opposite());
      }
    }
    return false;
  }

  private static void processCellGroups(CellGroup[] groups) {
    for (CellGroup cg : groups) {
      LOGGER.info("{}", cg);
    }
  }
}
