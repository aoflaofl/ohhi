package com.spamalot.ohhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SolveThree {
  private static final Logger LOGGER = LoggerFactory.getLogger(SolveThree.class);

  private SolveThree() {
  }

  static boolean solveThree(CellGroup[] group) {
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
    CellValue c0 = cellGroup.getCellValue(index - 1);
    CellValue c1 = cellGroup.getCellValue(index);
    CellValue c2 = cellGroup.getCellValue(index + 1);
    CellValue c3 = cellGroup.getCellValue(index + 2);
    CellValue c4 = cellGroup.getCellValue(index + 3);

    // c0 c1 c2 c3 c4
    // R . R B E
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

}
