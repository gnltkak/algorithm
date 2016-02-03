package test;

import static org.junit.Assert.*;
import interview._2011_02_28_MyQueue;

import org.junit.Test;

public class Test_2011_02_28_MyQueue {
	@Test
	public void testMyQueue1() {
		_2011_02_28_MyQueue queue = new _2011_02_28_MyQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		assertEquals(30,queue.dequeue());
	}
	
	@Test
	public void testMyQueue2() {
		_2011_02_28_MyQueue queue = new _2011_02_28_MyQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);		
		
		assertEquals(10,queue.dequeue());
		assertEquals(20,queue.dequeue());
		assertEquals(30,queue.dequeue());
		queue.enqueue(40);
		assertEquals(40,queue.dequeue());
	}
}
