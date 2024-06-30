package com.spamalot.ohhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PuzzleSolver {
  static final Logger LOGGER = LoggerFactory.getLogger(PuzzleSolver.class);

  private PuzzleSolver() {
  }

  public static void solve(PuzzleBoard puzzleBoard) {
    printCellGroups(puzzleBoard.getRowCellGroups());

    boolean progress;
    do {
      progress = SolveThree.applyThreeCellRule(puzzleBoard);
      progress = EvenNumber.applyEvenNumberRule(puzzleBoard) || progress;
      progress = SameRowRule.applySameRowRule(puzzleBoard) || progress;
    } while (progress);
  }

  static void printCellGroups(CellGroup[] groups) {
    for (CellGroup cg : groups) {
      LOGGER.info("{} {}", cg, SolveThree.isCellGroupSolvedForThreeCellRule(cg));
    }
  }
}
