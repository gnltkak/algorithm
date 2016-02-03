package interview;

import java.util.ArrayList;

/*
 * input : integer n>0
 * find : n쌍의 여닫는 괄호 (,) 를 올바르게 배열하는 모든 경우의 수 출력
 * ex) n=1 : () 출력
 *     n=2 : ()() ,(()) 출력
 *     n=3 : ()()(), ()(()), (())(), (()()), ((())) 출력
 */
public class _2011_01_31_ParenComb {
	public static void printParenComb(int n) {
		ArrayList<String> result = parenComb(n);
		for(String s : result)
			System.out.println(s);
	}
	
	private static ArrayList<String> parenComb(int n) {
		ArrayList<String> result = new ArrayList<String>();
		
		if(n==1)
		{
			result.add("()");
			return result;
		}
		
		ArrayList<String> prev = parenComb(n-1);
		for(String one : prev)
		{
			result.add("("+one+")");
			String lAdd = "()"+one;
			String rAdd = one+"()";
			result.add(lAdd);
			if(lAdd.compareTo(rAdd)!=0)
				result.add(rAdd);
		}		
		return result;
	}
	
	///////////////////////////////////////////////////////////
	
	public static void printParenCombOptimal(int n) {
		char[] sb = new char[2*n];
		doParenCombOptimal(2*n,n,0,sb);
	}

	private static void doParenCombOptimal(int left, int lPLeft, int v, char[] sb) {
		if(left==0)
		{
			System.out.println(sb);
			return;
		}
		
		if(lPLeft>0) // ( 를 고르는 경우
		{
			sb[sb.length-left]='(';
			doParenCombOptimal(left-1, lPLeft-1, v+1, sb);			
		}
		if(v>0) // ) 를 고르는 경우
		{
			sb[sb.length-left]=')';
			doParenCombOptimal(left-1, lPLeft, v-1, sb);
		}
	}
	
	//////////////////////////////////////////
	public static void printParenCombOptimal2(int n) {
		char[] paren = new char[2*n];
		doParenCombOptimal2(paren,n,n,0);
	}

	private static void doParenCombOptimal2(char[] paren, int lpCnt, int rpCnt, int currPos) {
		if(lpCnt==0 && rpCnt==0)
		{
			System.out.println(paren);
			return;
		}
		
		if(lpCnt>0)
		{
			paren[currPos]='(';
			doParenCombOptimal2(paren,lpCnt-1,rpCnt,currPos+1);
		}
		if(lpCnt<rpCnt)
		{
			paren[currPos]=')';
			doParenCombOptimal2(paren,lpCnt,rpCnt-1,currPos+1);
		}
	}	
}

/*
 * solution 1 : printParenComb()
 * n의 솔루션을 구할 때 n-1의 솔루션을 이용한다.
 * n의 솔루션의 각 경우(a라고 하자)에 대해 (a), ()a , a() 를 덧붙이면 된다.
 * 단, ()a 와 a()가 같을 수 있으므로 (예 : a=() 인 경우 ) 중복을 검사한다.
 * 이 솔루션은 중복을 검사하는 오버헤드가 크고, 
 * n을 구하기 위해 1...n-1 까지의 솔루션을 모두 구해서 저장하기 때문에 시간 및 공간이 크게 낭비된다. 
 * 
 * solution 2 : printParenCombOptimal()
 * (가 n개, )가 n개 주어지므로
 * 길이가 2n인 문자열에서 (와 )를 배치하는 문제로 바꾸어 생각한다.
 * 각 자리마다 ( 또는 ) 를 배치하고 (물론 가능한 경우에) 그 뒷부분은 recurse 한다.
 * 정확하게 size 가 n일때의 경우의 수만큼만 출력하게 되며
 * 메모리 사용량도 크기가 2n인 char array 하나밖에 되지 않는다.
 * 
 * (는 언제 사용 가능하고 ) 는 언제 사용 가능할까?
 * 우선 ) 는 (가 먼저 나와야 사용할 수 있다.
 * 보다 정확히 말하자면, (를 +1 로 )를 -1로 표시했을때 앞에서의 숫자의 합이 양수가 되어야 한다.
 * (다시말해, (의 수가 ) 의 수보다 많을때만 사용 가능하다)
 * (는 아무때나 쓸수있지만, 개수의 제한이 있으므로 (의 사용량이 n미만일때만 사용가능하다.
 * 
 * solution 3 : printParenCombOptimal2()
 * solution 2와 비슷한데 더 이해하기가 쉽다.
 * (는 (가 남아 있는 한 언제든지 배치할 수 있고
 * ) 는 (가 앞에 나왔어야 배치할 수 있다. ( 즉, lpCnt < rpCnt 여야.. )
 */
