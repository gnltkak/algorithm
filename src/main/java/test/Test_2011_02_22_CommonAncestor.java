package test;

import static org.junit.Assert.*;
import interview._2011_02_22_CommonAncestor;

import org.junit.Before;
import org.junit.Test;

import util.BST;
import util.BSTNode;

public class Test_2011_02_22_CommonAncestor {
	private BST bst1 = new BST();
	private int[] arr1 = new int[] {100,200,300,250,230,240,50,70,90,25,30,10,5};	
	private BST bst2 = new BST();
	private int[] arr2 = new int[] {100,200};
	
	@Before
	public void setUp()
	{
		for(int i=0;i<arr1.length;i++)
			bst1.add(arr1[i]);
		for(int i=0;i<arr2.length;i++)
			bst2.add(arr2[i]);
	}
	
	@Test
	public void testCommonAncestor1() {
		BSTNode n1 = bst2.search(100);
		BSTNode n2 = bst2.search(200);
		BSTNode expected = null;
		BSTNode actual = _2011_02_22_CommonAncestor.commonAncestor(bst2.root,n1, n2);	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor2() {
		BSTNode n1 = bst1.search(50);
		BSTNode n2 = bst1.search(200);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor3() {
		BSTNode n1 = bst1.search(25);
		BSTNode n2 = bst1.search(90);
		int expected = 50;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor4() {		
		BSTNode n1 = bst1.search(5);
		BSTNode n2 = bst1.search(240);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor5() {
		BSTNode n1 = bst1.search(5);
		BSTNode n2 = bst1.search(10);
		int expected = 25;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor6() {
		BSTNode n1 = bst1.search(25);
		BSTNode n2 = bst1.search(70);
		int expected = 50;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor7() {
		BSTNode n1 = bst1.search(30);
		BSTNode n2 = bst1.search(230);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor8() {
		BSTNode n1 = bst1.search(50);
		BSTNode n2 = bst1.search(50);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor9() {
		BSTNode n1 = bst2.search(100);
		BSTNode n2 = bst2.search(200);
		BSTNode expected = null;
		BSTNode actual = _2011_02_22_CommonAncestor.commonAncestor2(bst2.root,n1, n2);	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor10() {
		BSTNode n1 = bst1.search(50);
		BSTNode n2 = bst1.search(200);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor11() {
		BSTNode n1 = bst1.search(25);
		BSTNode n2 = bst1.search(90);
		int expected = 50;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor12() {		
		BSTNode n1 = bst1.search(5);
		BSTNode n2 = bst1.search(240);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor13() {
		BSTNode n1 = bst1.search(5);
		BSTNode n2 = bst1.search(10);
		int expected = 25;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor14() {
		BSTNode n1 = bst1.search(25);
		BSTNode n2 = bst1.search(70);
		int expected = 50;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor15() {
		BSTNode n1 = bst1.search(30);
		BSTNode n2 = bst1.search(230);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCommonAncestor16() {
		BSTNode n1 = bst1.search(50);
		BSTNode n2 = bst1.search(50);
		int expected = 100;
		int actual = _2011_02_22_CommonAncestor.commonAncestor2(bst1.root,n1, n2).value;	
		
		assertEquals(expected,actual);
	}
}
