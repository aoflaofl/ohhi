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
      if (SolveThree.solveThree(puzzleBoard.getRowCellGroups())
          || SolveThree.solveThree(puzzleBoard.getColumnCellGroups())) {
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
