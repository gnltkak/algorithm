package interview;

import java.util.ArrayList;
import java.util.Stack;

/*
 * size 제한이 있는 stack을 여러개 사용하여 하나의 stack처럼 작동하게 해야 한다.
 * (추가문제) subStack의 index를 주면 거기서 pop 하는 연산을 지원해야 한다.
 */
public class _2011_02_28_SetOfStacks {
	private int topStack = -1;
	private int sizePerSubStack;
	private ArrayList<Stack<Integer>> subStack = new ArrayList<Stack<Integer>>();
	
	public _2011_02_28_SetOfStacks(int sizePerSubStack) {
		if(sizePerSubStack<=0)
			throw new RuntimeException("size must be positive");
		
		this.sizePerSubStack = sizePerSubStack;			
	}
	
	public void push(int value) {		
		if(topStack==-1 || subStack.get(topStack).size()==sizePerSubStack)
		{
			topStack++;
			subStack.add(new Stack<Integer>());
		}
		subStack.get(topStack).push(value);
	}
	
	public int pop() {
		if(topStack==-1)
			throw new RuntimeException("stack is empty");
		
		//topStack이 비어있는 경우는 없다.
		int retVal = subStack.get(topStack).pop();		
		if(subStack.get(topStack).isEmpty())
		{
			subStack.remove(topStack);
			topStack--;
		}
		return retVal;
	}
	
	public int popAt(int index) {
		if(index==topStack)
			return pop();
		
		int retVal = subStack.get(index).pop();
		for(int i=index;i<topStack;i++)
			roll(i,i+1);
		
		if(subStack.get(topStack).isEmpty())
		{
			subStack.remove(topStack);
			topStack--;
		}
		
		return retVal;
	}
	
	//rightSt 의 bottom을 leftSt에 push한다
	private void roll(int leftSt,int rightSt) {
		Stack<Integer> temp = new Stack<Integer>();
		Stack<Integer> left = subStack.get(leftSt);
		Stack<Integer> right = subStack.get(rightSt);
		while(!right.isEmpty())
			temp.push(right.pop());
		left.push(temp.pop());
		while(!temp.isEmpty())
			right.push(temp.pop());		
	}
}

/*
 * 알고리즘이 어려운 것은 없다. 구현에만 유의하면 된다.
 * pop 을 구현할 때 subStack이 비어있는지 아닌지를 유의해야 한다. 
 * 
 * 난이도가 좀 있는 부분은 popAt() 이다.
 * roll()을 연쇄적으로 해야한다는 사실을 명심해야 하고
 * roll()이 종료된 후에 topStack 이 비어있는지 체크하는 것을 잊지 말아야 한다.
 */
