package com.spamalot.ohhi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTest {

  @Test
  public void testGetCellValue() {
    Cell cell = new Cell();
    cell.setCellValue(CellValue.BLUE);
    assertEquals(CellValue.BLUE, cell.getCellValue());
  }

  @Test
  public void testIsEmpty() {
    Cell cell = new Cell();
    assertTrue(cell.isEmpty());

    cell.setCellValue(CellValue.RED);
    assertFalse(cell.isEmpty());
  }

  @Test
  public void testToString() {
    Cell cell = new Cell();
    assertTrue(".".contentEquals(cell.toString()));
  }

  @Test
  public void testHasSameColorAs() {
    Cell cell1 = new Cell();
    Cell cell2 = new Cell();

    cell2.setCellValue(CellValue.BLUE);

    assertFalse(cell1.hasSameColorAs(cell2));

    cell1.setCellValue(CellValue.BLUE);
    assertTrue(cell1.hasSameColorAs(cell2));
  }
}
