package test;

import static org.junit.Assert.*;
import interview._2011_02_26_ListLoopStart;

import org.junit.Test;

import util.MyLinkedList;
import util.MyLinkedListNode;

public class Test_2011_02_26_ListLoopStart {
	/*
	@Test
	public void testListLoopStart1() {
		MyLinkedList list = new MyLinkedList();
		list.enqueue(0);
		list.enqueue(1);
		list.enqueue(2);
		
		MyLinkedListNode actual = _2011_02_26_ListLoopStart.listLoopStart(list);
		MyLinkedListNode expected = null;
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testListLoopStart2() {
		MyLinkedList list = new MyLinkedList();		
		
		MyLinkedListNode actual = _2011_02_26_ListLoopStart.listLoopStart(list);
		MyLinkedListNode expected = null;
		
		assertEquals(expected,actual);
	}
	*/
	
	@Test
	public void testListLoopStart3() {
		MyLinkedList list = new MyLinkedList();		
		list.enqueue(0);
		list.enqueue(1);
		list.enqueue(2);
		
		MyLinkedListNode n2 = list.getNode(2);
		MyLinkedListNode n0 = list.getNode(0);
		n2.next = n0;
		
		MyLinkedListNode actual = _2011_02_26_ListLoopStart.listLoopStart(list);
		MyLinkedListNode expected = n0;
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testListLoopStart4() {
		MyLinkedList list = new MyLinkedList();		
		list.enqueue(0);
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.enqueue(5);
		list.enqueue(6);
		list.enqueue(7);
		
		MyLinkedListNode n7 = list.getNode(7);
		MyLinkedListNode n2 = list.getNode(2);
		n7.next = n2;
		
		MyLinkedListNode actual = _2011_02_26_ListLoopStart.listLoopStart(list);
		MyLinkedListNode expected = n2;
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testListLoopStart5() {
		MyLinkedList list = new MyLinkedList();		
		list.enqueue(0);
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.enqueue(5);
		list.enqueue(6);
		list.enqueue(7);
		
		MyLinkedListNode n7 = list.getNode(7);
		MyLinkedListNode n6 = list.getNode(6);
		n7.next = n6;
		
		MyLinkedListNode actual = _2011_02_26_ListLoopStart.listLoopStart(list);
		MyLinkedListNode expected = n6;
		
		assertEquals(expected,actual);
	}
}
