package com.spamalot.ohhi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTest {

  @Test
  public void testGetCellValue() {
    Cell cell = new Cell();
    cell.setValue(CellValue.BLUE);
    assertEquals(CellValue.BLUE, cell.getValue());
  }

  @Test
  public void testIsEmpty() {
    Cell cell = new Cell();
    assertTrue(cell.isEmpty());

    cell.setValue(CellValue.RED);
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

    cell2.setValue(CellValue.BLUE);

    assertFalse(cell1.isSameColor(cell2));

    cell1.setValue(CellValue.BLUE);
    assertTrue(cell1.isSameColor(cell2));
  }
}
