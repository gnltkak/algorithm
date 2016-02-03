package interview;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import util.BST;

/*
 * 소인수 분해 했을 때 3,5,7 로만 이루어진 양의 정수중 k번째 작은 수를 구하기.
 */
public class _2011_02_09_Kth357 {
	public static int kth357(int k) {	
		//min heap을 만든다.
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(1);
		BST bst = new BST(); //중복검사를 위한 binary search tree
		bst.add(1);
		
		for(int i=1;i<k;i++)
		{
			int peek = heap.poll();
			if(bst.search(3*peek)==null)
			{
				bst.add(3*peek);
				heap.add(3*peek);
			}
			if(bst.search(5*peek)==null)
			{
				bst.add(5*peek);
				heap.add(5*peek);
			}
			if(bst.search(7*peek)==null)
			{
				bst.add(7*peek);
				heap.add(7*peek);
			}
		}
		
		return heap.peek();		
	}	
	
	public static int getKthMagicNumber_Ref(int k) {
		if(k<=0) return 0;
		int val = 1;
		Queue<Integer> Q3 = new LinkedList<Integer>();
		Queue<Integer> Q5 = new LinkedList<Integer>();
		Queue<Integer> Q7 = new LinkedList<Integer>();
		Q3.add(3);
		Q5.add(5);
		Q7.add(7);
		for(--k;k>0;--k) {
			val = Math.min(Q3.peek().intValue(), 
					Math.min(Q5.peek().intValue(), Q7.peek().intValue()));
			if(val==Q7.peek())
				Q7.remove();
			else
			{
				if(val==Q5.peek())
					Q5.remove();
				else
				{
					Q3.remove();
					Q3.add(val*3);
				}
				Q5.add(val*5);
			}
			Q7.add(val*7);
		}
		return val;
	}
}


/*
 * 1. recursive 한 접근
 * k번째 작은 수가 있을 때 k+1 번째 작은 수를 구하고자 하였다.
 * 더 큰 수를 만들려면 3이나 5나 7을 곱해야 하는데 셋중 하나라면 3을 곱하면 된다.
 * but.. 다양한 경우가 있으니 7/5 를 곱한다거나 25/21 을 곱한다거나..
 * k번째 작은 수에 포함된 3의수,5의수,7의수가 몇인지에 따라 경우가 달라지므로 이 접근은 실패하였다.
 * 
 * 2. heap 쓰기 - 추가 메모리 사용 O(k logk)
 * 특정 성질을 만족하는 k번째 작은 수를 구하는 문제이므로 min heap을 이용할 수 있다.
 * heap에 맨 처음 1을 넣고, 1*3 , 1*5 , 1*7 을 넣는다.
 * heap 에서 poll 하고, poll된 원소 x에 3,5,7을 곱하여 heap에 넣는 것을 반복한다.
 * 주의할 점은 heap 에 들어가는 원소가 중복될 수 있다는 점이다.
 * 예를들어 3이 poll 될때 3*5가 들어가고, 5가 poll 될때 5*3이 들어가서 중복된다.
 * 중복 검사를 위해 bitmap을 사용할 수 있지만 검사해야할 수의 범위가 너무 커서(40억) 메모리를 많이 차지한다.
 * 그러므로 BST를 사용하여 중복 검사를 하였다.
 * 중복 검사에 O(logk), heap 에 insert 하고 poll 하는데에 O(logk) 이므로 
 * 전체 성능은 O(klogk) 가 된다.
 * 
 * 중복검사에 hash table을 사용할 수도 있지만 전체 점근적 성능 개선에는 영향이 없다.
 * 만약 hash table을 사용한다면 size를 3k 로 잡으면 된다.
 * (한번 poll 할때마다 최대 3개씩 들어가니까..)
 * 
 * 3. 책에나온 솔루션 - O(k)
 * 2번 솔루션에서 중복체크를 일일히 하지 않고 넣을때부터 잘 넣도록 하면 어떨까?
 * 그리고 heap을 꼭 써야할까? 
 * 이 솔루션에서는 큐를 3개 사용한다. (Q3,Q5,Q7)
 * 맨 처음 1로 시작한다.
 * 그리고 Q3에 3을, Q5에 5를, Q7에 7을 넣는다.
 * 그리고 아래의 과정을 반복한다.
 * Q3,Q5,Q7 의 peek중 가장 작은것을 택한다. 이것을 x라 하자.
 * 어느 큐에서 선택되었든, 그 큐에서 x를 제거한다.
 * Q3에서 x가 선택되었다면, 3x,5x,7x 를 Q3에 넣는다.
 * Q5에서 x가 선택되었다면, 5x,7x 를 Q5에 넣는다. ( 3x는 Q3에서 선택되었을떄 들어갔으니까..)
 * Q7에서 x가 선택되었다면, 7x 를 Q7에 넣는다.
 * 
 * 위와 같이 함으로써 중복검사가 불필요해진다.
 * 그리고 큐3개를 이용함으로써 min select,insert 가 O(1)에 이루어진다.
 * 따라서 전체 성능은 O(k)가 된다.
 */
