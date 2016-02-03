package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import interview._2011_01_17_Intersection;

import org.junit.Test;

import util.Util;

public class Test_2011_01_17_Intersection {	
	@Test
	public void testIntersection1() {
		int[] small = new int[] {1,1,2,3,6,10,11,23};
		int[] large = new int[] {1,3,11,20,44,77,79,80,80,80,80,81,82,83,99,100,110,110};
		
		String expected = Util.arrayToString(new int[] {1,1,3,11},"\n");
		String actual = Util.arrayToString(_2011_01_17_Intersection.intersection(small, large),"\n");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIntersection2() {
		ArrayList<Integer> small = Util.makeRandIntArrayList(1000,100000000,true);
		ArrayList<Integer> large = Util.makeRandIntArrayList(123456,10000000,true);
		
		Collections.sort(small);
		Collections.sort(large);	
		
		int[] smallArr,largeArr;
		Integer[] smallTemp = new Integer[small.size()];
		Integer[] largeTemp = new Integer[large.size()];
		
		smallArr = Util.integerArrToIntArr(small.toArray(smallTemp)); 
		largeArr = Util.integerArrToIntArr(large.toArray(largeTemp));		
		
		//무식한 방법[?]으로 intersection을 구한다. O(nlogm)
		ArrayList<Integer> naiveResult = new ArrayList<Integer>();			
		for(int i=0;i<small.size();i++)
		{
			int num = small.get(i);
			if(Util.binarySearch(large, num, 0, large.size()-1)>0)
				naiveResult.add(num);
		}		
		
		String expected = Util.arrayToString(naiveResult, "\n");
		String actual = Util.arrayToString(_2011_01_17_Intersection.intersection(smallArr, largeArr),"\n");
		
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testIntersection3() {
		int[] small = new int[] {1};
		int[] large = new int[] {1,1,1,1,1,1,1,1,1,1,
				 4,4,4,4,4,4,4,4,4,4,
				 4,4,4,4,4,4,4,4,4,4};
		
		String expected = Util.arrayToString(new int[] {1},"\n");
		String actual = Util.arrayToString(_2011_01_17_Intersection.intersection(small, large),"\n");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIntersection4() {
		int[] small = new int[] {1};
		int[] large = new int[] {1,1,1,1,1,1,1,1,1,1,
				 1,1,1,1,1,1,1,1,1,1,
				 1,1,1,1,1,1,1,1,1,1};
		
		String expected = Util.arrayToString(new int[] {1},"\n");
		String actual = Util.arrayToString(_2011_01_17_Intersection.intersection(small, large),"\n");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIntersection5() {
		int[] small = new int[] {4};
		int[] large = new int[] {4,4,4,4,4,4,4,4,4,4,
				 4,4,4,4,4,4,4,4,4,4,
				 4,4,4,4,4,4,4,4,4,4};
		
		String expected = Util.arrayToString(new int[] {4},"\n");
		String actual = Util.arrayToString(_2011_01_17_Intersection.intersection(small, large),"\n");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIntersection6() {
		int[] small = new int[] {1, 5, 10};
		int[] large = new int[] {5};
		
		String expected = Util.arrayToString(new int[] {5},"\n");
		String actual = Util.arrayToString(_2011_01_17_Intersection.intersection(small, large),"\n");
		
		assertEquals(expected, actual);
	}
}
