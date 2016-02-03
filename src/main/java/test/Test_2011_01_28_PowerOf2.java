package test;

import static org.junit.Assert.*;
import interview._2011_01_28_PowerOf2;

import org.junit.Test;

public class Test_2011_01_28_PowerOf2 {
	@Test
	public void testPowerOf2_1() {
		int num = 2;
		boolean expected = true;
		boolean actual = _2011_01_28_PowerOf2.isPowerOf2(num);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPowerOf2_2() {
		int num = 0;
		boolean expected = false;
		boolean actual = _2011_01_28_PowerOf2.isPowerOf2(num);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPowerOf2_3() {
		int num = 1<<30;
		boolean expected = true;
		boolean actual = _2011_01_28_PowerOf2.isPowerOf2(num);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPowerOf2_4() {
		int num = 1230127903;
		boolean expected = false;
		boolean actual = _2011_01_28_PowerOf2.isPowerOf2(num);
		assertEquals(expected,actual);
	}
}
