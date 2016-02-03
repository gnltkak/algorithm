package test;

import static org.junit.Assert.*;
import interview._2011_05_16_RemoveDupInLinkedList;

import org.junit.Test;

import util.MyLinkedList;

public class Test_2011_05_16_RemoveDupInLinkedList {
	@Test
	public void testRemoveDupInLinkedList1() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		String expected = "1";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList2() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(1);
		String expected = "1";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList3() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(1);
		list.enqueue(1);
		String expected = "1";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList4() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(2);		
		String expected = "1 -> 2";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList5() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(2);	
		list.enqueue(1);
		list.enqueue(2);
		String expected = "1 -> 2";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList6() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(1);	
		list.enqueue(2);		
		String expected = "1 -> 2";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList7() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(2);	
		list.enqueue(2);	
		list.enqueue(1);	
		String expected = "1 -> 2";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testRemoveDupInLinkedList8() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(1);
		list.enqueue(2);	
		list.enqueue(2);
			
		String expected = "1 -> 2";
		_2011_05_16_RemoveDupInLinkedList.removeDupInLinkedList(list.getFirstNode());
		String actual =  list.toString();
		assertEquals(expected, actual);		
	}
}
