
package com.spamalot.ohhi;

import java.util.HashMap;

class PuzzleSolver {

	private PuzzleSolver() {
	}

	public static void solve(PuzzleBoard puzzleBoard) {
		processCellGroups(puzzleBoard.getRowCellGroups());
		processCellGroups(puzzleBoard.getColumnCellGroups());

		while (solveThree(puzzleBoard.getRowCellGroups()) || solveThree(puzzleBoard.getColumnCellGroups())) {
		}

		while (evenNumber(puzzleBoard)) {
		}

		while (solveThree(puzzleBoard.getRowCellGroups()) || solveThree(puzzleBoard.getColumnCellGroups())) {
		}

		evenNumber(puzzleBoard);
		puzzleBoard.processGroups();
	}

	private static boolean solveThree(CellGroup[] group) {
		boolean changeMade = false;
		for (CellGroup cg : group) {
			while (solveThreeInARow(cg)) {
				changeMade = true;
			}
		}
		return changeMade;
	}

	private static boolean solveThreeInARow(CellGroup cellGroup) {
		boolean changeMade = false;
		int size = cellGroup.getSize();
		for (int i = 0; i < size - 2; i++) {
			if (fixThreeInARow(cellGroup.getCell(i), cellGroup.getCell(i + 1), cellGroup.getCell(i + 2))) {
				changeMade = true;
			}
		}
		return changeMade;
	}

	private static boolean fixThreeInARow(Cell c1, Cell c2, Cell c3) {
		if (c1.isEmpty() && c2.isSameColor(c3)) {
			c1.setValue(c2.getValue().opposite());
			return true;
		}
		if (c2.isEmpty() && c1.isSameColor(c3)) {
			c2.setValue(c1.getValue().opposite());
			return true;
		}
		if (c3.isEmpty() && c1.isSameColor(c2)) {
			c3.setValue(c1.getValue().opposite());
			return true;
		}
		return false;
	}

	private static boolean evenNumber(PuzzleBoard p) {
		boolean changeMade = false;
		for (int i = 0; i < p.getSize(); i++) {
			changeMade = evenNumber(p.getRowCellGroups()[i]) || changeMade;
			changeMade = evenNumber(p.getColumnCellGroups()[i]) || changeMade;
		}
		return changeMade;
	}

	private static boolean evenNumber(CellGroup cg) {
		int fillSize = cg.getSize() / 2;
		HashMap<CellValue, Integer> m = cg.getCountMap();
		for (CellValue color : m.keySet()) {
			if (m.get(color) == fillSize) {
				cg.fillEmptyWith(color.opposite());
				return true;
			}
		}
		return false;
	}

	private static void processCellGroups(CellGroup[] groups) {
		for (CellGroup cg : groups) {
			System.out.println(cg);
		}
	}
}
