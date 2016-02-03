package test;

import static org.junit.Assert.*;
import interview._2011_02_08_TreeList;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import util.BST;
import util.BSTNode;

public class Test_2011_02_08_TreeList {
	@Test
	public void testTreeList() throws Exception {		
		BST bst = new BST();
		bst.add(5);
		bst.add(1);
		bst.add(7);
		bst.add(2);
		bst.add(9);
		
		ArrayList<LinkedList<BSTNode>> result = _2011_02_08_TreeList.getAllList(bst.root);
		StringBuffer sb = new StringBuffer();
		for(LinkedList<BSTNode> list : result)
		{
			for(BSTNode node : list)
			{
				sb.append(node.value+"->");
			}
			sb.append("\n");
		}
		
		String expected = "5->\n1->7->\n2->9->\n";
		String actual = sb.toString();
		assertEquals(expected,actual);
	}
}
