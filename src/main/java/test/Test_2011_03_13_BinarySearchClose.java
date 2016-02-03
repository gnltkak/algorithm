package test;

import static org.junit.Assert.*;
import interview._2011_03_13_BinarySearchClose;

import org.junit.Test;

public class Test_2011_03_13_BinarySearchClose {
	@Test
	public void testBSearchClosest1() {
		int[] arr = {1};
		int key = 10000;
		int expected = 1;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest2() {
		int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1};
		int key = 10000;
		int expected = 1;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest3() {
		int[] arr = {1,1,1,1,1,1,1,1,1,1,1,2};
		int key = 10000;
		int expected = 2;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest4() {
		int[] arr = {1,5,7,10,12,16,20,21,221,300};
		int key = 16;
		int expected = 16;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest5() {
		int[] arr = {1,5,7,10,12,16,20,21,221,300};
		int key = 15;
		int expected = 16;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest6() {
		int[] arr = {1,5,7,10,12,16,20,21,221,300};
		int key = -1;
		int expected = 1;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest7() {
		int[] arr = {1,2,100};
		int key = 3;
		int expected = 2;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSearchClosest8() {
		int[] arr = {1,3,100};
		int key = 2;
		int expected = 3;
		int actual = _2011_03_13_BinarySearchClose.bSearchClosest(arr, key);
		assertEquals(expected,actual);
	}
}
