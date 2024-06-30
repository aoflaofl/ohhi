package com.spamalot.ohhi;

import java.util.EnumMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class EvenNumber {
  private static final Logger LOGGER = LoggerFactory.getLogger(EvenNumber.class);

  private EvenNumber() {
  }

  private static boolean evenNumber(PuzzleBoard p) {
    boolean changeMade = false;
    for (int i = 0; i < p.getSize(); i++) {
      changeMade = EvenNumber.evenNumber(p.getRowCellGroups()[i]) || changeMade;
      changeMade = EvenNumber.evenNumber(p.getColumnCellGroups()[i]) || changeMade;
    }
    return changeMade;
  }

  private static boolean evenNumber(CellGroup cg) {
    return fillEmptyCellsWithColor(cg, findColorToFill(cg));
  }

  private static boolean fillEmptyCellsWithColor(CellGroup cg, CellValue colorToFill) {
    return colorToFill != null && cg.fillEmptyWith(colorToFill);
  }

  private static CellValue findColorToFill(CellGroup cg) {
    int fillSize = cg.getSize() / 2;
    EnumMap<CellValue, Integer> m = cg.getCountMap(); // Change HashMap to EnumMap
    LOGGER.info("Even Number: {}", m);

    return findOppositeColor(m, fillSize);
  }

  private static CellValue findOppositeColor(Map<CellValue, Integer> m, int fillSize) {
    for (Map.Entry<CellValue, Integer> entry : m.entrySet()) {
      if (entry.getValue() == fillSize) {
        return entry.getKey().opposite();
      }
    }
    return null;
  }

  static boolean applyEvenNumberRule(PuzzleBoard puzzleBoard) {
    boolean progress = false;
    boolean changeMade;
    do {
      changeMade = evenNumber(puzzleBoard);
      progress = changeMade || progress;
    } while (changeMade);

    PuzzleSolver.LOGGER.info("\nEven Number\n{}", puzzleBoard);
    PuzzleSolver.printCellGroups(puzzleBoard.getRowCellGroups());

    return progress;
  }

}
