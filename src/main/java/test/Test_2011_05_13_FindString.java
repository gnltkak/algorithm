package test;

import static org.junit.Assert.*;
import interview._2011_05_13_FindString;

import org.junit.Test;

public class Test_2011_05_13_FindString {
	@Test
	public void testFindString1() {
		String[] arr = {""};
		String key = "a";
		int expected = -1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString2() {
		String[] arr = {"a"};
		String key = "a";
		int expected = 0;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString3() {
		String[] arr = {"a","b","c","d"};
		String key = "a";
		int expected = 0;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString4() {
		String[] arr = {"a","b","c","d"};
		String key = "d";
		int expected = 3;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString5() {
		String[] arr = {"a","b","c","d"};
		String key = "b";
		int expected = 1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString6() {
		String[] arr = {"a","b","c","d"};
		String key = "c";
		int expected = 2;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString7() {
		String[] arr = {"a","b","c"};
		String key = "a";
		int expected = 0;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString8() {
		String[] arr = {"a","b","c"};
		String key = "b";
		int expected = 1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString10() {
		String[] arr = {"a","b","c"};
		String key = "c";
		int expected = 2;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString11() {
		String[] arr = {"a","","",""};
		String key = "a";
		int expected = 0;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString12() {
		String[] arr = {"a","","",""};
		String key = "b";
		int expected = -1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString13() {
		String[] arr = {"","","","b"};
		String key = "b";
		int expected = 3;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString14() {
		String[] arr = {"","","","b"};
		String key = "a";
		int expected = -1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString15() {
		String[] arr = {"","","",""};
		String key = "a";
		int expected = -1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString17() {
		String[] arr = {"","a","b",""};
		String key = "a";
		int expected = 1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString18() {
		String[] arr = {"","a","b",""};
		String key = "b";
		int expected = 2;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString19() {
		String[] arr = {"","a","","","b","c",""};
		String key = "b";
		int expected = 4;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString20() {
		String[] arr = {"","a","","","b","c",""};
		String key = "a";
		int expected = 1;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindString21() {
		String[] arr = {"","a","","","b","c",""};
		String key = "c";
		int expected = 5;
		int actual = _2011_05_13_FindString.findString(arr, key);
		
		assertEquals(expected, actual);
	}
}
