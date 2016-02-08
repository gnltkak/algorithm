package test;

import static org.junit.Assert.*;
import interview._2011_01_21_Combination;

import org.junit.Test;

public class Test_2011_01_21_Combination {
	private int[] array1 = new int[] {0};
	private int[] array2 = new int[] {0,1,2};
	private int[] array3 = new int[] {0,1,2,3};	
	
	@Test
	public void testCombination1() {		
		int k = 0;
		
		String expected = "";
		String actual = _2011_01_21_Combination.makeCombination(array1, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCombination2() {		
		int k = 1;
		
		String expected = "0\n";
		String actual = _2011_01_21_Combination.makeCombination(array1, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCombination3() {		
		int k = 2;
		
		String expected = "0,1\n0,2\n1,2\n";
		String actual = _2011_01_21_Combination.makeCombination(array2, k);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCombination4() {		
		int k = 3;
		
		String expected = "0,1,2\n0,1,3\n0,2,3\n1,2,3\n";
		String actual = _2011_01_21_Combination.makeCombination(array3, k);
		assertEquals(expected,actual);
	}

	@Test
	public void testCombination5() {
		int k = 0;

		String expected = "";
		String actual = _2011_01_21_Combination.makeCombination2(array1, k);
		assertEquals(expected,actual);
	}

	@Test
	public void testCombination6() {
		int k = 1;

		String expected = "0\n";
		String actual = _2011_01_21_Combination.makeCombination2(array1, k);
		assertEquals(expected,actual);
	}

	@Test
	public void testCombination7() {
		int k = 2;

		String expected = "0,1\n0,2\n1,2\n";
		String actual = _2011_01_21_Combination.makeCombination2(array2, k);
		assertEquals(expected,actual);
	}

	@Test
	public void testCombination8() {
		int k = 3;

		String expected = "0,1,2\n0,1,3\n0,2,3\n1,2,3\n";
		String actual = _2011_01_21_Combination.makeCombination2(array3, k);
		assertEquals(expected,actual);
	}
}