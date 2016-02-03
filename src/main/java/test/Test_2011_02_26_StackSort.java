package test;

import static org.junit.Assert.*;

import interview._2011_02_26_StackSort;

import java.util.Stack;

import org.junit.Test;

import util.Util;

public class Test_2011_02_26_StackSort {
	@Test
	public void testStackSort1() {
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		st.push(1);
		st.push(2);
		st.push(3);
		
		st = _2011_02_26_StackSort.stackSort(st);
		
		Integer[] arr = new Integer[st.size()];		
		st.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "0,1,2,3";
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testStackSort2() {
		Stack<Integer> st = new Stack<Integer>();
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		
		st = _2011_02_26_StackSort.stackSort(st);
		
		Integer[] arr = new Integer[st.size()];		
		st.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "1,2,3,4";
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testStackSort3() {
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		st.push(2);
		st.push(1);
		st.push(3);
		
		st = _2011_02_26_StackSort.stackSort(st);
		
		Integer[] arr = new Integer[st.size()];		
		st.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "0,1,2,3";
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testStackSort4() {
		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		st.push(2);
		st.push(0);
		st.push(3);
		
		st = _2011_02_26_StackSort.stackSort(st);
		
		Integer[] arr = new Integer[st.size()];		
		st.toArray(arr);
		String actual = Util.arrayToString(Util.integerArrToIntArr(arr),",");
		String expected = "0,0,2,3";
		
		assertEquals(expected,actual);
	}
}
