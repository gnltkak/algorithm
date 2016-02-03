package interview;

/*
 * input : 두개의 binary tree(BST 아님) t1,t2
 * find : t2가 t1의 sub tree 인지 알아내기.
 */
public class _2011_02_04_SubTree {
	//t2가 t1의 substree인지를 검사
	public static boolean subTree(TreeNode t1,TreeNode t2) {
		if(t2==null) //empty tree는 모든 tree의 subtree이다.
			return true;
		if(t1==null) // t1은 null, t2는 null이 아닌 경우
			return false;
		
		//preorder 로 tree를 traverse
		return match(t1,t2) || subTree(t1.left,t2) || subTree(t1.right,t2);		
	}

	//두 tree가 같은지 검사
	private static boolean match(TreeNode t1, TreeNode t2) {
		if(t1==null && t2==null)
			return true;
		if(t1==null || t2==null )
			return false;
		if(t1.data != t2.data)
			return false;
		
		return match(t1.left,t2.left) && match(t1.right,t2.right);
	}
}

class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
}


/* n : t1의 size, m : t2의 size
 * 
 * BST라면 이렇게 될 것이다. ( 모든 원소는 distinct 하다고 가정 )
 * t2의 root 를 t1에서 찾는다. O( log n )
 * t1에 없으면 답은 false
 * t1에 있으면 그 노드를 root로 하는 subtree와 t2를 비교한다. O( m )
 * 따라서 성능은 O (log n + m ) 이 된다.
 * 
 * BST가 아니라 binary tree 이므로 원소가 distinct 하지 않다고 가정한다.
 * BST와의 차이점은 단지 한번 찾고 마느냐 계속 찾느냐 이다.
 * t1을 pre-order 로 traverse 하면서 t2의 root와 일치하는 원소가 나오면 둘을 비교한다.
 * t2의 root가 t1에 나오는 횟수를 k라 하면
 * O ( n + km ) 이 된다.
 * worst case라면 k=n 일 것이므로 O (n + nm ) = O ( nm ) 이 될 것이다.
 * 
 * 인자로 null이 넘어오는 갖가지 경우에 반드시 주의하기 바란다.
 */ 