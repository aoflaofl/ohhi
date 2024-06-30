package com.spamalot.ohhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SolveThree {
  private static final Logger LOGGER = LoggerFactory.getLogger(SolveThree.class);

  private SolveThree() {
  }

  private static boolean solveThree(CellGroup[] group) {
    boolean changeMade = false;
    for (CellGroup cg : group) {
      while (SolveThree.solveThreeInARow(cg)) {
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
      if (SolveThree.fixThreeInARow(cellGroup, i)) {
        changeMade = true;
      }
    }
    return changeMade;
  }

  private static boolean fixThreeInARow(CellGroup cellGroup, int index) {
    CellValue c1 = cellGroup.getCellValue(index);
    CellValue c2 = cellGroup.getCellValue(index + 1);
    CellValue c3 = cellGroup.getCellValue(index + 2);

    if (c1 == CellValue.EMPTY && c2 != CellValue.EMPTY && c3 != CellValue.EMPTY && c2 == c3) {
      cellGroup.getCell(index).setValue(c2.opposite());
      return true;
    }

    if (c2 == CellValue.EMPTY && c1 != CellValue.EMPTY && c3 != CellValue.EMPTY && c1 == c3) {
      cellGroup.getCell(index + 1).setValue(c1.opposite());
      return true;
    }

    if (c3 == CellValue.EMPTY && c1 != CellValue.EMPTY && c2 != CellValue.EMPTY && c1 == c2) {
      cellGroup.getCell(index + 2).setValue(c1.opposite());
      return true;
    }

    return false;
  }

  static boolean isCellGroupSolvedForThreeCellRule(CellGroup cellGroup) {
    int size = cellGroup.getSize();
    for (int i = 0; i < size - 2; i++) {
      if (isInvalidSequence(cellGroup, i)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isInvalidSequence(CellGroup cellGroup, int index) {
    CellValue cellValue = cellGroup.getCellValue(index);
    CellValue cellValue2 = cellGroup.getCellValue(index + 1);
    CellValue cellValue3 = cellGroup.getCellValue(index + 2);

    return isSequenceEmpty(cellValue, cellValue2, cellValue3) || isSequenceEqual(cellValue, cellValue2, cellValue3);
  }

  private static boolean isSequenceEmpty(CellValue... cellValues) {
    for (CellValue cv : cellValues) {
      if (cv == CellValue.EMPTY) {
        return true;
      }
    }
    return false;
  }

  private static boolean isSequenceEqual(CellValue... cellValues) {
    CellValue first = cellValues[0];
    for (CellValue cv : cellValues) {
      if (cv != first) {
        return false;
      }
    }
    return true;
  }

  private static boolean solveUsingThreeCellRule(PuzzleBoard puzzleBoard) {
    boolean changeMade;
    PuzzleSolver.LOGGER.info("Rows Three Cell Rule");
    changeMade = solveThree(puzzleBoard.getRowCellGroups());
    PuzzleSolver.printCellGroups(puzzleBoard.getRowCellGroups());
    PuzzleSolver.LOGGER.info("Columns Three Cell Rule");
    changeMade = solveThree(puzzleBoard.getColumnCellGroups()) || changeMade;
    PuzzleSolver.printCellGroups(puzzleBoard.getRowCellGroups());
    return changeMade;
  }

  static boolean applyThreeCellRule(PuzzleBoard puzzleBoard) {
    boolean progress = false;
    boolean changeMade;
    do {
      changeMade = solveUsingThreeCellRule(puzzleBoard);
      progress = changeMade || progress;
    } while (changeMade);

    PuzzleSolver.LOGGER.info("\nThree Cell\n{}", puzzleBoard);
    PuzzleSolver.printCellGroups(puzzleBoard.getRowCellGroups());

    return progress;
  }

}
