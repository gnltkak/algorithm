package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import interview._2011_12_30_Sorting;

import org.junit.Test;

import util.Util;

public class Test_2011_12_30_Sorting {
	@Test
	public void testQuickSort1() throws Exception {
		int[] arr = new int[] {0};
		int[] expected = new int[] {0};
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testQuickSort2() throws Exception {
		int[] arr = new int[] {0, 1};
		int[] expected = new int[] {0, 1};
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testQuickSort3() throws Exception {
		int[] arr = new int[] {0, 1, 2};
		int[] expected = new int[] {0, 1, 2};
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testQuickSort4() throws Exception {
		int[] arr = new int[] {0, 1, 2, 3};
		int[] expected = new int[] {0, 1, 2, 3};
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testQuickSort5() throws Exception {
		int[] arr = new int[] {0, 4, 1, 2};
		int[] expected = new int[] {0, 1, 2, 4};
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testQuickSort6() throws Exception {
		int[] arr = new int[] {4, 7, 3, 10};
		int[] expected = new int[] {3, 4, 7, 10};
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testQuickSort7() throws Exception {
		int[] arr = Util.makeRandIntArr(1000, 0, false);
		int[] expected = arr.clone();
		Util.sort(expected);
		
		String delim = ",";
		_2011_12_30_Sorting.quickSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort1() throws Exception {
		int[] arr = new int[] {0};
		int[] expected = new int[] {0};
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort2() throws Exception {
		int[] arr = new int[] {0, 1};
		int[] expected = new int[] {0, 1};
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort3() throws Exception {
		int[] arr = new int[] {1, 0};
		int[] expected = new int[] {0, 1};
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort4() throws Exception {
		int[] arr = new int[] {0, 1, 2};
		int[] expected = new int[] {0, 1, 2};
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort5() throws Exception {
		int[] arr = new int[] {2, 1, 0};
		int[] expected = new int[] {0, 1, 2};
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort6() throws Exception {
		int[] arr = new int[] {0, 1, 3, 2};
		int[] expected = new int[] {0, 1, 2, 3};
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
	
	@Test
	public void testMergeSort7() throws Exception {
		int[] arr = Util.makeRandIntArr(1000, 0, false);
		int[] expected = arr.clone();
		Util.sort(expected);
		
		String delim = ",";
		_2011_12_30_Sorting.mergeSort(arr);
		
		assertEquals(Util.arrayToString(expected, delim), Util.arrayToString(arr, delim));
	}
}
