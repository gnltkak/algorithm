package test;

import static org.junit.Assert.*;
import interview._2011_03_01_ArrayRotate;

import org.junit.Test;

import util.Util;

public class Test_2011_03_01_ArrayRotate {
	@Test
	public void testArrayRotate1() {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};		
		
		String expected = Util.matrixToString(new int[][] {{3,6,9},{2,5,8},{1,4,7}},",");		
		_2011_03_01_ArrayRotate.rotate(matrix);		
		String actual = Util.matrixToString(matrix,",");
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testArrayRotate2() {
		int[][] matrix = {{1}};		
		
		String expected = Util.matrixToString(new int[][] {{1}},",");		
		_2011_03_01_ArrayRotate.rotate(matrix);		
		String actual = Util.matrixToString(matrix,",");
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testArrayRotate3() {
		int[][] matrix = {{1,2},{3,4}};		
		
		String expected = Util.matrixToString(new int[][] {{2,4},{1,3}},",");		
		_2011_03_01_ArrayRotate.rotate(matrix);		
		String actual = Util.matrixToString(matrix,",");
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testArrayRotate4() {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};		
		
		String expected = Util.matrixToString(new int[][] {{4,8,12,16},{3,7,11,15},{2,6,10,14},{1,5,9,13}},",");		
		_2011_03_01_ArrayRotate.rotate(matrix);		
		String actual = Util.matrixToString(matrix,",");
		
		assertEquals(expected,actual);
	}
}
