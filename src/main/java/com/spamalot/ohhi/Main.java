package com.spamalot.ohhi;

/**
 * Start here.
 * 
 * @author johannsg
 *
 */
public final class Main {

  /**
   * Instantiate nothing.
   */
  private Main() {
  }

  /**
   * Really, start here.
   * 
   * @param args
   *          Arguments to the program
   */
  public static void main(final String[] args) {
    PuzzleBoard puzzleBoard = new PuzzleBoard(8);

    puzzleBoard.setCell(CellValue.RED, 0, 0);
    puzzleBoard.setCell(CellValue.RED, 0, 5);
    puzzleBoard.setCell(CellValue.RED, 1, 7);
    puzzleBoard.setCell(CellValue.RED, 2, 0);
    puzzleBoard.setCell(CellValue.BLUE, 2, 3);
    puzzleBoard.setCell(CellValue.RED, 3, 2);
    puzzleBoard.setCell(CellValue.RED, 3, 4);
    puzzleBoard.setCell(CellValue.RED, 3, 7);
    puzzleBoard.setCell(CellValue.RED, 5, 0);
    puzzleBoard.setCell(CellValue.RED, 5, 3);
    puzzleBoard.setCell(CellValue.RED, 5, 5);
    puzzleBoard.setCell(CellValue.RED, 5, 7);
    puzzleBoard.setCell(CellValue.RED, 6, 5);
    puzzleBoard.setCell(CellValue.RED, 6, 7);
    puzzleBoard.setCell(CellValue.RED, 7, 0);
    puzzleBoard.setCell(CellValue.RED, 7, 2);

    PuzzleSolver.solve(puzzleBoard);
  }
}
