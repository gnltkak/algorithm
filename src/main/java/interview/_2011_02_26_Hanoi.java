package interview;

import java.util.Stack;

/*
 * 별다른 설명이 필요없는 하노이 타워 문제
 */
public class _2011_02_26_Hanoi {
	public static void hanoiTower(Stack<Integer> s,Stack<Integer> e) {
		Stack<Integer> t = new Stack<Integer>();
		doHanoiTower(s,e,t,"A","B","C",s.size());
	}
	
	public static void doHanoiTower(Stack<Integer> s,Stack<Integer> e,Stack<Integer> t,String i,String j, String k,int moveNum) {
		if(moveNum==1)
		{	
			System.out.println(i+" 에서 "+j+" 로 "+s.peek()+" 를 옮깁니다.");
			e.push(s.pop());
			return;
		}	
		
		doHanoiTower(s,t,e,i,k,j,moveNum-1);
		doHanoiTower(s,e,t,i,j,k,1);
		doHanoiTower(t,e,s,k,j,i,moveNum-1);
	}
}

/*
 * T(n) = 2T(n-1) + O(1)
 * T(n) = O(2^n)
 */
