package interview;

import java.util.ArrayList;
import java.util.Stack;

import util.BSTNode;

/*
 * binary tree의 두 node가 주어졌을 때, 두 node의 공통 조상을 find.
 * 자료구조에 추가적인 node를 삽입할 수 없다. 그리고 BST가 아님에 유의하라.
 * 사용한 가정 : binary tree의 모든 원소들이 distinct 하다.
 */
public class _2011_02_22_CommonAncestor {
	public static BSTNode commonAncestor(BSTNode root,BSTNode n1,BSTNode n2) {		
		if(n1==root || n2==root)
			return null;
		
		ArrayList<BSTNode> path1 = findPath(root,n1);		
		ArrayList<BSTNode> path2 = findPath(root,n2);			
		
		return firstIntersection(path1,path2);
	}
	
	//root~n 까지의 path를 찾는다. (path에 n은 포함되지 않는다)
	//가정 : n은 tree 안에 반드시 존재한다.
	private static ArrayList<BSTNode> findPath(BSTNode root, BSTNode n) {
		Stack<BSTNode> pathSt = new Stack<BSTNode>();
		doFindPath(root,n,pathSt);
		
		ArrayList<BSTNode> path = new ArrayList<BSTNode>();
		while(!pathSt.empty())
			path.add(pathSt.pop());
		
		//reverse
		for(int i=0;i<path.size()/2;i++)
		{
			BSTNode t = path.get(i);
			path.set(i,path.get(path.size()-1-i));
			path.set(path.size()-1-i, t);
		}		
		
		return path;
	}	
		
	private static boolean doFindPath(BSTNode root, BSTNode n,Stack<BSTNode> pathSt) {
		if(root==n)
			return true;
			
		pathSt.push(root);
		
		boolean finded = false;
		if(root.left!=null)
			finded = doFindPath(root.left,n,pathSt);
		if(!finded && root.right!=null)
			finded = doFindPath(root.right,n,pathSt);
		
		if(finded)
			return true;
		
		pathSt.pop();
		return false;
	}		
	
	private static BSTNode firstIntersection(ArrayList<BSTNode> path1,ArrayList<BSTNode> path2) {	
		int findSize = (int)Math.min(path1.size(), path2.size());		
		
		for(int i=0;i<findSize;i++)
		{
			BSTNode n1 = path1.get(i);
			BSTNode n2 = path2.get(i);
			if(n1!=n2)
				return path1.get(i-1);		
		}		
		
		return path1.get(findSize-1); 
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	public static BSTNode commonAncestor2(BSTNode root, BSTNode n1,BSTNode n2) {
		if(n1==root || n2==root)
			return null;
		return doCommonAncestor2(root,null,n1,n2);
	}

	private static BSTNode doCommonAncestor2(BSTNode root, BSTNode p,BSTNode n1, BSTNode n2) {
		if(n1==root || n2==root)
			return p;
		
		int coverLeft = coverCnt(root.left,n1,n2);
		if(coverLeft==2)
			return doCommonAncestor2(root.left,root,n1,n2);
		if(coverLeft==1)
			return root;
		return doCommonAncestor2(root.right,root,n1,n2);		
	}

	private static int coverCnt(BSTNode root, BSTNode n1, BSTNode n2) {
		if(root==null)
			return 0;
		
		int cnt=0;
		if(root==n1 || root==n2)
			cnt++;
		cnt += coverCnt(root.left,n1,n2);
		if(cnt==2)
			return cnt;
		
		cnt += coverCnt(root.right,n1,n2);
		return cnt;
	}
}

/*
 * 1.O(n) : 추가의 자료구조를 사용하는 솔루션
 * 두 노드 n1,n2로 가는 path를 찾고 path 상의 최초의 공통 노드를 찾으면 된다.
 * (잘 가다가[?] 어느 시점에서 갈라지는지를 보면 된다)
 * 성능 : O(n) (최악의 경우 path를 찾을 때 모든 노드를 다 살펴봐야 한다.)
 * boundary case에 유의하자. 
 * 
 * 2.O(n^2) : 추가의 자료구조를 사용하지 않는 솔루션
 * BST를 생각해보자.
 * 경우는 다음의 4 가지이다.
 * root,n1,n2 가 있을 때 
 * 1) n1,n2 < root => recursive 하게 root.left에 대해 call
 * 2) n1,n2 > root => recursive 하게 root.right에 대해 call
 * 3) n1 < root < n2 또는 n2 < root < n1 => root가 답
 * 4) n1==root 또는 n2==root => root.parent가 답 ( 예외처리 : root가 tree의 root이면 답은 null )
 * 
 * BST라면 위 4개중 어떤 경우인지 판단하는데 상수시간이 소요되므로
 * 최악의 경우(일자형 트리) O(n)이 된다.
 * 
 * 그러나 binary tree 이므로 상수시간에 경우를 판단할 수 없다.
 * 결국 traverse를 해서 n1,n2가 root.left 또는 root.right에 소속된지를 밝혀내야 한다.
 * traverse 는 O(n)이 소요되므로 최악의 경우 n + n-1 + n-2 ... = O(n^2) 이 된다.
 * 
 * traverse를 보다 효율적으로 하려면 단지 소속여부만 체크하는 것이 아니라
 * root.left 또는 root.right에 n1,n2 들어있는 총 횟수(최대값은 당연히 2)를 체크하면 된다.
 * 그러면 DFS를 한번만 하면서 체크할 수 있다.
 * 그렇다고 해도 점근적 성능에는 영향을 미치지 않는다.
 */
