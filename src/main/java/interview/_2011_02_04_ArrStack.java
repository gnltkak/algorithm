package interview;

/*
 * array 로 stack 3개를 구현하라.
 */
public class _2011_02_04_ArrStack {
	private int[] top = {-1,-1,-1};
	private MyStack freeList;
	private StackNode[] buffer;
	
	public _2011_02_04_ArrStack(int size) {
		buffer = new StackNode[size];
		freeList = new MyStack(size);
		for(int i=0;i<size;i++)
			freeList.push(i);
	}
	
	public void push(int stackNum,int value) {
		if(freeList.isEmpty())
			throw new RuntimeException("buffer is full");
		
		int whereToPush = freeList.pop();
		buffer[whereToPush] = new StackNode(top[stackNum],value);
		top[stackNum] = whereToPush;
	}
	
	public int pop(int stackNum) {
		if(top[stackNum]==-1)
			throw new RuntimeException("stack is empty");
		
		StackNode node = buffer[top[stackNum]];
		buffer[top[stackNum]] = null;
		freeList.push(top[stackNum]);
		top[stackNum] = node.previous;
		return node.value;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<buffer.length;i++)
		{
			if(buffer[i]==null)
				sb.append("[null] ");
			else
				sb.append(buffer[i].toString());
		}
		
		return sb.toString();
	}
}

class StackNode {
	public int previous;
	public int value;
	public StackNode(int p,int v) {
		value = v;
		previous = p;
	}
	
	@Override
	public String toString() {
		return "[p="+previous+",v="+value+"] ";
	}
}

class MyStack {
	private int top = -1;
	private int[] buffer;
	
	public MyStack(int size) {
		buffer = new int[size];
	}
	
	public void push(int value) {
		if(top==buffer.length-1)
			throw new RuntimeException("stack is full");
		
		top++;
		buffer[top] = value;
	}
	
	public int pop() {
		if(isEmpty())
			throw new RuntimeException("stack is empty");
		
		int retVal = buffer[top];
		top--;
		return retVal;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
}

/*
 * 1. array를 3등분해서 각자 쓸 영역을 정해주는 방법
 * simple 하지만 빈 공간이 낭비된다.
 * 
 * 2.두개의 stack은 양 끝에 위치시키고 나머지 하나는 중간에 적당히 위치시키는 방법
 * stack이 grow 하다가 서로 경계에서 부딪히면, 어느한쪽이 1개씩 shift 해서 이사가야 된다.
 * 공간 낭비는 없지만 이사 비용이 크다는 단점이 있다.
 * 
 * 3.free list를 이용하는 방법
 * 공간낭비도 없고 이사비용도 없다.
 * 위 코드는 이것을 구현한 것이다.
 * push와 pop을 나눠서 생각해보자.
 * push 할때는 그냥 free list에서 하나 꺼내서 push 하면 된다.
 * pop 할때는 각 stack의 top 값을 조정하는게 문제가 된다.
 * push할때 return address 를 기록해두지 않으면 pop할때 top값을 조정할 수 없다.
 * 
 * 하지만 이건 엄밀히 말해 array 1개로 구현한게 아니라 4개로 구현한 것이다.
 */
