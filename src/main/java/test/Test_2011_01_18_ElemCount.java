package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import interview._2011_01_18_ElemCount;

import org.junit.Test;

import util.Util;

public class Test_2011_01_18_ElemCount {
	@Test
	public void testElemCount1() {
		int[] array = new int[] {1,1,2,5,8,10,10,10,10,10};
		
		assertEquals(2, _2011_01_18_ElemCount.elemCount(array,1));
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array,-10));
		assertEquals(5, _2011_01_18_ElemCount.elemCount(array,10));
	}
	
	@Test
	public void testElemCount2() {
		ArrayList<Integer> arr = Util.makeRandIntArrayList(100, 10, true);
		Collections.sort(arr);
		int[] array = Util.integerArrListToIntArr(arr);
		
		assertEquals(elemCountNaive(array,1),_2011_01_18_ElemCount.elemCount(array,1));
		assertEquals(elemCountNaive(array,-1),_2011_01_18_ElemCount.elemCount(array,-1));
		assertEquals(elemCountNaive(array,5),_2011_01_18_ElemCount.elemCount(array,5));
		assertEquals(elemCountNaive(array,3),_2011_01_18_ElemCount.elemCount(array,3));
		assertEquals(elemCountNaive(array,8),_2011_01_18_ElemCount.elemCount(array,8));
	}
	
	@Test
	public void testElemCount3() {
		ArrayList<Integer> arr = Util.makeRandIntArrayList(1000000, 0, false);
		Collections.sort(arr);
		int[] array = Util.integerArrListToIntArr(arr);
		
		assertEquals(elemCountNaive(array,1),_2011_01_18_ElemCount.elemCount(array,1));
		assertEquals(elemCountNaive(array,100000),_2011_01_18_ElemCount.elemCount(array,100000));
		assertEquals(elemCountNaive(array,-200),_2011_01_18_ElemCount.elemCount(array,-200));
		assertEquals(elemCountNaive(array,3),_2011_01_18_ElemCount.elemCount(array,3));
		assertEquals(elemCountNaive(array,11118),_2011_01_18_ElemCount.elemCount(array,11118));
	}
	
	@Test
	public void testElemCount4() {
		int[] array = new int[] {1};
		
		assertEquals(1, _2011_01_18_ElemCount.elemCount(array,1));
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array,0));
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array,2));
	}
	
	@Test
	public void testElemCount5() {
		int[] array = new int[] {0, 2};
		
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array, -1));
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array, 1));
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array, 3));
		assertEquals(1, _2011_01_18_ElemCount.elemCount(array, 0));
		assertEquals(1, _2011_01_18_ElemCount.elemCount(array, 2));
	}
	
	@Test
	public void testElemCount6() {
		int[] array = new int[] {1, 1};
		
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array, 0));
		assertEquals(0, _2011_01_18_ElemCount.elemCount(array, 2));
		assertEquals(2, _2011_01_18_ElemCount.elemCount(array, 1));		
	}
	
	//naive 한 방법으로 원소의 수를 센다. ( O(n) )
	private int elemCountNaive(int[] array,int num) {
		int count = 0;
		
		for(int i=0;i<array.length;i++)
		{
			if(array[i]==num)
				count++;
		}
		
		return count;
	}	
}