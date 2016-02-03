package test;

import static org.junit.Assert.*;
import interview._2011_01_25_FindHole;

import org.junit.Test;

import util.Util;

public class Test_2011_01_25_FindHole {
	@Test
	public void testFindHole1() {
		int[] array = {10,0,1,2,5,7};		
		int result = _2011_01_25_FindHole.findHole4n(array);
		System.out.println(result);
		assertEquals(false,Util.isInArray(array, result));
	}
	
	@Test
	public void testFindHole2() {
		int[] array = Util.makeRandIntArr(1000, Integer.MAX_VALUE, true);
		int result = _2011_01_25_FindHole.findHole4n(array);
		assertEquals(false,Util.isInArray(array, result));
	}
	
	@Test
	public void testFindHole3() {
		int[] array = Util.makeRandIntArr(40000, Integer.MAX_VALUE, true);
		int result = _2011_01_25_FindHole.findHole4n(array);
		assertEquals(false,Util.isInArray(array, result));
	}
	
	@Test
	public void testFindHole4() {
		int[] array = Util.makeRandIntArr(100000, Integer.MAX_VALUE, true);
		int result = _2011_01_25_FindHole.findHole4n(array);
		assertEquals(false,Util.isInArray(array, result));
	}
	
	@Test
	public void testFindHole5() {
		int[] array = Util.makeRandIntArr(500000, Integer.MAX_VALUE, true);
		int result = _2011_01_25_FindHole.findHole4n(array);
		assertEquals(false,Util.isInArray(array, result));
	}
	
	@Test
	public void testFindHole6() {
		int[] array = Util.makeRandIntArr(1000000, Integer.MAX_VALUE, true);
		int result = _2011_01_25_FindHole.findHole4n(array);
		assertEquals(false,Util.isInArray(array, result));
	}
	
	@Test
	public void testFindHole7() {
		int[] array = new int[] {2,3,4,5};
		int expected = 0;
		int actual = _2011_01_25_FindHole.findHole2n(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindHole8() {
		int[] array = new int[] {0,1,2,3,4,5,100,101};
		int expected = 6;
		int actual = _2011_01_25_FindHole.findHole2n(array);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindHole9() {
		int[] array = Util.makeRandIntArr(1000000, Integer.MAX_VALUE, true);
		Util.sort(array);
		int expected = -1;
		for(int i=0;i<Integer.MAX_VALUE;i++)
		{
			if(Util.binarySearch(array, i, 0, array.length)<0)
			{
				expected = i;
				break;
			}
		}
		int actual = _2011_01_25_FindHole.findHole2n(array);
		assertEquals(expected,actual);
	}
}
