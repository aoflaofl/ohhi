package com.spamalot.ohhi;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellValueTest {

  @Test
  public void testCellValue() {
    CellValue b = CellValue.BLUE;
    assertFalse(b.equals(CellValue.RED));
  }

  @Test
  public void testOpposite() {
    CellValue b = CellValue.BLUE;
    assertTrue(b.opposite().equals(CellValue.RED));
    assertFalse(CellValue.RED.opposite().equals(CellValue.RED));
  }

  @Test
  public void testToString() {
    CellValue b = CellValue.BLUE;
    assertTrue(b.toString().equals("B"));
  }

}
