package test2;

import static org.junit.Assert.*;
import interview2._2012_03_16_Prob1_3_FindFirstLarger;

import org.junit.Test;

public class test_2012_03_16_Prob1_3_FindFirstLarger {
	@Test
	public void testFindFirstLarger1() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = 6;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger2() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = 5;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger3() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = 0;
		int expected = 1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger4() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = -1;
		int expected = 0;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger5() throws Exception {
		int[] arr = {0,10,20,30,40};
		int k = 20;
		int expected = 3;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger6() throws Exception {
		int[] arr = {0,10,20,30,40};
		int k = 25;
		int expected = 3;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger7() throws Exception {
		int[] arr = {0};
		int k = 25;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger8() throws Exception {
		int[] arr = {0};
		int k = -1;
		int expected = 0;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger9() throws Exception {
		int[] arr = {0};
		int k = 0;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger10() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = 6;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger11() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = 5;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger12() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = 0;
		int expected = 1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger13() throws Exception {
		int[] arr = {0,1,2,3,4,5};
		int k = -1;
		int expected = 0;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger14() throws Exception {
		int[] arr = {0,10,20,30,40};
		int k = 20;
		int expected = 3;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger15() throws Exception {
		int[] arr = {0,10,20,30,40};
		int k = 25;
		int expected = 3;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger16() throws Exception {
		int[] arr = {0};
		int k = 25;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger17() throws Exception {
		int[] arr = {0};
		int k = -1;
		int expected = 0;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}

	@Test
	public void testFindFirstLarger18() throws Exception {
		int[] arr = {0};
		int k = 0;
		int expected = -1;
		int actual = _2012_03_16_Prob1_3_FindFirstLarger.findFirstLarger2(arr, k);
		assertEquals(expected, actual);
	}
}
