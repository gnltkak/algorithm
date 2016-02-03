package test;

import static org.junit.Assert.*;
import interview._2011_03_03_factorialTrailingZeroCnt;

import org.junit.Test;

public class Test_2011_03_03_factorialTrailingZeroCnt {
	@Test
	public void testFactTZeroCnt1() {
		int n = 0;
		int expected = _2011_03_03_factorialTrailingZeroCnt.factTZeroCntRef(n);
		int actual = _2011_03_03_factorialTrailingZeroCnt.factTZeroCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFactTZeroCnt2() {
		int n = 1;
		int expected = _2011_03_03_factorialTrailingZeroCnt.factTZeroCntRef(n);
		int actual = _2011_03_03_factorialTrailingZeroCnt.factTZeroCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFactTZeroCnt3() {
		for(int n=10;n<=100;n++)
		{
			int expected = _2011_03_03_factorialTrailingZeroCnt.factTZeroCntRef(n);
			int actual = _2011_03_03_factorialTrailingZeroCnt.factTZeroCnt(n);
			assertEquals(expected,actual);
		}
	}
	
	@Test
	public void testFactTZeroCnt4() {
		int n = 10000000;
		int expected = _2011_03_03_factorialTrailingZeroCnt.factTZeroCntRef(n);
		int actual = _2011_03_03_factorialTrailingZeroCnt.factTZeroCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFactTZeroCnt5() {
		int n = Integer.MAX_VALUE;
		int expected = _2011_03_03_factorialTrailingZeroCnt.factTZeroCntRef(n);
		System.out.println(expected);
		//int actual = _2011_03_03_factorialTrailingZeroCnt.factTZeroCnt(n);
		//assertEquals(expected,actual);
	}
}
