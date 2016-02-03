package test;

import static org.junit.Assert.*;
import interview._2011_02_23_TreeSumPath;

import org.junit.Before;
import org.junit.Test;

import util.BST;

public class Test_2011_02_23_TreeSumPath {
	private BST bst = new BST();
	private int[] arr = new int[] {10,5,20,15,25,3,1,6,8,7,2,40};
	
	@Before
	public void setUp() {
		for(int i=0;i<arr.length;i++)
			bst.add(arr[i]);
	}
	
	@Test
	public void testTreeSumPath1() {
		String expected = "";
		String actual = _2011_02_23_TreeSumPath.printSumPath(bst.root, 100);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath2() {
		String expected = "10 -> 5\n8 -> 7\n15";
		String actual = _2011_02_23_TreeSumPath.printSumPath(bst.root, 15);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath3() {
		String expected = "10";
		String actual = _2011_02_23_TreeSumPath.printSumPath(bst.root, 10);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath4() {
		String expected = "3\n1 -> 2";
		String actual = _2011_02_23_TreeSumPath.printSumPath(bst.root, 3);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath5() {
		String expected = "6 -> 8";
		String actual = _2011_02_23_TreeSumPath.printSumPath(bst.root, 14);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath6() {
		String expected = "";
		String actual = _2011_02_23_TreeSumPath.printSumPath(bst.root, 100);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath7() {
		String expected = "10 -> 5\n8 -> 7\n15";
		String actual = _2011_02_23_TreeSumPath.printSumPath2(bst.root, 15);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath8() {
		String expected = "10";
		String actual = _2011_02_23_TreeSumPath.printSumPath2(bst.root, 10);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath9() {
		String expected = "3\n1 -> 2";
		String actual = _2011_02_23_TreeSumPath.printSumPath2(bst.root, 3);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testTreeSumPath10() {
		String expected = "6 -> 8";
		String actual = _2011_02_23_TreeSumPath.printSumPath2(bst.root, 14);
		assertEquals(expected,actual);
	}
}
