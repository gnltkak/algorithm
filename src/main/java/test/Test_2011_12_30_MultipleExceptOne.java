package test;

import static org.junit.Assert.*;
import interview._2011_12_30_MultipleExceptOne;

import org.junit.Test;

public class Test_2011_12_30_MultipleExceptOne {
	@Test
	public void testMultipleExceptOne1() throws Exception {
		int[] arr = {3, 1, 2};
		for (int k = 0; k < arr.length; ++k) {
			long expected = _2011_12_30_MultipleExceptOne.multipleExceptOneNaive(arr, k);
			long actual = _2011_12_30_MultipleExceptOne.multipleExceptOne1(arr, k);
			assertEquals(expected, actual);
			actual = _2011_12_30_MultipleExceptOne.multipleExceptOne2(arr, k);
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testMultipleExceptOne2() throws Exception {
		int[] arr = {0, 1, 2};
		for (int k = 0; k < arr.length; ++k) {
			long expected = _2011_12_30_MultipleExceptOne.multipleExceptOneNaive(arr, k);
			long actual = _2011_12_30_MultipleExceptOne.multipleExceptOne1(arr, k);
			assertEquals(expected, actual);
			actual = _2011_12_30_MultipleExceptOne.multipleExceptOne2(arr, k);
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testMultipleExceptOne3() throws Exception {
		int[] arr = {3, 1, 0};
		for (int k = 0; k < arr.length; ++k) {
			long expected = _2011_12_30_MultipleExceptOne.multipleExceptOneNaive(arr, k);
			long actual = _2011_12_30_MultipleExceptOne.multipleExceptOne1(arr, k);
			assertEquals(expected, actual);
			actual = _2011_12_30_MultipleExceptOne.multipleExceptOne2(arr, k);
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testMultipleExceptOne4() throws Exception {
		int[] arr = {3, 0, 2};
		for (int k = 0; k < arr.length; ++k) {
			long expected = _2011_12_30_MultipleExceptOne.multipleExceptOneNaive(arr, k);
			long actual = _2011_12_30_MultipleExceptOne.multipleExceptOne1(arr, k);
			assertEquals(expected, actual);
			actual = _2011_12_30_MultipleExceptOne.multipleExceptOne2(arr, k);
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testMultipleExceptOne5() throws Exception {
		int[] arr = {0, 3, 0};
		for (int k = 0; k < arr.length; ++k) {
			long expected = _2011_12_30_MultipleExceptOne.multipleExceptOneNaive(arr, k);
			long actual = _2011_12_30_MultipleExceptOne.multipleExceptOne1(arr, k);
			assertEquals(expected, actual);
			actual = _2011_12_30_MultipleExceptOne.multipleExceptOne2(arr, k);
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testMultipleExceptOne6() throws Exception {
		int[] arr = {10, 0, 20, 0, 1};
		for (int k = 0; k < arr.length; ++k) {
			long expected = _2011_12_30_MultipleExceptOne.multipleExceptOneNaive(arr, k);
			long actual = _2011_12_30_MultipleExceptOne.multipleExceptOne1(arr, k);
			assertEquals(expected, actual);
			actual = _2011_12_30_MultipleExceptOne.multipleExceptOne2(arr, k);
			assertEquals(expected, actual);
		}
	}
}
