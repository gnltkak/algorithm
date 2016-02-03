package test;

import static org.junit.Assert.*;
import interview._2011_12_31_MinMax;

import org.junit.Test;

import util.Util;

public class Test_2011_12_31_MinMax {
	@Test
	public void testMinMax1() throws Exception {
		int[] arr = {0};
		String expected = "0,0";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax2() throws Exception {
		int[] arr = {1, 0};
		String expected = "0,1";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax3() throws Exception {
		int[] arr = {1, 0, 2};
		String expected = "0,2";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax4() throws Exception {
		int[] arr = {5, 3, 2};
		String expected = "2,5";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax5() throws Exception {
		int[] arr = {5, 3, 1};
		String expected = "1,5";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax6() throws Exception {
		int[] arr = {7, -1, 3, 4};
		String expected = "-1,7";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax7() throws Exception {
		int[] arr = {8, 0, -3, 10, 7};
		String expected = "-3,10";
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax8() throws Exception {
		int[] arr = Util.makeRandIntArr(1000, 0, false);
		String expected = _2011_12_31_MinMax.minMaxNaive(arr);
		String actual = _2011_12_31_MinMax.minMax(arr);
		assertEquals(expected, actual);
	}
}
