package test;

import static org.junit.Assert.*;
import interview._2011_01_19_MaxSubSum;

import org.junit.Test;

import util.Util;

public class Test_2011_01_19_MaxSubSum {
	@Test
	public void testMaxSubSum0() {
		int[] array = new int[] {-1,100,-1};
		long expected = _2011_01_19_MaxSubSum.maxSubSumRef(array);
		long actual = _2011_01_19_MaxSubSum.maxSubSum(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSum1() {
		int[] array = new int[] {1,2,3,4,5};
		long expected = _2011_01_19_MaxSubSum.maxSubSumRef(array);
		long actual = _2011_01_19_MaxSubSum.maxSubSum(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSum2() {
		int[] array = new int[] {-1,10,-5,2,5};
		long expected = _2011_01_19_MaxSubSum.maxSubSumRef(array);
		long actual = _2011_01_19_MaxSubSum.maxSubSum(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSum3() {
		int[] array = new int[] {-1};
		long expected = _2011_01_19_MaxSubSum.maxSubSumRef(array);
		long actual = _2011_01_19_MaxSubSum.maxSubSum(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSum4() {
		int[] array = new int[] {-1,-10,0,0,0,-1,-10};
		long expected = _2011_01_19_MaxSubSum.maxSubSumRef(array);
		long actual = _2011_01_19_MaxSubSum.maxSubSum(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSum5() {
		int[] array = Util.makeRandIntArr(1000, 0, false);
		long expected = _2011_01_19_MaxSubSum.maxSubSumRef(array);
		long actual = _2011_01_19_MaxSubSum.maxSubSum(array);
		assertEquals(expected,actual);
	}
}
