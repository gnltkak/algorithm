package interview;

import java.util.ArrayList;
import java.util.LinkedList;

import util.BSTNode;

/*
 * binary search tree에서 각 depth 에 있는 노드들을 linked list로 만들어 리턴하는 함수를 작성하라.
 */
public class _2011_02_08_TreeList {
	public static ArrayList<LinkedList<BSTNode>> getAllList(BSTNode root) {
		ArrayList<LinkedList<BSTNode>> result = new ArrayList<LinkedList<BSTNode>>();
		doGetAllList(root,0,result);
		return result;
	}

	private static void doGetAllList(BSTNode root, int depth,ArrayList<LinkedList<BSTNode>> result) {
		if(root==null)
			return;
		
		if(depth>=result.size())
			result.add(new LinkedList<BSTNode>());
		result.get(depth).add(root);
		
		doGetAllList(root.left,depth+1,result);
		doGetAllList(root.right,depth+1,result);
	}
}

/*
 * pre order 로 traverse 하면 된다. 
 */
