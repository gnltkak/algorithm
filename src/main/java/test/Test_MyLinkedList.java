package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.MyLinkedList;

public class Test_MyLinkedList {
	private MyLinkedList list;
	
	@Before
	public void setUp() {
		list = new MyLinkedList();
	}
	
	@Test
	public void testMyLinkedList1() {
		boolean expected = true;
		boolean actual = list.isEmpty();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMyLinkedList2() {
		list.enqueue(0);
		
		boolean expected = false;
		boolean actual = list.isEmpty();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMyLinkedList3() {
		list.enqueue(0);
		list.enqueue(2);
		
		String expected = "0 -> 2";
		String actual = list.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMyLinkedList4() {
		list.enqueue(0);
		list.enqueue(3);
		list.enqueue(4);
		int v1 = list.dequeue();
		int v2 = list.dequeue();
		
		assertEquals(0,v1);
		assertEquals(3,v2);
		
		String expected = "4";
		String actual = list.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMyLinkedList5() {
		list.enqueue(0);
		list.enqueue(3);		
		int v1 = list.dequeue();
		int v2 = list.dequeue();
		
		assertEquals(0,v1);
		assertEquals(3,v2);
		
		String expected = "";
		String actual = list.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testMyLinkedList6() {
		list.enqueue(0);			
		list.dequeue();
		try
		{
			list.dequeue();
		}
		catch(RuntimeException re)
		{
			assertEquals(true,true);
			return;
		}
		
		assertEquals(true,false);
	}
	
	@Test
	public void testMyLinkedList7() {
		list.enqueue(0);			
		list.enqueue(10);
		list.enqueue(20);
		list.enqueue(5);
		
		list.delete(10);
		assertEquals("0 -> 20 -> 5",list.toString());
		list.delete(0);
		assertEquals("20 -> 5",list.toString());
		list.delete(5);
		assertEquals("20",list.toString());
		list.delete(20);
		assertEquals(true,list.isEmpty());
	}
	
	@Test
	public void testMyLinkedList8() {
		list.enqueue(0);			
		list.enqueue(10);
		list.enqueue(20);
		list.enqueue(5);
		
		try
		{
			list.delete(12);
		}
		catch(RuntimeException re)
		{
			assertEquals(true,true);
			return;
		}		
		assertEquals(true,false);
	}
	
	@Test
	public void testMyLinkedList9() {
		try
		{
			list.add(-1, 10);
		}
		catch(RuntimeException re)
		{
			assertEquals(true,true);
			return;
		}		
		assertEquals(true,false);		
	}
	
	@Test
	public void testMyLinkedList10() {
		list.enqueue(100);
		try
		{
			list.add(-1, 10);
		}
		catch(RuntimeException re)
		{
			assertEquals(true,true);
			return;
		}		
		assertEquals(true,false);		
	}
	
	@Test
	public void testMyLinkedList11() {
		list.enqueue(100);		
		list.add(100, 200);
		list.add(200, 300);
		list.add(100, 150);
		list.add(150, 175);
		assertEquals("100 -> 150 -> 175 -> 200 -> 300",list.toString());	
	}
}
