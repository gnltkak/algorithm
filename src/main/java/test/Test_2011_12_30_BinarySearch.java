package test;

import static org.junit.Assert.*;
import interview._2011_12_30_BinarySearch;

import org.junit.Test;

public class Test_2011_12_30_BinarySearch {
	@Test
	public void testBinarySearchIterative1() {
		int[] arr = new int[] {};
		int num = 0;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative2() {
		int[] arr = new int[] {0};
		int num = 0;
		
		int expected = 0;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative3() {
		int[] arr = new int[] {0};
		int num = -1;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative4() {
		int[] arr = new int[] {0};
		int num = 1;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative5() {
		int[] arr = new int[] {0, 1};
		int num = -1;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative6() {
		int[] arr = new int[] {0, 1};
		int num = 2;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative7() {
		int[] arr = new int[] {0, 1};
		int num = 0;
		
		int expected = 0;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative8() {
		int[] arr = new int[] {0, 1};
		int num = 1;
		
		int expected = 1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative9() {
		int[] arr = new int[] {0, 1, 2};
		int num = -1;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative10() {
		int[] arr = new int[] {0, 1, 2};
		int num = 3;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative11() {
		int[] arr = new int[] {0, 1, 2};
		int num = 0;
		
		int expected = 0;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative12() {
		int[] arr = new int[] {0, 1, 2};
		int num = 1;
		
		int expected = 1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative13() {
		int[] arr = new int[] {0, 1, 2};
		int num = 2;
		
		int expected = 2;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative14() {
		int[] arr = new int[] {0, 2, 4};
		int num = 1;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative15() {
		int[] arr = new int[] {0, 2, 4};
		int num = 3;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative16() {
		int[] arr = new int[] {0, 2, 4, 6};
		int num = 1;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative17() {
		int[] arr = new int[] {0, 2, 4, 6};
		int num = 3;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBinarySearchIterative18() {
		int[] arr = new int[] {0, 2, 4, 6};
		int num = 5;
		
		int expected = -1;
		int actual = _2011_12_30_BinarySearch.binarySearchIterative(arr, num);
		assertEquals(expected, actual);
	}
}
