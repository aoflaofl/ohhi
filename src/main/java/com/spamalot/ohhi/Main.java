package com.spamalot.ohhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Start here.
 * 
 * @author johannsg
 *
 */
public final class Main {

  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

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
    LOGGER.info("Starting the 0hh1 puzzle solver");

    LOGGER.info("Solving first puzzle");
    PuzzleBoard puzzleBoard = new PuzzleBoard(8);
    puzzleBoard.setInitialCells(CellValue.RED, new int[][] { { 0, 0 }, { 0, 5 }, { 1, 7 }, { 2, 0 }, { 3, 2 }, { 3, 4 },
        { 3, 7 }, { 5, 0 }, { 5, 3 }, { 5, 5 }, { 5, 7 }, { 6, 5 }, { 6, 7 }, { 7, 0 }, { 7, 2 } });
    puzzleBoard.setInitialCells(CellValue.BLUE, new int[][] { { 2, 3 } });

    LOGGER.debug("Initial state of first puzzle:\n{}", puzzleBoard);
    PuzzleSolver.solve(puzzleBoard);
    LOGGER.info("First puzzle solved");

    LOGGER.info("Solving second puzzle");
    puzzleBoard = new PuzzleBoard(8);
    puzzleBoard.setInitialCells(CellValue.RED, new int[][] { { 0, 3 }, { 0, 7 }, { 1, 3 }, { 1, 4 }, { 2, 4 }, { 2, 6 },
        { 3, 1 }, { 4, 7 }, { 5, 2 }, { 6, 0 }, { 6, 2 }, { 6, 5 }, { 6, 7 }, { 7, 0 } });
    puzzleBoard.setInitialCells(CellValue.BLUE, new int[][] { { 1, 6 }, { 7, 4 } });

    LOGGER.debug("Initial state of second puzzle:\n{}", puzzleBoard);
    PuzzleSolver.solve(puzzleBoard);
    LOGGER.info("Second puzzle solved");

    LOGGER.info("0hh1 puzzle solver finished");
  }

}