package test;

import static org.junit.Assert.*;
import interview._2011_01_18_Prime;

import org.junit.Test;

import util.Util;

public class Test_2011_01_18_Prime {
	@Test
	public void testPrime1() {
		String delim = "\n";
		
		String actual = Util.arrayToString(_2011_01_18_Prime.primes(10),delim);
		String expected = Util.arrayToString(new int[] {2,3,5,7}, delim);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPrime2() {
		String delim = "\n";
		
		String actual = Util.arrayToString(_2011_01_18_Prime.primes(20),delim);
		String expected = Util.arrayToString(new int[] {2,3,5,7,11,13,17,19}, delim);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPrime3() {
		String delim = "\n";
		
		String actual = Util.arrayToString(_2011_01_18_Prime.primes(50),delim);
		String expected = Util.arrayToString(new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47}, delim);
		
		assertEquals(expected, actual);
	}
}
