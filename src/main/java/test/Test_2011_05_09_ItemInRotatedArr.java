package test;

import static org.junit.Assert.*;
import interview._2011_05_09_ItemInRotatedArr;

import org.junit.Test;

public class Test_2011_05_09_ItemInRotatedArr {
	@Test
	public void testItemInRotatedArr1() {
		int[] arr = {1};
		int key = 1;
		int expected = 0;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr2() {
		int[] arr = {1};
		int key = 0;
		int expected = -1;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr3() {
		int[] arr = {1,2,3,4};
		int key = 1;
		int expected = 0;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr4() {
		int[] arr = {1,2,3,4};
		int key = 4;
		int expected = 3;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr5() {
		int[] arr = {1,2,3,4};
		int key = 2;
		int expected = 1;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr6() {
		int[] arr = {1,2,3,4};
		int key = 3;
		int expected = 2;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr7() {
		int[] arr = {1,2,3};
		int key = 1;
		int expected = 0;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr8() {
		int[] arr = {1,2,3};
		int key = 2;
		int expected = 1;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr9() {
		int[] arr = {1,2,3};
		int key = 3;
		int expected = 2;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr10() {
		int[] arr = {3,4,1,2};
		int key = 3;
		int expected = 0;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr11() {
		int[] arr = {3,4,1,2};
		int key = 4;
		int expected = 1;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr12() {
		int[] arr = {3,4,1,2};
		int key = 1;
		int expected = 2;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr13() {
		int[] arr = {3,4,1,2};
		int key = 2;
		int expected = 3;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr14() {
		int[] arr = {10,1,2,3,4,5,6};
		int key = 10;
		int expected = 0;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr15() {
		int[] arr = {10,1,2,3,4,5,6};
		int key = 6;
		int expected = 6;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr16() {
		int[] arr = {10,1,2,3,4,5,6};
		int key = 2;
		int expected = 2;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr17() {
		int[] arr = {10,1,2,3,4,5,6};
		int key = 4;
		int expected = 4;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr18() {
		int[] arr = {10,1,2,3,4,5,6};
		int key = -1;
		int expected = -1;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr19() {
		int[] arr = {10,1,2,3,4,5,6};
		int key = 9;
		int expected = -1;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testItemInRotatedArr20() {
		int[] arr = {10,20,1,2,3,3,3,3,3};
		int key = 10;
		int expected = 0;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	
	/*
	 * 얘는 안돌아가야 정상
	@Test
	public void testItemInRotatedArr21() {
		int[] arr = {1,1,1,1,1,-2,-1,1,1};
		int key = -2;
		int expected = 5;
		int actual = _2011_05_09_ItemInRotatedArr.findItem(arr, key);
		assertEquals(expected,actual);
	}
	*/
}
