package test2;

import static org.junit.Assert.*;
import interview2._2012_05_28_Prob3_5_SubsetSum;

import org.junit.Test;

public class test_2012_05_28_Prob3_5_SubsetSum {
	@Test
	public void testSubsetSum1() throws Exception {
		int[] arr = {2};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = false;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum2() throws Exception {
		int[] arr = {1, 3};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = false;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum3() throws Exception {
		int[] arr = {1, 2, 3, 6};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum4() throws Exception {
		int[] arr = {8, 5, 3};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum5() throws Exception {
		int[] arr = {4, 1, 3, 2};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum6() throws Exception {
		int[] arr = {5, 5, 5, 5};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum7() throws Exception {
		int[] arr = {5, 4, 5, 6};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum8() throws Exception {
		int[] arr = {4, 1, 2, 7, 20};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = false;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum9() throws Exception {
		int[] arr = {2, 2, 1, 5};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubsetSum10() throws Exception {
		int[] arr = {1, 2, 3, 4};
		int s = 0;
		for (int i = 0; i < arr.length; ++i) s+= arr[i];
		s /= 2;
		boolean expected = true;
		boolean actual = _2012_05_28_Prob3_5_SubsetSum.subsetExist(arr, s);
		assertEquals(expected, actual);
	}
}
