package test;

import static org.junit.Assert.*;
import interview._2011_03_11_LongestWord;

import org.junit.Test;

public class Test_2011_03_11_LongestWord {
	@Test
	public void testLongestWord1() {
		String[] word = {"test", "tester", "testertest", "testing", "testingtester" };
		String expected = "testingtester";
		String actual = _2011_03_11_LongestWord.longestWord(word);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLongestWord2() {
		String[] word = {"a", "a", "a", "a", "a" };
		String expected = "";
		String actual = _2011_03_11_LongestWord.longestWord(word);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLongestWord3() {
		String[] word = {"a", "aa", "aaa", "aaaa", "aaaaa" };
		String expected = "aaaaa";
		String actual = _2011_03_11_LongestWord.longestWord(word);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLongestWord4() {
		String[] word = {"a", "ab", "abb", "abbb", "abbbb" };
		String expected = "";
		String actual = _2011_03_11_LongestWord.longestWord(word);
		assertEquals(expected,actual);
	}
	
	///////////////////////////////////////////////////////////////
	
	@Test
	public void testLongestWord5() {
		String[] word = {"test", "tester", "testertest", "testing", "testingtester" };
		String expected = "testingtester";
		String actual = _2011_03_11_LongestWord.longestWord2(word);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLongestWord6() {
		String[] word = {"a", "a", "a", "a", "a" };
		String expected = "";
		String actual = _2011_03_11_LongestWord.longestWord2(word);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLongestWord7() {
		String[] word = {"a", "aa", "aaa", "aaaa", "aaaaa" };
		String expected = "aaaaa";
		String actual = _2011_03_11_LongestWord.longestWord2(word);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLongestWord8() {
		String[] word = {"a", "ab", "abb", "abbb", "abbbb" };
		String expected = "";
		String actual = _2011_03_11_LongestWord.longestWord2(word);
		assertEquals(expected,actual);
	}
}
