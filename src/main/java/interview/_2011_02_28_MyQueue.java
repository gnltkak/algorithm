package interview;

import java.util.Stack;

/*
 * stack 2개로 큐를 구현한다.
 */
public class _2011_02_28_MyQueue {
	private Stack<Integer> st1 = new Stack<Integer>();
	private Stack<Integer> st2 = new Stack<Integer>();
	
	public void enqueue(int value) {
		st1.push(value);
	}
	
	public int dequeue() {
		if(st1.isEmpty() && st2.isEmpty())
			throw new RuntimeException("queue is empty");
		
		if(!st2.empty())
			return st2.pop();
		
		while(!st1.empty())
			st2.push(st1.pop());
		
		return st2.pop();
	}
}
