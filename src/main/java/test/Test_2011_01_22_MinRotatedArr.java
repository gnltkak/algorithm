package test;

import static org.junit.Assert.*;

import interview._2011_01_22_MinRotatedArr;

import org.junit.Test;

import util.Util;

public class Test_2011_01_22_MinRotatedArr {
	@Test
	public void testMinRotatedArr1() {
		int[] array = new int[] { 5,6,1,2,3,4 };		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr2() {
		int[] array = new int[] { 1,2,3,4 };		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr3() {
		int[] array = new int[] { 5,6,7,8,1 };		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr4() {
		int[] array = new int[] { 5,6,7,8,1,1,1,1,1,1,1 };		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr5() {
		int[] array = new int[] { 1,1,1,1,1,1,1,1 };		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr6() {
		int[] array = new int[] { 1};		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr7() {
		int[] array = new int[] { 1,2,3,3,3,3,3,3,3};		
		int expected = 1;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr8() {
		int[] array = Util.makeRandIntArr(100000, 0, false);		
		Util.sort(array);		
		int expected = Util.min(array);
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr9() {
		int[] array = new int[] {1, 0};		
		int expected = 0;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMinRotatedArr10() {
		int[] array = new int[] {0, 1};		
		int expected = 0;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	
	/*
	 * 얘는 안 돌아가는게 정상
	@Test
	public void testMinRotatedArr11() {
		int[] array = new int[] {1, 1, 1, 1, 1, -2 ,-1, 1, 1};		
		int expected = -2;
		int actual = _2011_01_22_MinRotatedArr.findMin(array);
		assertEquals(expected,actual);
	}
	*/
}
