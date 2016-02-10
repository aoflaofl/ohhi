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
    Puzzle puzzle = new Puzzle(4);

    puzzle.setCell(Cell.Color.RED, 0, 2);
    puzzle.setCell(Cell.Color.BLUE, 1, 3);
    puzzle.setCell(Cell.Color.BLUE, 2, 0);
    puzzle.setCell(Cell.Color.RED, 3, 0);
    puzzle.setCell(Cell.Color.RED, 3, 1);

    System.out.println(puzzle);
    puzzle.threeInARow();
    System.out.println(puzzle);
    puzzle.evenNumber();
    System.out.println(puzzle);
    puzzle.threeInARow();
    System.out.println(puzzle);
    puzzle.evenNumber();
    System.out.println(puzzle);

  }

}
