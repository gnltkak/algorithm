package test;

import static org.junit.Assert.*;
import interview._2011_02_24_ListSum;

import org.junit.Before;
import org.junit.Test;

import util.MyLinkedList;

public class Test_2011_02_24_ListSum {
	private MyLinkedList l1_0 = new MyLinkedList();
	private MyLinkedList l2_0 = new MyLinkedList();
	private int[] arr1_0 = new int[] {5,4,3};
	private int[] arr2_0 = new int[] {5,3,7,1};
	
	private MyLinkedList l1_1 = new MyLinkedList();
	private MyLinkedList l2_1 = new MyLinkedList();
	private int[] arr1_1 = new int[] {3,1,5};
	private int[] arr2_1 = new int[] {5,9,2};
	
	private MyLinkedList l1_2 = new MyLinkedList();
	private MyLinkedList l2_2 = new MyLinkedList();
	private int[] arr1_2 = new int[] {5,4,3};
	private int[] arr2_2 = new int[] {};
	
	private MyLinkedList l1_3 = new MyLinkedList();
	private MyLinkedList l2_3 = new MyLinkedList();
	private int[] arr1_3 = new int[] {9,9,9,9,9};
	private int[] arr2_3 = new int[] {1};
	
	@Before
	public void setUp() {
		for(int i=0;i<arr1_0.length;i++)
			l1_0.enqueue(arr1_0[i]);
		for(int i=0;i<arr2_0.length;i++)
			l2_0.enqueue(arr2_0[i]);
		for(int i=0;i<arr1_1.length;i++)
			l1_1.enqueue(arr1_1[i]);
		for(int i=0;i<arr2_1.length;i++)
			l2_1.enqueue(arr2_1[i]);
		for(int i=0;i<arr1_2.length;i++)
			l1_2.enqueue(arr1_2[i]);
		for(int i=0;i<arr2_2.length;i++)
			l2_2.enqueue(arr2_2[i]);
		for(int i=0;i<arr1_3.length;i++)
			l1_3.enqueue(arr1_3[i]);
		for(int i=0;i<arr2_3.length;i++)
			l2_3.enqueue(arr2_3[i]);
	}
	
	@Test
	public void testListSum1() {
		MyLinkedList result = _2011_02_24_ListSum.listSum(l1_0, l2_0);
		String expected = "0 -> 8 -> 0 -> 2";
		String actual = result.toString();
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testListSum2() {
		MyLinkedList result = _2011_02_24_ListSum.listSum(l1_1, l2_1);
		String expected = "8 -> 0 -> 8";
		String actual = result.toString();
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testListSum3() {
		MyLinkedList result = _2011_02_24_ListSum.listSum(l1_2, l2_2);
		String expected = "5 -> 4 -> 3";
		String actual = result.toString();
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testListSum4() {
		MyLinkedList result = _2011_02_24_ListSum.listSum(l1_3, l2_3);
		String expected = "0 -> 0 -> 0 -> 0 -> 0 -> 1";
		String actual = result.toString();
		
		assertEquals(expected,actual);
	}
}
