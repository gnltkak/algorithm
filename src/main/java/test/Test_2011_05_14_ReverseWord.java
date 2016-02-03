package test;

import static org.junit.Assert.*;
import interview._2011_05_14_ReverseWord;

import org.junit.Test;

public class Test_2011_05_14_ReverseWord {
	@Test
	public void testReverseWord1() {
		char[] arr = "abc def 123".toCharArray();
		_2011_05_14_ReverseWord.reverseWord(arr);
		String expected = "123 def abc";
		String actual = new String(arr);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseWord2() {
		char[] arr = "abc defg 1".toCharArray();
		_2011_05_14_ReverseWord.reverseWord(arr);
		String expected = "1 defg abc";
		String actual = new String(arr);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseWord3() {
		char[] arr = "1 1 1".toCharArray();
		_2011_05_14_ReverseWord.reverseWord(arr);
		String expected = "1 1 1";
		String actual = new String(arr);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseWord4() {
		char[] arr = "1 2 3".toCharArray();
		_2011_05_14_ReverseWord.reverseWord(arr);
		String expected = "3 2 1";
		String actual = new String(arr);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseWord5() {
		char[] arr = "1111111".toCharArray();
		_2011_05_14_ReverseWord.reverseWord(arr);
		String expected = "1111111";
		String actual = new String(arr);
		
		assertEquals(expected, actual);
	}
}
