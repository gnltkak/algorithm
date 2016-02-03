package test;

import static org.junit.Assert.*;
import interview._2011_01_22_Rotate;

import org.junit.Test;

import util.Util;

public class Test_2011_01_22_Rotate {
	@Test
	public void testRotate1(){
		int[] array = new int[] {1,2,3,4,5,6};
		int k = 2; //회전수
		
		String expected = "5\n6\n1\n2\n3\n4";
		_2011_01_22_Rotate.rotate(array,k);
		String actual = Util.arrayToString(array, "\n");
		
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testRotate2(){
		int[] array = new int[] {1,2,3,4,5,6};
		int k = 6; //회전수
		
		String expected = Util.arrayToString(array, "\n");
		_2011_01_22_Rotate.rotate(array,k);
		String actual = Util.arrayToString(array, "\n");
		
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testRotate3(){
		int[] array = new int[] {1,2,3,4,5,6};
		int k = 0; //회전수
		
		String expected = Util.arrayToString(array, "\n");
		_2011_01_22_Rotate.rotate(array,k);
		String actual = Util.arrayToString(array, "\n");
		
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testRotate4(){
		int[] array = new int[] {1,2,3,4,5,6};
		int k = 9; //회전수
		
		String expected = Util.arrayToString(new int[] {4,5,6,1,2,3},"\n");
		_2011_01_22_Rotate.rotate(array,k);
		String actual = Util.arrayToString(array, "\n");
		
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testRotate5(){
		int[] array = Util.makeRandIntArr(10000, 0, false);
		int[] arrayCopy = array.clone();
		int k = 999; //회전수
		
		_2011_01_22_Rotate.rotateNaive(array, k);
		String expected = Util.arrayToString(array,"\n");
		_2011_01_22_Rotate.rotate(arrayCopy,k);
		String actual = Util.arrayToString(arrayCopy, "\n");
		
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testRotate6(){
		int[] array = new int[] {};
		int k = 12; //회전수
		
		String expected = Util.arrayToString(new int[] {},"\n");
		_2011_01_22_Rotate.rotate(array,k);
		String actual = Util.arrayToString(array, "\n");
		
		assertEquals(expected,actual);		
	}
}
