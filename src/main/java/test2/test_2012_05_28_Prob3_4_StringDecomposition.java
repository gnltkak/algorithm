package test2;

import static org.junit.Assert.*;

import interview2._2012_05_28_Prob3_4_StringDecomposition;

import java.util.HashSet;

import org.junit.Test;

public class test_2012_05_28_Prob3_4_StringDecomposition {
	@Test
	public void testStringDecomposition1() throws Exception {
		String str = "mynameisDavid";
		String[] dictionary = {"my", "name", "is", "David"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "my name is David";
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition2() throws Exception {
		String str = "Davidismyname";
		String[] dictionary = {"my", "name", "is", "David"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "David is my name";
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition3() throws Exception {
		String str = "my";
		String[] dictionary = {"my", "name", "is", "David"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "my";
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition4() throws Exception {
		String str = "David";
		String[] dictionary = {"my", "name", "is", "David"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "David";
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition5() throws Exception {
		String str = "abcdisDavid";
		String[] dictionary = {"my", "name", "is", "David"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = null;
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition6() throws Exception {
		String str = "Davidisabcd";
		String[] dictionary = {"my", "name", "is", "David"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = null;
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition7() throws Exception {
		String str = "abcd";
		String[] dictionary = {"ab", "cd", "abcd", "ef"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "ab cd"; // 또는 abcd도 무방
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition8() throws Exception {
		String str = "abefabcd";
		String[] dictionary = {"ab", "cd", "abcd", "ef"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "ab ef ab cd"; // 또는 ab ef abcd도 무방
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition9() throws Exception {
		String str = "efefefef";
		String[] dictionary = {"ab", "cd", "abcd", "ef"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = "ef ef ef ef"; // 또는 ab ef abcd도 무방
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStringDecomposition10() throws Exception {
		String str = "abcdgg";
		String[] dictionary = {"ab", "cd", "abcd", "ef"};
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < dictionary.length; ++i)
			dic.add(dictionary[i]);
		String expected = null; // 또는 ab ef abcd도 무방
		String actual = _2012_05_28_Prob3_4_StringDecomposition.decomposition(str, dic);
		assertEquals(expected, actual);
	}
}
