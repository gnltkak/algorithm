package interview;

import java.util.Stack;

/*
 * 주어진 stack을 sort 한다. 사용할 수 있는 연산은 오직 push(), pop(), peek(), isEmpty() 뿐이다.
 * ex) 3 -> 1 -> 2 -> 0 (3이 top) 이 주어지면 3 -> 2 -> 1 -> 0 을 만들어야 한다. 
 */
public class _2011_02_26_StackSort {
	public static Stack<Integer> stackSort(Stack<Integer> st) {
		return stackSort2(st);
		/*
		Stack<Integer> r = new Stack<Integer>();
		while(!st.empty())
			doStackSort(st.pop(),r);
		return r;
		*/
	}

	//precondition : r is sorted
	//r에 n이 들어갈 올바를 자리를 찾아서 넣는다.
	private static void doStackSort(Integer n, Stack<Integer> r) {
		Stack<Integer> t = new Stack<Integer>();
		while(!r.empty() && r.peek()>n)
			t.push(r.pop());
		
		r.push(n);
		
		while(!t.empty())
			r.push(t.pop());
	}
	
	/////////////////////////////////////////////////////////////
	public static Stack<Integer> stackSort2(Stack<Integer> st) {
		Stack<Integer> r = new Stack<Integer>();
		Stack<Integer> t = new Stack<Integer>();
		
		while (!st.empty()) {
			int min = st.peek();		
			while (!st.empty()) {
				int num = st.pop();
				if (num < min)
					min = num;
				t.push(num);
			}
			r.push(min);
			
			boolean minRemoved = false;
			while (!t.empty()) {
				int num = t.pop();
				if (!minRemoved && num == min) {
					minRemoved = true;
					continue;
				}				
				st.push(num);					
			}
		}
		
		return r;
	}
}

/*
 * 실무에서라면 stack을 array로 copy 후 array를 sort 하여 stack에 다시 넣으면 되겠지만
 * 문제의 제약조건상 그럴 수가 없다. stack만 써야 한다.
 * (사실 실무에서라면 sorting 될 필요가 있는 것들을 stack에 넣지 않았겠지만..)
 * 
 * 원래의 stack st 와 sorting 된 상태를 유지하는 stack r 을 이용한다.
 * st에서 하나씩 꺼내서 r에 삽입하면 된다.
 * r에 삽입하는 메소드가 doStackSort() 이다. 조금만 생각해보면 이 과정은 매우 쉽다.
 * 
 * 전체 성능은 O(n^2)이 된다.
 * 최악의 경우 doStackSort() 에서 
 * 첫번째 while 루프에서 r의 모든 노드를 pop 해야 하기 때문이다.
 * 최악의 경우는 sorting 된 stack이 input으로 들어오는 경우라고 할 수 있겠다.
 * 
 * 두번째 방법도 O(n^2) 인데 selection sort를 흉내낸 것이다.
 * 다만 이 경우에는 worst, average, best case 에 모두 n^2이 걸린다. * 
 */
