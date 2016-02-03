package interview;

import util.MyLinkedList;
import util.MyLinkedListNode;

/*
 * circular linked list에서 loop의 시작점을 찾는 문제이다.
 */
public class _2011_02_26_ListLoopStart {
	/*
	public static MyLinkedListNode listLoopStart(MyLinkedList list) {
		MyLinkedListNode n1 = list.getFirstNode();
		MyLinkedListNode n2 = list.getFirstNode();
		
		boolean first = true;
		while(n1!=null && n2!=null)
		{
			if(!first && n1==n2)
			{
				n1 = list.getFirstNode();
				while(n1!=n2)
				{
					n1 = n1.next;
					n2 = n2.next;					
				}
				return n1;
			}
			
			n1 = n1.next;
			n2 = n2.next;
			if(n2==null)
				break;
			n2 = n2.next;
			first = false;
		}
		return null;
	}
	*/
	
	///////////////////////////////////////////////////
	//assumption : input 으로 주어지는 linked list는 circular linked list임.
	public static MyLinkedListNode listLoopStart(MyLinkedList list) {
		MyLinkedListNode n1 = list.getFirstNode().next;
		MyLinkedListNode n2 = list.getFirstNode().next.next;		
		
		while(n1!=n2)
		{
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		n2 = list.getFirstNode();
		while(n1!=n2)
		{
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n1;
	}
}

/*
 * cracking the coding interview (fourth edition) p50 2.5 번 문제이다.
 * 그림을 보면 이해가 쉬우니 p109의 그림을 보도록 하자.
 * 
 * circular 이기 때문에 한번에 1씩 움직이는 finger n1 과 한번에 2씩 움직이는 finger n2를 사용하면
 * n1과 n2가 언젠가는 반드시 만나게 된다. ( 이를 이용해 circular 여부를 판별할 수 있다 )
 * 그렇다면 n1,n2는 어디서 만나게 될까?
 * 우선 이보다 더 단순한 문제를 살펴보자.
 * 속도1, 속도2 인 두 선수가 길이 n 인 트랙을 돈다고 하고 출발점이 같다고 하자.
 * 두 선수는 출발점에서 계속 만나게 된다. 즉, 속도1인 선수가 한바퀴 돌때마다 만나게 된다.
 * 
 * 이 문제의 경우는 출발점이 같지 않다.
 * n1이 loop의 시작점에 온 상황을 생각해보자.
 * loop의 길이가 n이고, n2는 n1보다 k만큼 앞서 있다고 하자.
 * (보다 정확히 말하면, n2가 loop를 2번 이상 돌았을 수 있기 때문에 n1~n2의 거리(offset)은 k%n 이다)
 * n2의 속도가 n1의 두배이므로 n1은 head에서 k만큼 진행했을 것이다.
 * 이제 n1,n2가 만나는 상황을 생각해보자.
 * (그림참조) n1,n2가 loop의 시작점으로부터 n-k 만큼 진행한 곳에서 만난다.
 * 즉, 만난 곳에서 k만큼 더 진행하면 loop의 시작점이 된다.
 * (엄밀하게는 그렇지 않다. k!=k%n 인 경우에 그렇다. 하지만 아래 설명대로 하면 된다.)
 * 
 * 이제 만난 곳과 head 에서 두 노드를 출발시켜서 만나는 지점을 취하면 loop의 시작점이 된다. 
 * ( k!=k%n 이어도 상관없다. k = qn + k%n 이기 때문에 빙글빙글 돌다보면 head는 loop 시작점에서 k%n 앞에 오게 된다)
 */
