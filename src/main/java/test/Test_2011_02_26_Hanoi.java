package test;

import static org.junit.Assert.*;

import java.util.Stack;

import interview._2011_02_26_Hanoi;

import org.junit.Test;

import util.Util;

public class Test_2011_02_26_Hanoi {
	@Test
	public void testHanoi0() {
		Stack<Integer> s = new Stack<Integer>();		
		s.push(1);		
		
		Stack<Integer> e = new Stack<Integer>();
		_2011_02_26_Hanoi.hanoiTower(s, e);
		
		Integer[] arr = new Integer[e.size()];		
		e.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "1";
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testHanoi1() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(1);		
		
		Stack<Integer> e = new Stack<Integer>();
		_2011_02_26_Hanoi.hanoiTower(s, e);
		
		Integer[] arr = new Integer[e.size()];		
		e.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "2,1";
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testHanoi2() {
		Stack<Integer> s = new Stack<Integer>();			
		s.push(3);
		s.push(2);
		s.push(1);		
		
		Stack<Integer> e = new Stack<Integer>();
		_2011_02_26_Hanoi.hanoiTower(s, e);
		
		Integer[] arr = new Integer[e.size()];		
		e.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "3,2,1";
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testHanoi3() {
		Stack<Integer> s = new Stack<Integer>();		
		s.push(4);	
		s.push(3);
		s.push(2);
		s.push(1);		
		
		Stack<Integer> e = new Stack<Integer>();
		_2011_02_26_Hanoi.hanoiTower(s, e);
		
		Integer[] arr = new Integer[e.size()];		
		e.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "4,3,2,1";
		
		assertEquals(expected,actual);
	}
}
