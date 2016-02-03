package interview;

import java.util.ArrayList;
import java.util.Stack;

import util.BSTNode;

/*
 * binary tree의 각 node 에는 int 값이 주어진다.
 * integer k가 주어졌을때 합이 k가 되는 tree 상의 모든 path를 출력하라.
 * (주의 : path는 반드시 root에서 시작할 필요는 없다)
 */
public class _2011_02_23_TreeSumPath {
	private static StringBuffer sb;
	
	public static String printSumPath(BSTNode root,int value) {
		sb = new StringBuffer();
		
		ArrayList<ArrayList<BSTNode>> allPath = new ArrayList<ArrayList<BSTNode>>();
		evalAllPath(root,allPath);
		for(ArrayList<BSTNode> path : allPath)
			doPrintSumPath(path,value);
		
		//중복제거
		StringBuffer result = new StringBuffer();
		String[] path = sb.toString().split("\n");
		
		if(path.length>0)
		{
			result.append(path[0]);
			result.append('\n');
		}	
		
		for(int i=1;i<path.length;i++)
		{			
			boolean dup = false;
			for(int j=i-1;j>=0;j--)
			{				
				dup = (path[i].compareTo(path[j])==0);
				if(dup)
					break;				
			}
			if(!dup)
			{				
				result.append(path[i]);
				if(i!=path.length-1)
					result.append('\n');
			}			
		}
		
		if(result.charAt(result.length()-1)=='\n')
			result.deleteCharAt(result.length()-1);
		
		return result.toString();
	}

	private static void doPrintSumPath(ArrayList<BSTNode> path, int value) {
		//전처리
		int[] sum = new int[path.size()];
		int temp = 0;
		for(int i=0;i<path.size();i++)
		{
			temp += path.get(i).value;
			sum[i] = temp;
		}
		
		for(int i=0;i<path.size();i++)
		{
			for(int j=i;j<path.size();j++)
			{
				int s=0;
				if(i==0)
					s = sum[j];
				else
					s = sum[j]-sum[i-1];
				
				if(s==value)
				{
					for(int k=i;k<=j;k++)
					{
						sb.append(path.get(k).value);						
						if(k!=j)
							sb.append(" -> ");
					}
					sb.append('\n');
				}
			}
		}		
	}

	private static void evalAllPath(BSTNode root,ArrayList<ArrayList<BSTNode>> allPath) {
		Stack<BSTNode> pathSt = new Stack<BSTNode>();
		doEvalAllPath(root,allPath,pathSt);
	}

	private static void doEvalAllPath(BSTNode root,ArrayList<ArrayList<BSTNode>> allPath, Stack<BSTNode> pathSt) {
		if(root==null)
			return;	
		
		pathSt.push(root);
		if(root.left==null && root.right==null) //leaf에 도달
		{			
			ArrayList<BSTNode> path = new ArrayList<BSTNode>();
			for(int i=0;i<pathSt.size();i++)
				path.add(pathSt.get(i));
			
			allPath.add(path);
		}
		
		doEvalAllPath(root.left,allPath,pathSt);
		doEvalAllPath(root.right,allPath,pathSt);
		pathSt.pop();
	}
	
	////////////////////////////////////////////////////////////////
	
	public static String printSumPath2(BSTNode root,int value) {
		sb = new StringBuffer();
		doPrintSumPath2(root,value);
		if(sb.length()>0) //마지막의 \n 제거
			sb.deleteCharAt(sb.length()-1);				
		return sb.toString();
	}

	private static void doPrintSumPath2(BSTNode root, int value) {
		if(root==null)
			return;
		
		Stack<BSTNode> pathSt = new Stack<BSTNode>();
		doDoPrintSumPath2(root,value,pathSt,0);
		
		doPrintSumPath2(root.left,value);
		doPrintSumPath2(root.right,value);
	}

	private static void doDoPrintSumPath2(BSTNode root, int value,Stack<BSTNode> pathSt, int sum) {
		if(root==null)
			return;
		
		pathSt.push(root);
		sum += root.value;
		
		if(sum == value)
		{
			//stack 출력
			for(int i=0;i<pathSt.size();i++)
			{
				sb.append(pathSt.get(i).value);
				if(i!=pathSt.size()-1)
					sb.append(" -> ");
			}
			sb.append('\n');
		}
		
		doDoPrintSumPath2(root.left,value,pathSt,sum);
		doDoPrintSumPath2(root.right,value,pathSt,sum);
		
		sum -= root.value;
		pathSt.pop();
	}
}

