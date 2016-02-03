package test;

import static org.junit.Assert.*;
import interview._2011_03_14_KthSmall;

import org.junit.Test;

public class Test_2011_03_14_KthSmall {
	@Test
	public void testKthSmall1() {
		int[] arr = {1};
		int k = 1;
		int expected = 1;		
		int actual = _2011_03_14_KthSmall.kthSmall(arr, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKthSmall2() {
		int[] arr = {1,1};
		int k = 1;
		int expected = 1;
		int actual = _2011_03_14_KthSmall.kthSmall(arr, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKthSmall3() {
		int[] arr = {1,1,1};
		int k = 1;
		int expected = 1;
		int actual = _2011_03_14_KthSmall.kthSmall(arr, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKthSmall4() {
		int[] arr = {1,2,3};
		int k = 3;
		int expected = 3;
		int actual = _2011_03_14_KthSmall.kthSmall(arr, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKthSmall5() {
		int[] arr = {1,2,3};
		int k = 1;
		int expected = 1;
		int actual = _2011_03_14_KthSmall.kthSmall(arr, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKthSmall6() {
		int[] arr = {121,20,3124,1240,-127,124,12379124,124,0,-1,-2};
		int k = 5;
		int expected = 20;
		int actual = _2011_03_14_KthSmall.kthSmall(arr, k);
		assertEquals(expected,actual);
	}
}
