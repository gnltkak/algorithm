package test;

import static org.junit.Assert.*;
import interview._2011_12_31_HTMLParser;

import org.junit.Test;

public class Test_2011_12_31_HTMLParser {
	@Test
	public void testHTMLParser1() throws Exception {
		String text = "<abc></abc>";
		boolean expected = true;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser2() throws Exception {
		String text = "<abc></abc>";
		boolean expected = true;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser3() throws Exception {
		String text = "<abc>d</abc>";
		boolean expected = true;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser4() throws Exception {
		String text = "<abc><de><f></f></de></abc>";
		boolean expected = true;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	/* isValidHTML2012_11_05() 와 isValidHTML2016_03_04() 에서 다르게 구현하여 주석처리함 
	@Test
	public void testHTMLParser6() throws Exception {
		String text = "abcd<a>ee</a>";
		boolean expected = true;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	*/
	
	@Test
	public void testHTMLParser7() throws Exception {
		String text = "<>";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser8() throws Exception {
		String text = "</>";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser9() throws Exception {
		String text = "<></>";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser10() throws Exception {
		String text = "<>a";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser11() throws Exception {
		String text = "</>a";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser12() throws Exception {
		String text = "<<<ab";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser13() throws Exception {
		String text = ">>d";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser14() throws Exception {
		String text = "<abc";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser15() throws Exception {
		String text = "<abc<d";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser16() throws Exception {
		String text = "a>b<";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser17() throws Exception {
		String text = "/";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser18() throws Exception {
		String text = "<ab/d>";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser19() throws Exception {
		String text = "</ab/d>";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser20() throws Exception {
		String text = "<";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testHTMLParser21() throws Exception {
		String text = ">";
		boolean expected = false;
		boolean actual = _2011_12_31_HTMLParser.isValidHTML(text);
		assertEquals(expected, actual);
	}
}
