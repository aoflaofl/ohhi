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
   * @param args Arguments to the program
   */
  public static void main(final String[] args) {
    PuzzleBoard puzzleBoard = new PuzzleBoard(8);
    setInitialCells(puzzleBoard);
    PuzzleSolver.solve(puzzleBoard);
  }

  private static void setInitialCells(PuzzleBoard puzzleBoard) {
    int[][] redCells = { { 0, 0 }, { 0, 5 }, { 1, 7 }, { 2, 0 }, { 3, 2 }, { 3, 4 }, { 3, 7 }, { 5, 0 }, { 5, 3 },
        { 5, 5 }, { 5, 7 }, { 6, 5 }, { 6, 7 }, { 7, 0 }, { 7, 2 } };
    int[][] blueCells = { { 2, 3 } };

    for (int[] cell : redCells) {
      puzzleBoard.setCell(CellValue.RED, cell[0], cell[1]);
    }

    for (int[] cell : blueCells) {
      puzzleBoard.setCell(CellValue.BLUE, cell[0], cell[1]);
    }
  }

  private static void setInitialCellsTwo(PuzzleBoard puzzleBoard) {
    int[][] redCells = { { 0, 3 }, { 0, 7 }, { 1, 3 }, { 1, 4 }, { 2, 4 }, { 2, 6 }, { 3, 1 }, { 4, 7 }, { 5, 2 },
        { 6, 0 }, { 6, 2 }, { 6, 5 }, { 6, 7 }, { 7, 0 } };
    int[][] blueCells = { { 1, 6 }, { 7, 4 } };

    setCells(puzzleBoard, CellValue.RED, redCells);
    setCells(puzzleBoard, CellValue.BLUE, blueCells);
  }

  private static void setCells(PuzzleBoard puzzleBoard, CellValue cellValue, int[][] cells) {
    for (int[] cell : cells) {
      puzzleBoard.setCell(cellValue, cell[0], cell[1]);
    }
  }
}
