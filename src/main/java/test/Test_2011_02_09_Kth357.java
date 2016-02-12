package test;

import static org.junit.Assert.*;
import interview._2011_02_09_Kth357;

import org.junit.Test;

public class Test_2011_02_09_Kth357 {
	@Test
	public void testKth357_1() {
		String expected = "1";
		String actual = ""+_2011_02_09_Kth357.kth357(1);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKth357_2() {
		String expected = "3";
		String actual = ""+_2011_02_09_Kth357.kth357(2);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKth357_3() {
		String expected = "5";
		String actual = ""+_2011_02_09_Kth357.kth357(3);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testKth357_4() {
		String expected = ""+_2011_02_09_Kth357.getKthMagicNumber_Ref(500);
		String actual = ""+_2011_02_09_Kth357.kth357(500);
		
		assertEquals(expected,actual);
	}
}