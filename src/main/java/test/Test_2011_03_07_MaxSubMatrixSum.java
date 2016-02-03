package test;

import static org.junit.Assert.*;
import interview._2011_03_07_MaxSubMatrixSum;

import org.junit.Test;

import util.Util;

public class Test_2011_03_07_MaxSubMatrixSum {
	@Test
	public void testMaxSubMatrixSum1() {
		int[][] arr = { {1} }; 
		long expected = 1;
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSum(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum2() {
		int[][] arr = { {1,2},{3,4} }; 
		long expected = 10;
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSum(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum3() {
		int[][] arr = { {1,2},{-1,0} }; 
		long expected = 3;
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSum(arr);
		assertEquals(expected,actual);
	}
	
	//////////////////////////////////////////////////////////
	
	@Test
	public void testMaxSubMatrixSum4() {
		int[][] arr = { {1} }; 
		long expected = 1;
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSumJaeHwan(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum5() {
		int[][] arr = { {1,2},{3,4} }; 
		long expected = 10;
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSumJaeHwan(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum6() {
		int[][] arr = { {1,2},{-1,0} }; 
		long expected =3;
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSumJaeHwan(arr);
		assertEquals(expected,actual);
	}	
	
	//////////////////////////////////////////////////////////

	@Test
	public void testMaxSubMatrixSum7() {
		int[][] arr = { {1} }; 
		long expected = 1;
		long actual = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum8() {
		int[][] arr = { {1,2},{3,4} }; 
		long expected = 10;
		long actual = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum9() {
		int[][] arr = { {1,2},{-1,0} }; 
		long expected = 3;
		long actual = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		assertEquals(expected,actual);
	}
	
	//////////////////////////////////////////////////////////	
	
	@Test
	public void testMaxSubMatrixSum10() {
		int n = 50;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
			arr[i] = Util.makeRandIntArr(n,0,false);
		long expected = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSum(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum11() {
		int n = 100;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
			arr[i] = Util.makeRandIntArr(n,0,false);
		long expected = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSum(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum12() {
		int n = 150;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
			arr[i] = Util.makeRandIntArr(n,0,false);
		long expected = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSum(arr);
		assertEquals(expected,actual);
	}	

	//////////////////////////////////////////////////////////
	
	@Test
	public void testMaxSubMatrixSum13() {
		int n = 50;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
			arr[i] = Util.makeRandIntArr(n,0,false);
		long expected = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSumJaeHwan(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum14() {
		int n = 100;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
			arr[i] = Util.makeRandIntArr(n,0,false);
		long expected = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSumJaeHwan(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMaxSubMatrixSum15() {
		int n = 150;
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++)
			arr[i] = Util.makeRandIntArr(n,0,false);
		long expected = _2011_03_07_MaxSubMatrixSum.getMaxMatrix(arr);
		long actual = _2011_03_07_MaxSubMatrixSum.maxSubMatrixSumJaeHwan(arr);
		assertEquals(expected,actual);
	}
}
