package test;

import static org.junit.Assert.*;
import interview._2011_05_10_LinearSelection;

import org.junit.Test;

public class Test_2011_05_10_LinearSelection {
	@Test
	public void testLinearSelection1() {
		int[] arr = {0};
		int expected = arr[0];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,0)];
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinearSelection2() {
		int[] arr = {0,1};
		int expected = arr[0];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,0)];
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinearSelection3() {
		int[] arr = {0,1};
		int expected = arr[1];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,1)];
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinearSelection4() {
		int[] arr = {0,1,2};
		int expected = arr[1];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,1)];
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinearSelection5() {
		int[] arr = {-10,5,-20,1,0,3,10};
		int expected = arr[2];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,0)];
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinearSelection6() {
		int[] arr = {-10,5,-20,1,0,3,10};
		int expected = arr[6];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,6)];
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLinearSelection7() {
		int[] arr = {-10,5,-20,1,0,3,10};
		int expected = arr[3];
		int actual = arr[_2011_05_10_LinearSelection.kthSmall(arr,3)];
		
		assertEquals(expected, actual);
	}
}
