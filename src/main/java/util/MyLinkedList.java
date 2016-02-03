package util;

public class MyLinkedList {
	private MyLinkedListNode head;
	private MyLinkedListNode tail;
	
	public MyLinkedList() {
		head = new MyLinkedListNode(-1,null); //dummy head
		tail = head;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		MyLinkedListNode curr = head.next;
		
		while(curr!=null)
		{
			sb.append(curr.value);
			if(curr.next!=null)
				sb.append(" -> ");
				
			curr = curr.next;
		}
		
		return sb.toString();
	}
	
	public MyLinkedListNode getNode(int index) {
		if(isEmpty())
			throw new RuntimeException("list is empty");
		
		MyLinkedListNode n = head;
		for(int i=0;i<=index;i++)
		{
			n = n.next;
			if(n==null)
				throw new RuntimeException("list is empty");
		}
		
		return n;
	}
	
	public boolean isEmpty() {
		return (head.next==null);
	}
	
	public MyLinkedListNode getFirstNode() {
		return head.next;
	}
	
	public void enqueue(int value) {
		MyLinkedListNode n = new MyLinkedListNode(value,null);		
		tail.next = n;
		tail = n;
	}
	
	public int dequeue() {
		if(isEmpty())
			throw new RuntimeException("list is empty");
		
		MyLinkedListNode n = head.next;
		head.next = n.next;
		n.next = null; //보안상 이유
		return n.value;
	}
	
	public void delete(int value) {
		if(isEmpty())
			throw new RuntimeException("list is empty");
		
		MyLinkedListNode prev = head;
		MyLinkedListNode curr = head.next;
		
		boolean ok = false;
		while(curr!=null)
		{
			if(curr.value == value)
			{
				ok = true;
				if(curr==tail)
					tail = prev;
				
				prev.next = curr.next;
				curr.next = null; //보안상 이유
				break;
			}
			prev = curr;
			curr = curr.next;
		}
		
		if(!ok)
			throw new RuntimeException(value+" is not in list");
	}
	
	public void add(int prevValue,int value) {
		if(isEmpty())
			throw new RuntimeException("list is empty");
		
		MyLinkedListNode curr = head.next;
		boolean ok = false;
		while(curr!=null)
		{
			if(curr.value==prevValue)
			{
				ok = true;
				MyLinkedListNode n = new MyLinkedListNode(value,curr.next);
				curr.next = n;
				if(curr==tail)
					tail = n;
				break;
			}
			curr = curr.next;
		}
		if(!ok)
			throw new RuntimeException(prevValue+" is not in list");
	}
}