/*
 * 1.O(n^2) solution
 * 
 * 모든 path를 어떻게 구할 수 있을까?
 * 시작점도, 끝점도 자유롭다. ( 물론 조상 -자손 관계여야 한다 )
 * root ~ leaf로 이루는 각 path들이 있을 것이다.
 * 이러한 각 path들의 consecutive subsequence를 모두 고려하면 된다.
 * 
 * 1) 우선 root~leaf 로의 모든 path를 구하고
 * 2) 각 path에 대해 consecutive subsequence 를 모두 고려하여 주어진 integer와 같은지를 본다.
 *    ( subsum을 빠르게 구하기 위해 전처리 후 lookup 을 한다 ) 
 * 
 * 일자형 트리의 경우 - O(n^2)
 * 1)의 과정은 O(n)이 된다. DFS에 O(n)이 걸리고, path(유일함) 를 만드는데 O(n)이 걸린다.
 * 2)의 과정은 전처리가 O(n), lookup은 O(n^2)이 걸린다.
 *   path가 단 하나뿐이기 때문이다. ( i~j 의 subsum을 구할때 i,j의 조합이 O(n^2) 개가 된다. 그리고 한번의 lookup은 O(1) 이다 )
 * 
 * 그렇다면 (root~leaf 까지의)path가 여러개가 된다면?
 * path가 가장 많은 경우는 full binary tree이다.
 * path의 개수는 leaf의 개수이므로 logn 개가 된다.( 2^1 + 2^2 + ... + 2^k = n 에서 k가 leaf의 수..)
 * 각 path의 원소의 수도 logn 개이다.
 * 
 * 그러므로 다음과 같이 된다.
 * 1)의 과정은 traverse가 O(n) 이고 한 path를 만드는데 O(logn) 이고(복사해야되니까) path의 수가 logn 개이므로
 * O(n + (logn)^2) = O(n) 이다.
 * 2)의 과정은 path 하나가 전처리가 O(logn), total lookup이 O((logn)^2) 이고 path의 수가 logn 개이므로
 * O((logn)^3) 이 된다.
 * 
 * 고로 성능은 O(n^2)이 된다.
 * 
 * 그런데.. 중복이 문제가 된다. ㅠㅠ 이것때문에 구현이 지저분해졌다.
 * 최종 답이 k개라면 중복제거에는 O(k^2)이... ㅠㅠ
 * 
 * 
 * 2.훨씬 더 아름다운 ..but O(n^4) solution - 중복제거를 할 필요도 없고, 공간사용도 더 적다.
 * 이 경우에도 일자형 트리라면 O(n^2)이 된다. 하지만... 훨씬 아름답다.
 * 사실 tree의 recursive한 구조상 path를 어디에서 시작하는지는 전혀 문제가 되지 않는다.
 * 다시 말해, root에서 시작하는 경우를 일단 생각하고 나머지는 subtree들에 대해 recursive하게 적용하면 된다는 이야기다.
 * 자 그러면 root에서 시작하는 경우를 생각해보자.
 * DFS를 하며 sum을 누적해 나간다. path용 stack에 node 도 누적해 나간다.
 * sum이 주어진 integer 와 같으면 path를 출력한다.
 * 
 * path를 중복 체크하지 않으므로 중복검사가 필요 없다.
 * 그리고 path들을 다 저장해두지 않으므로 공간 사용도 더 적다. 
 * 시간복잡도는...
 * traverse를 한번만 하기 때문에 각각 O(n)이 된다.
 * full binary tree를 고려하여 모든 path마다 몽땅 match 된다고 해도 O( (logn)^2) 이 되므로 결국 O(n) 이다.
 * 
 * 따라서 일자형 트리의 경우 O(n) + O(n-1) + ... + O(1) = O(n^2)이 된다.
 * 
 * 그러나.. 출력에 대해 생각해보면 얘기가 달라진다.
 * 적절한 path를 찾을때마다 출력해줘야 하지 않는가?
 * 일자형 tree이고, 1 -1 1 -1 1 -1 로 늘어서 있고, 주어진 정수가 0 이라면?
 * 한번 traverse 할때마다 출력 오버헤드만 O(n^2) 이다.
 * 즉 n^2 + (n-1)^2 + ... = O(n^4)이 된다.!!!!으악!
 * 
 * 첫번째 솔루션은 path를 구해놓고 시작하기 때문에 이런 문제가 없다.
 */
