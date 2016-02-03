package test;

import static org.junit.Assert.*;
import interview._2011_02_03_FindMissing;

import org.junit.Test;

public class Test_2011_02_03_FindMissing {
	@Test
	public void testFindMissing1() {
		int[] arr = new int[] {1,2,3,4,5};
		int expected = 0;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindMissing2() {
		int[] arr = new int[] {0,1,2,3,4,5};
		int expected = 6;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindMissing3() {
		int[] arr = new int[] {0,1,2,4,5,6};
		int expected = 3;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindMissing4() {
		int[] arr = new int[] {0};
		int expected = 1;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindMissing5() {
		int[] arr = new int[] {1};
		int expected = 0;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	
	@Test
	public void testFindMissing6() {
		int[] arr = new int[] {0, 1};
		int expected = 2;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindMissing7() {
		int[] arr = new int[] {1, 2};
		int expected = 0;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFindMissing8() {
		int[] arr = new int[] {0, 2};
		int expected = 1;
		int actual = _2011_02_03_FindMissing.findMissing(arr);
		assertEquals(expected,actual);
	}
}
