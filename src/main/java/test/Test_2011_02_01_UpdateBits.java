package test;

import static org.junit.Assert.*;
import interview._2011_02_01_UpdateBits;

import org.junit.Test;

public class Test_2011_02_01_UpdateBits {
	@Test
	public void testUpdateBits1() {
		int n = 1;
		int m = 1;
		int i = 0;
		int j = i+Integer.toBinaryString(m).length()-1;
		int expected = 1;
		int actual = _2011_02_01_UpdateBits.updateBits(n, m, i, j);
		int actual2 = _2011_02_01_UpdateBits.updateBitsOptimal(n, m, i, j);
		assertEquals(expected,actual);
		assertEquals(expected,actual2);
	}
	
	@Test
	public void testUpdateBits2() {
		int n = 1;
		int m = 1;
		int i = 1;
		int j = i+Integer.toBinaryString(m).length()-1;
		int expected = 3;
		int actual = _2011_02_01_UpdateBits.updateBits(n, m, i, j);
		int actual2 = _2011_02_01_UpdateBits.updateBitsOptimal(n, m, i, j);
		assertEquals(expected,actual);
		assertEquals(expected,actual2);
	}
	
	@Test
	public void testUpdateBits3() {
		int n = 1000;
		int m = 100;
		int i = 1;
		int j = i+Integer.toBinaryString(m).length()-1;
		int expected = 968;
		int actual = _2011_02_01_UpdateBits.updateBits(n, m, i, j);
		int actual2 = _2011_02_01_UpdateBits.updateBitsOptimal(n, m, i, j);
		assertEquals(expected,actual);
		assertEquals(expected,actual2);
	}
	
	@Test
	public void testUpdateBits4() {
		int n = 0;
		int m = 0xffffffff;
		int i = 0;
		int j = 31;
		int expected = 0xffffffff;
		int actual = _2011_02_01_UpdateBits.updateBits(n, m, i, j);
		int actual2 = _2011_02_01_UpdateBits.updateBitsOptimal(n, m, i, j);
		assertEquals(expected,actual);
		assertEquals(expected,actual2);
	}
	
	@Test
	public void testUpdateBits5() {
		int n = 0;
		int m = 1;
		int i = 0;
		int j = 0;
		int expected = 1;
		int actual = _2011_02_01_UpdateBits.updateBits(n, m, i, j);
		int actual2 = _2011_02_01_UpdateBits.updateBitsOptimal(n, m, i, j);
		assertEquals(expected,actual);
		assertEquals(expected,actual2);
	}
	
	@Test
	public void testUpdateBits6() {
		int n = 0;
		int m = 1;
		int i = 31;
		int j = 31;
		int expected = 0x80000000;
		int actual = _2011_02_01_UpdateBits.updateBits(n, m, i, j);
		int actual2 = _2011_02_01_UpdateBits.updateBitsOptimal(n, m, i, j);
		assertEquals(expected,actual);
		assertEquals(expected,actual2);
	}
}
