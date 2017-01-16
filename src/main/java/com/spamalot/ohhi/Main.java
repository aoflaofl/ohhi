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
    PuzzleBoard puzzleBoard = new PuzzleBoard(4);

    puzzleBoard.setCell(Cell.Color.RED, 0, 2);
    puzzleBoard.setCell(Cell.Color.BLUE, 1, 3);
    puzzleBoard.setCell(Cell.Color.BLUE, 2, 0);
    puzzleBoard.setCell(Cell.Color.RED, 3, 0);
    puzzleBoard.setCell(Cell.Color.RED, 3, 1);

    PuzzleSolver.solve(puzzleBoard);
  }
}
