package interview;

import util.MyLinkedList;
import util.MyLinkedListNode;

/*
 * linked list 로 10진수 덧셈을 수행한다.
 * 예를들어 345 + 1735 = 2080 이라면
 * input으로 5 -> 4 -> 3 과 5 -> 3 -> 7 -> 1 이 주어지고 0 -> 8 -> 0 -> 2 를 리턴해야 한다.
 * 
 */
public class _2011_02_24_ListSum {
	public static MyLinkedList listSum(MyLinkedList l1,MyLinkedList l2) {
		return listSum2(l1, l2);
		/*
		MyLinkedList result = new MyLinkedList();
		doListSum(l1.getFirstNode(),l2.getFirstNode(),0,result);
		return result;
		*/
	}

	private static void doListSum(MyLinkedListNode p,MyLinkedListNode q, int carry, MyLinkedList result) {
		if(p==null && q==null)
		{
			if(carry==1)
				result.enqueue(1);
			return;
		}
		
		MyLinkedListNode pNext = null;
		MyLinkedListNode qNext = null;
		int num1 = 0;
		int num2 = 0;
		
		if(p!=null)
		{
			pNext = p.next;
			num1 = p.value;
		}
		if(q!=null)
		{
			qNext = q.next;
			num2 = q.value;
		}
		int t = num1 + num2 + carry;
		if(t>=10)
		{
			t -= 10;
			carry = 1;
		}
		else
			carry = 0;
		
		result.enqueue(t);
		
		doListSum(pNext,qNext,carry,result);
	}
	
	/////////////////////////////////////////////////////
	public static MyLinkedList listSum2(MyLinkedList l1,MyLinkedList l2) {
		MyLinkedList result = new MyLinkedList();
		MyLinkedListNode p1 = l1.getFirstNode();
		MyLinkedListNode p2 = l2.getFirstNode();
		
		int carry = 0;
		while (true) {
			if (p1 == null && p2 == null)
				break;
			
			int n1 = 0, n2 = 0;
			if (p1 != null)
				n1 = p1.value;
			if (p2 != null)
				n2 = p2.value;
			int add = n1 + n2 + carry;
			if (add >= 10) {
				carry = 1;
				add -= 10;
			} else {
				carry = 0;
			}
			result.enqueue(add);
			
			if (p1 != null)
				p1 = p1.next;
			if (p2 != null)
				p2 = p2.next;
		}
		
		if (carry == 1)
			result.enqueue(1);
		
		return result;
	}
}

/*
 * 맨 마지막에 carry가 남는 경우를 조심하자.
 */
