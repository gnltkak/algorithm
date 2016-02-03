package test;

import static org.junit.Assert.*;
import interview._2011_01_20_SubSum;

import org.junit.Test;

import util.Util;

public class Test_2011_01_20_SubSum {
	@Test
	public void testSubSum1() {
		int[] array = {-10,2,9,3,-1,0};
		long expected = 13;
		long actual = _2011_01_20_SubSum.subSum(array,1,4);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSubSum2() {
		int[] array = Util.makeRandIntArr(100, 0, false);
		long expected = _2011_01_20_SubSum.subSumNaive(array,3,45);
		long actual = _2011_01_20_SubSum.subSum(array,3,45);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSubSum3() {
		int[] array = Util.makeRandIntArr(1000, 5000, true);
		long expected = _2011_01_20_SubSum.subSumNaive(array,0,999);
		long actual = _2011_01_20_SubSum.subSum(array,0,999);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSubSum4() {
		int[] array = Util.makeRandIntArr(20, 0,false);
		long expected = _2011_01_20_SubSum.subSumNaive(array,0,0);
		long actual = _2011_01_20_SubSum.subSum(array,0,0);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testSubSum5() {
		int[] array = Util.makeRandIntArr(20, 0,false);
		long expected = _2011_01_20_SubSum.subSumNaive(array,12,12);
		long actual = _2011_01_20_SubSum.subSum(array,12,12);
		
		assertEquals(expected,actual);
	}
}
