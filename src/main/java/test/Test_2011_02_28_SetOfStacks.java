package test;

import static org.junit.Assert.*;
import interview._2011_02_28_SetOfStacks;

import org.junit.Before;
import org.junit.Test;

public class Test_2011_02_28_SetOfStacks {
	private _2011_02_28_SetOfStacks sss;	
	
	@Test
	public void testSetOfStacks1() {
		sss = new _2011_02_28_SetOfStacks(1);
		sss.push(0);
		sss.push(1);
		sss.push(2);
		sss.push(3);
		sss.push(4);
		
		assertEquals(4,sss.pop());
		assertEquals(3,sss.pop());
		sss.push(10);
		assertEquals(10,sss.pop());
		assertEquals(2,sss.pop());
		assertEquals(1,sss.pop());
		assertEquals(0,sss.pop());
	}
	
	@Test
	public void testSetOfStacks2() {
		sss = new _2011_02_28_SetOfStacks(2);
		sss.push(0);
		sss.push(1);
		sss.push(2);
		sss.push(3);
		sss.push(4);
		
		assertEquals(4,sss.pop());
		assertEquals(3,sss.pop());
		sss.push(10);
		assertEquals(10,sss.pop());
		assertEquals(2,sss.pop());
		assertEquals(1,sss.pop());
		assertEquals(0,sss.pop());
	}
	
	@Test
	public void testSetOfStacks3() {
		sss = new _2011_02_28_SetOfStacks(3);
		sss.push(0);
		sss.push(1);
		sss.push(2);
		sss.push(3);
		sss.push(4);
		
		assertEquals(4,sss.pop());
		assertEquals(3,sss.pop());
		sss.push(10);
		assertEquals(10,sss.pop());
		assertEquals(2,sss.pop());
		assertEquals(1,sss.pop());
		assertEquals(0,sss.pop());
	}
	
	@Test
	public void testSetOfStacks4() {
		sss = new _2011_02_28_SetOfStacks(10);
		sss.push(0);
		sss.push(1);
		sss.push(2);
		sss.push(3);
		sss.push(4);
		
		assertEquals(4,sss.pop());
		assertEquals(3,sss.pop());
		sss.push(10);
		assertEquals(10,sss.pop());
		assertEquals(2,sss.pop());
		assertEquals(1,sss.pop());
		assertEquals(0,sss.pop());
	}
	
	@Test
	public void testSetOfStacks5() {
		sss = new _2011_02_28_SetOfStacks(1);
		sss.push(10);
		sss.push(20);
		sss.push(30);
		sss.push(40);
		sss.push(50);
		
		assertEquals(10,sss.popAt(0));
		assertEquals(30,sss.popAt(1));		
		assertEquals(50,sss.pop());
		assertEquals(40,sss.popAt(1));
		assertEquals(20,sss.popAt(0));
	}
	
	@Test
	public void testSetOfStacks6() {
		sss = new _2011_02_28_SetOfStacks(1);
		sss.push(10);
		sss.push(20);
		sss.push(30);
		sss.push(40);
		sss.push(50);
		
		assertEquals(50,sss.popAt(4));
		assertEquals(40,sss.popAt(3));		
		assertEquals(30,sss.popAt(2));
		assertEquals(20,sss.popAt(1));
		assertEquals(10,sss.popAt(0));
	}
	
	@Test
	public void testSetOfStacks7() {
		sss = new _2011_02_28_SetOfStacks(1);
		sss.push(10);
		sss.push(20);
		sss.push(30);
		sss.push(40);
		sss.push(50);
		
		assertEquals(30,sss.popAt(2));
		assertEquals(40,sss.popAt(2));		
	}
	
	@Test
	public void testSetOfStacks8() {
		sss = new _2011_02_28_SetOfStacks(3);
		sss.push(10);
		sss.push(20);
		sss.push(30);
		sss.push(40);
		sss.push(50);
		sss.push(60);
		sss.push(70);
		sss.push(80);
		sss.push(90);
		sss.push(100);
		
		assertEquals(100,sss.popAt(3));	
		assertEquals(30,sss.popAt(0));	
		assertEquals(70,sss.popAt(1));
		assertEquals(90,sss.popAt(2));	
	}
}
