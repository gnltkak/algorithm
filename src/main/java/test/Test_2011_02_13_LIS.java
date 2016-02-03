package test;

import static org.junit.Assert.*;
import interview._2011_02_13_LIS;

import org.junit.Test;

import util.Util;

public class Test_2011_02_13_LIS {
	@Test
	public void testLIS1() {
		int[] arr = {1};
		int expected = 1;
		int actual = _2011_02_13_LIS.lis1(arr);			
		assertEquals(expected,actual);
		assertEquals(expected,_2011_02_13_LIS.lis2(arr));
	}
	
	@Test
	public void testLIS2() {
		int[] arr = {1,1,1,1};
		int expected = 4;
		int actual = _2011_02_13_LIS.lis1(arr);
		assertEquals(expected,actual);
		assertEquals(expected,_2011_02_13_LIS.lis2(arr));
	}
	
	@Test
	public void testLIS3() {
		int[] arr = {1,0,1,0};
		int expected = 2;
		int actual = _2011_02_13_LIS.lis1(arr);
		assertEquals(expected,actual);
		assertEquals(expected,_2011_02_13_LIS.lis2(arr));
	}
	
	@Test
	public void testLIS4() {
		int[] arr = {1,2,3,4,5};
		int expected = 5;
		int actual = _2011_02_13_LIS.lis1(arr);
		assertEquals(expected,actual);
		assertEquals(expected,_2011_02_13_LIS.lis2(arr));
	}
	
	@Test
	public void testLIS5() {
		int[] arr = {10,20,30,15,20,5,10,1,0,3,-10,5,-3,-5,7};
		int expected = 4;
		int actual = _2011_02_13_LIS.lis1(arr);
		assertEquals(expected,actual);
		assertEquals(expected,_2011_02_13_LIS.lis2(arr));
	}
	
	@Test
	public void testLIS6() {
		int[] arr = {0,1,1,2,5,3,4,1,7,8};
		int expected = 8;
		int actual = _2011_02_13_LIS.lis1(arr);
		assertEquals(expected,actual);
		assertEquals(expected,_2011_02_13_LIS.lis2(arr));
	}
	
	@Test
	public void testLIS7() {
		int[] arr = Util.makeRandIntArr(1000, 0, false);		
		int expected = _2011_02_13_LIS.lis1(arr);
		int actual = _2011_02_13_LIS.lis2(arr);
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testLIS8() {
		int[] arr = Util.makeRandIntArr(10000, 1000, true);		
		int expected = _2011_02_13_LIS.lis1(arr);
		int actual = _2011_02_13_LIS.lis2(arr);
		assertEquals(expected,actual);		
	}
}
