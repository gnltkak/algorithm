package test;

import static org.junit.Assert.*;
import interview._2011_03_31_MaxSubSquare;

import org.junit.Test;

public class Test_2011_03_31_MaxSubSquare {
	@Test
	public void testMaxSubSquare1() {		
		int[][] matrix = { {0} };
		String expected = "0,0,0";
		String actual = _2011_03_31_MaxSubSquare.findMaxSubSquare(matrix);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSquare2() {		
		int[][] matrix = { {1} };
		String expected = "0,0,1";
		String actual = _2011_03_31_MaxSubSquare.findMaxSubSquare(matrix);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSquare3() {		
		int[][] matrix = { {1,1},{1,1} };
		String expected = "0,0,2";
		String actual = _2011_03_31_MaxSubSquare.findMaxSubSquare(matrix);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSquare4() {		
		int[][] matrix = { 	{1,1,1,1,1,1,1,1,1},
							{1,0,1,0,0,0,0,0,0},
							{1,1,1,1,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0},
							{1,0,0,0,0,0,0,0,0}};
		String expected = "0,0,3";
		String actual = _2011_03_31_MaxSubSquare.findMaxSubSquare(matrix);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubSquare5() {		
		int[][] matrix = { 	{0,1,0,1,0},
							{1,1,1,1,1},
							{0,1,0,1,0},
							{1,1,1,1,1},
							{0,1,0,1,0},};
		String expected = "1,1,3";
		String actual = _2011_03_31_MaxSubSquare.findMaxSubSquare(matrix);
		assertEquals(expected,actual);
	}
}
