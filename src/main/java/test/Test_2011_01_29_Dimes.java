package test;

import static org.junit.Assert.*;
import interview._2011_01_29_Dimes;

import org.junit.Test;

public class Test_2011_01_29_Dimes {
	@Test
	public void testDimes1() {
		int n = 20;
		int expected = 9;
		int actual = _2011_01_29_Dimes.moneyWays(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testDimes2() {
		int n = 34;
		int expected = 18;
		int actual = _2011_01_29_Dimes.moneyWays(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testDimes3() {
		int n = 25;
		int expected = 13;
		int actual = _2011_01_29_Dimes.moneyWays(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testDimes4() {
		int n = 4;
		int expected = 1;
		int actual = _2011_01_29_Dimes.moneyWays(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testDimes5() {
		int n = 20;
		int expected = 9;
		int actual = _2011_01_29_Dimes.moneyWays2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testDimes6() {
		int n = 34;
		int expected = 18;
		int actual = _2011_01_29_Dimes.moneyWays2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testDimes7() {
		int n = 25;
		int expected = 13;
		int actual = _2011_01_29_Dimes.moneyWays2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testDimes8() {
		int n = 4;
		int expected = 1;
		int actual = _2011_01_29_Dimes.moneyWays2(n);
		assertEquals(expected,actual);
	}
}
