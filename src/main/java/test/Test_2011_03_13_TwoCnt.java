package test;

import static org.junit.Assert.*;

import java.util.Random;

import interview._2011_03_13_TwoCnt;

import org.junit.Test;

public class Test_2011_03_13_TwoCnt {
	@Test
	public void testTwoCnt1() {
		int n = 0;
		int expected = 0;
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTwoCnt2() {
		int n = 11;
		int expected = 1;
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTwoCnt3() {
		int n = 12;
		int expected = 2;
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTwoCnt4() {
		int n = 25;
		int expected = 9;
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTwoCnt5() {		
		int n = 234;
		int expected = _2011_03_13_TwoCnt.twoCntNlogN(n);
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testTwoCnt6() {
		Random rand = new Random();
		int n = rand.nextInt(Integer.MAX_VALUE/100);
		int expected = _2011_03_13_TwoCnt.twoCntNlogN(n);
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTwoCnt7() {		
		int n = 2;
		int expected = _2011_03_13_TwoCnt.twoCntNlogN(n);
		int actual = _2011_03_13_TwoCnt.twoCnt(n);
		assertEquals(expected,actual);		
	}
}
