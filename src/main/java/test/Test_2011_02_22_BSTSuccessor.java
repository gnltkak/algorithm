package test;

import static org.junit.Assert.*;
import interview._2011_02_22_BSTSuccessor;

import org.junit.Before;
import org.junit.Test;

import util.BSTNodeWithP;
import util.BSTWithP;

public class Test_2011_02_22_BSTSuccessor {
	private BSTWithP bst1 = new BSTWithP();
	private int[] arr1 = new int[] {100,200,300,250,230,240,50,70,90,25,30,10,5};	
	private BSTWithP bst2 = new BSTWithP();
	private int[] arr2 = new int[] {100};
	
	@Before
	public void setUp()
	{
		for(int i=0;i<arr1.length;i++)
			bst1.add(arr1[i]);
		for(int i=0;i<arr2.length;i++)
			bst2.add(arr2[i]);
	}
	
	@Test
	public void testBSTSuccessor1() {	
		BSTNodeWithP t = bst1.search(100);
		int expected = 200;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor2() {	
		BSTNodeWithP t = bst1.search(200);
		int expected = 230;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor3() {	
		BSTNodeWithP t = bst1.search(300);
		BSTNodeWithP expected = null;
		BSTNodeWithP actual = _2011_02_22_BSTSuccessor.findSuccessor(t);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor4() {	
		BSTNodeWithP t = bst1.search(250);
		int expected = 300;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor5() {	
		BSTNodeWithP t = bst1.search(240);
		int expected = 250;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor6() {	
		BSTNodeWithP t = bst1.search(10);
		int expected = 25;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor7() {	
		BSTNodeWithP t = bst1.search(5);
		int expected = 10;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor8() {	
		BSTNodeWithP t = bst1.search(90);
		int expected = 100;
		int actual = _2011_02_22_BSTSuccessor.findSuccessor(t).value;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBSTSuccessor9() {	
		BSTNodeWithP t = bst2.search(100);
		BSTNodeWithP expected = null;
		BSTNodeWithP actual = _2011_02_22_BSTSuccessor.findSuccessor(t);
		assertEquals(expected,actual);
	}
}
