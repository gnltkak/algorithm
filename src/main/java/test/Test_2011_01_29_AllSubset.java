package test;

import static org.junit.Assert.*;
import interview._2011_01_29_AllSubset;

import org.junit.Test;

public class Test_2011_01_29_AllSubset {
	@Test
	public void testAllSubset1() {
		int[] arr = new int[] {1};
		String expected = "{}\n{1}\n";
		String actual = _2011_01_29_AllSubset.allSubset(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testAllSubset2() {
		int[] arr = new int[] {1,2};
		String expected = "{}\n{1}\n{2}\n{1,2}\n";
		String actual = _2011_01_29_AllSubset.allSubset(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testAllSubset3() {
		int[] arr = new int[] {1,2,3};
		String expected = "{}\n{1}\n{2}\n{3}\n{1,2}\n{1,3}\n{2,3}\n{1,2,3}\n";
		String actual = _2011_01_29_AllSubset.allSubset(arr);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testAllSubset4() {
		int[] arr = new int[] {1,2,3,4};
		String expected = "{}\n{1}\n{2}\n{3}\n{4}\n{1,2}\n{1,3}\n{1,4}\n{2,3}\n{2,4}\n{3,4}\n{1,2,3}\n{1,2,4}\n{1,3,4}\n{2,3,4}\n{1,2,3,4}\n";
		String actual = _2011_01_29_AllSubset.allSubset(arr);
		assertEquals(expected,actual);
	}
}
