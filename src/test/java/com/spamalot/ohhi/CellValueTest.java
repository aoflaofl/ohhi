package com.spamalot.ohhi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class CellValueTest {

  @Test
  public void testCellValue() {
    CellValue b = CellValue.BLUE;
    assertNotEquals(CellValue.RED, b);
  }

  @Test
  public void testOpposite() {
    CellValue b = CellValue.BLUE;
    assertEquals(CellValue.RED, b.opposite());
    assertNotEquals(CellValue.RED, CellValue.RED.opposite());
  }

  @Test
  public void testToString() {
    CellValue b = CellValue.BLUE;
    assertEquals("B", b.toString());
  }
}
