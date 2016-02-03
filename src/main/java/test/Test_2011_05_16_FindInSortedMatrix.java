package test;

import static org.junit.Assert.*;
import interview._2011_05_16_FindInSortedMatrix;

import org.junit.Test;

public class Test_2011_05_16_FindInSortedMatrix {
	@Test
	public void testFindInSortedMatrix1() {
		int[][] matrix = { {1} };
		int key = 1;
		String expected = "0,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix2() {
		int[][] matrix = { {1} };
		int key = 0;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix3() {
		int[][] matrix = { {1,2},
						   {3,4}};
		int key = 0;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix4() {
		int[][] matrix = { {1,2},
						   {3,4}};
		int key = 3;
		String expected = "1,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix5() {
		int[][] matrix = { {1,2},
						   {3,4}};
		int key = 4;
		String expected = "1,1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix6() {
		int[][] matrix = { {1,2},
						   {3,4}};
		int key = 2;
		String expected = "0,1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix7() {
		int[][] matrix = { {1,2},
						   {3,4}};
		int key = 1;
		String expected = "0,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix8() {
		int[][] matrix = { {1,4,5,6},
						   {2,7,8,9},
						   {3,10,11,12},
						   {4,12,13,15}};
		int key = 1;
		String expected = "0,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix9() {
		int[][] matrix = { {1,4,5,6},
						   {2,7,8,9},
						   {3,10,11,12},
						   {4,12,13,15}};
		int key = 3;
		String expected = "2,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix10() {
		int[][] matrix = { {1,4,5,6},
						   {2,7,8,9},
						   {3,10,11,12},
						   {4,12,13,15}};
		int key = 15;
		String expected = "3,3";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix11() {
		int[][] matrix = { {1,4,5,6},
						   {2,7,8,9},
						   {3,10,11,12},
						   {4,12,13,15}};
		int key = 18;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix12() {
		int[][] matrix = { {1,4,5,6},
						   {2,7,8,9},
						   {3,10,11,12},
						   {4,12,13,15}};
		int key = 0;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix13() {
		int[][] matrix = { {1,4,5,6},
						   {2,7,8,9},
						   {3,10,11,12},
						   {4,12,13,15}};
		int key = 8;
		String expected = "1,2";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix14() {
		int[][] matrix = { {1,4,5,6}};
						   
		int key = 8;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix15() {
		int[][] matrix = { {1,4,5,6}};
						   
		int key = 0;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix16() {
		int[][] matrix = { {1,4,5,6}};
						   
		int key = 3;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix17() {
		int[][] matrix = { {1,4,5,6}};
						   
		int key = 4;
		String expected = "0,1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix18() {
		int[][] matrix = { {1,4,5,6}};
						   
		int key = 1;
		String expected = "0,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix19() {
		int[][] matrix = { {1,4,5,6}};
						   
		int key = 1;
		String expected = "0,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix20() {
		int[][] matrix = { {1}
							,{4}
							,{5}
							,{6}};
						   
		int key = 1;
		String expected = "0,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix21() {
		int[][] matrix = { {1}
							,{4}
							,{5}
							,{6}};
						   
		int key = 6;
		String expected = "3,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix22() {
		int[][] matrix = { {1}
							,{4}
							,{5}
							,{6}};
						   
		int key = 4;
		String expected = "1,0";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix23() {
		int[][] matrix = { {1}
							,{4}
							,{5}
							,{6}};
						   
		int key = 0;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix24() {
		int[][] matrix = { {1}
							,{4}
							,{5}
							,{6}};
						   
		int key = 8;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindInSortedMatrix25() {
		int[][] matrix = { {1}
							,{4}
							,{5}
							,{6}};
						   
		int key = 2;
		String expected = "-1,-1";
		String actual = _2011_05_16_FindInSortedMatrix.findInSortedMatrix(matrix, key);
		assertEquals(expected, actual);
	}
}
