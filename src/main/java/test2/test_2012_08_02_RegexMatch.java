package test2;

import static org.junit.Assert.*;
import interview2._2012_08_02_RegexMatch;

import org.junit.Test;

public class test_2012_08_02_RegexMatch {
	 @Test
     public void test1() throws Exception {
		String s = "abc";
		String r = "abc";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test2() throws Exception {
		String s = "a9b";
		String r = "a.b";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test3() throws Exception {
		String s = "abdd";
		String r = ".b..";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test4() throws Exception {
		String s = "b";
		String r = "a*b";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test5() throws Exception {
		String s = "ab";
		String r = "a*b";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test6() throws Exception {
		String s = "aaab";
		String r = "a*b";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test7() throws Exception {
		String s = "aaa";
		String r = "a*b";
		boolean expected = false;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test8() throws Exception {
		String s = "a";
		String r = "a.*";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test9() throws Exception {
		String s = "b";
		String r = "a.*";
		boolean expected = false;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test10() throws Exception {
		String s = "abc";
		String r = "a.*b.*c";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test11() throws Exception {
		String s = "accc";
		String r = "a.*b.*c";
		boolean expected = false;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test12() throws Exception {
		String s = "adbc";
		String r = "a.*b.*c";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test13() throws Exception {
		String s = "a";
		String r = "a";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
	 
	 @Test
     public void test14() throws Exception {
		String s = "aaa";
		String r = "a*aa";
		boolean expected = true;
		boolean actual = _2012_08_02_RegexMatch.match(s, r);
		assertEquals(expected, actual);
     }
}
