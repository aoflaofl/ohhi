package com.spamalot.ohhi;

class SameRowRule {
  private SameRowRule() {
  }

  static boolean applySameRowRule(PuzzleBoard puzzleBoard) {
    boolean progress = false;
    boolean changeMade;
    do {
      changeMade = processGroups(puzzleBoard);
      progress = changeMade || progress;
    } while (changeMade);

    return progress;
  }

  private static boolean processGroups(PuzzleBoard puzzleBoard) {
    return processCellGroups(puzzleBoard.getRowCellGroups()) || processCellGroups(puzzleBoard.getColumnCellGroups());
  }

  private static boolean processCellGroups(CellGroup[] groups) {
    for (CellGroup i : groups) {
      if (i.emptyCount() == 2) {
        CellGroup cg = findDuplicate(groups, i);
        if (cg != null) {
          i.fixCellGroup(cg);
          return true;
        }
      }
    }
    return false;
  }

  private static CellGroup findDuplicate(CellGroup[] groups, CellGroup cellGroup) {
    for (CellGroup group : groups) {
      if (group.emptyCount() == 0 && cellGroup.compareExistingCells(group)) {
        return group;
      }
    }
    return null;
  }

}
