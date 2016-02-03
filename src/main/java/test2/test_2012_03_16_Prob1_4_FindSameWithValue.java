package test2;

import static org.junit.Assert.*;
import interview2._2012_03_16_Prob1_4_FindSameWithValue;

import org.junit.Test;

public class test_2012_03_16_Prob1_4_FindSameWithValue {
	@Test
	public void testFindSameWihtValue1() throws Exception {
		int[] arr = {1,2,3,4};
		int expected = -1;
		int actual = _2012_03_16_Prob1_4_FindSameWithValue.findSameWithValue(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindSameWihtValue2() throws Exception {
		int[] arr = {0,2,3,4};
		int expected = 0;
		int actual = _2012_03_16_Prob1_4_FindSameWithValue.findSameWithValue(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindSameWihtValue3() throws Exception {
		int[] arr = {-10,-5,0,3};
		int expected = 3;
		int actual = _2012_03_16_Prob1_4_FindSameWithValue.findSameWithValue(arr);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindSameWihtValue4() throws Exception {
		int[] arr = {-1,1,3,4};
		int expected = 1;
		int actual = _2012_03_16_Prob1_4_FindSameWithValue.findSameWithValue(arr);
		assertEquals(expected, actual);
	}
}
