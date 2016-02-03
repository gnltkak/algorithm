package test;

import static org.junit.Assert.*;
import interview._2011_05_16_SetArrWithZero;

import org.junit.Test;

import util.Util;

public class Test_2011_05_16_SetArrWithZero {
	@Test
	public void testSetArrWithZero1() {
		int[][] arr = { {1} };
		
		String expected = "1";		
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero2() {
		int[][] arr = { {0} };
		
		String expected = "0";		
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero3() {
		int[][] arr = { {0,1},
						{1,2}
		};
		
		String expected = "0,0\n0,2";		
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero4() {
		int[][] arr = { {1,2},
						{3,4}
		};
		
		String expected = "1,2\n3,4";		
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero5() {
		int[][] arr = { {1,2,3,4},
						{5,6,0,0},
						{0,8,9,10}
		};
		
		String expected = "0,2,0,0\n" +
						  "0,0,0,0\n" +
						  "0,0,0,0";
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero6() {
		int[][] arr = { {1,2,3,4},
						{0,6,5,5},
						{0,8,9,10}
		};
		
		String expected = "0,2,3,4\n" +
						  "0,0,0,0\n" +
						  "0,0,0,0";
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero7() {
		int[][] arr = { {1,1,1,1},
						{1,1,0,1},
						{1,1,1,1},
						{1,1,1,1},
						{1,1,1,1},
						{1,1,1,1},
		};
		
		String expected = "1,1,0,1\n" +
						  "0,0,0,0\n" +
						  "1,1,0,1\n" +
						  "1,1,0,1\n" +
						  "1,1,0,1\n" +
						  "1,1,0,1";
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSetArrWithZero8() {
		int[][] arr = { {0,0,0,0},
						{0,1,1,1},
						{0,1,1,1},
						{0,1,1,1},
						{0,1,1,1},
						{0,1,1,1},
		};
		
		String expected = "0,0,0,0\n" +
						  "0,0,0,0\n" +
						  "0,0,0,0\n" +
						  "0,0,0,0\n" +
						  "0,0,0,0\n" +
						  "0,0,0,0";
		_2011_05_16_SetArrWithZero.setArrWithZero(arr);
		String actual = Util.arrayToString(arr, ",","\n");
		assertEquals(expected, actual);		
	}
}
