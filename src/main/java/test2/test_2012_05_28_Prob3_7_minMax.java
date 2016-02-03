package test2;

import static org.junit.Assert.*;
import interview2._2012_05_28_Prob3_7_minMax;

import org.junit.Test;

public class test_2012_05_28_Prob3_7_minMax {
	@Test
	public void testMinMax1() throws Exception {
		int[] a = {1, 2, 3};
		int[] b = {0, -1, -2};
		int expected = 1;
		int actual = _2012_05_28_Prob3_7_minMax.minMax(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax2() throws Exception {
		int[] a = {1, 2, 3};
		int[] b = {1, 1, 1};
		int expected = 1;
		int actual = _2012_05_28_Prob3_7_minMax.minMax(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax3() throws Exception {
		int[] a = {10, 20, 30};
		int[] b = {60, 50, 40};
		int expected = 40;
		int actual = _2012_05_28_Prob3_7_minMax.minMax(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax4() throws Exception {
		int[] a = {10, 20, 30, 40};
		int[] b = {30, 20, 10, 5};
		int expected = 20;
		int actual = _2012_05_28_Prob3_7_minMax.minMax(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax5() throws Exception {
		int[] a = {10, 20, 30, 40};
		int[] b = {45, 35, 25, 15};
		int expected = 30;
		int actual = _2012_05_28_Prob3_7_minMax.minMax(a, b);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMinMax6() throws Exception {
		int[] a = {10, 20, 30, 40};
		int[] b = {38, 28, 18, 8};
		int expected = 28;
		int actual = _2012_05_28_Prob3_7_minMax.minMax(a, b);
		assertEquals(expected, actual);
	}
}
