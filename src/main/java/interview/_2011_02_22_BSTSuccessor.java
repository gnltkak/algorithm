package interview;

import util.BSTNodeWithP;

/*
 * binary search tree에서 주어진 node의 in-order successor 를 찾는 문제
 * 단, 각 node는 parent를 알고 있다고 가정한다.
 */
public class _2011_02_22_BSTSuccessor {
	public static BSTNodeWithP findSuccessor(BSTNodeWithP t) {
		if(t==null)
			return null;
		
		if(t.right!=null) //t에게 right child가 있는 경우
		{
			BSTNodeWithP n = t.right;
			while(n.left!=null)
				n = n.left;
			return n;
		}
		
		//t에게 right child가 없는 경우
		BSTNodeWithP p = t.parent;
		if(p==null)
			return null;
				
		if(t==p.left) //t가 parent의 left child인 경우
			return p;
		
		while(p!=null && t==p.right) //t가 parent의 right child인 경우
		{
			t=p;
			p=p.parent;
		}
		return p;
	}
}

/*
 * left,right child를 가진 경우, 자신이 parent의 left child인지 right child인지로 구분하여 생각한다.
 * 중간중간 null값이 되는 경우를 특히 유의해야 한다. 
 * 성능 : O(n) ( tree가 일자형으로 늘어선 경우 )
 */