package test;

import static org.junit.Assert.*;
import interview._2011_02_09_MergeArray;

import org.junit.Test;

import util.Util;

public class Test_2011_02_09_MergeArray {
	@Test
	public void testMergeArray1() {
		int[] b = {2,3};
		int[] a = {1,2,3,5,7,10,-1,-1};		
		
		String expected = Util.arrayToString(new int[] {1,2,2,3,3,5,7,10}, ",");
		_2011_02_09_MergeArray.mergeArray2(a, b);
		String actual = Util.arrayToString(a, ",");
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMergeArray2() {
		int[] b = {0,0,0};
		int[] a = {1,2,3,5,7,10,-1,-1,-1};		
		
		String expected = Util.arrayToString(new int[] {0,0,0,1,2,3,5,7,10}, ",");
		_2011_02_09_MergeArray.mergeArray2(a, b);
		String actual = Util.arrayToString(a, ",");
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMergeArray3() {
		int[] b = {10,11,13,13};
		int[] a = {1,2,3,5,7,10,-1,-1,-1};		
		
		String expected = Util.arrayToString(new int[] {1,2,3,5,7,10,11,13,13}, ",");
		_2011_02_09_MergeArray.mergeArray2(a, b);
		String actual = Util.arrayToString(a, ",");
		assertEquals(expected,actual);
	}
}
