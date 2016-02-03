package interview;

import java.util.ArrayList;

import util.Util;

/*
 * input : 양의 정수 n (n>0)
 * find : 1~n 까지의 소수를 찾기
 */
public class _2011_01_18_Prime {
	//precondition : n>0 인 정수
	public static int[] primes(int n) {
		boolean[] isPrime = new boolean[n+1];
		for(int i=2;i<=n;i++)
			isPrime[i] = true;
		
		for(int i=2;i<=(int)Math.ceil(Math.sqrt(n));i++)
		{
			if(isPrime[i])
				markPrime(isPrime,i);
		}
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=2;i<=n;i++)
		{
			if(isPrime[i])
				arrList.add(new Integer(i));
		}
		return Util.integerArrListToIntArr(arrList);
	}

	private static void markPrime(boolean[] isPrime, int num) {
		int i = num*2;
		while(i<isPrime.length)
		{
			isPrime[i] = false;
			i += num;
		}
	}	
}
/*
 * solution - 에라토스테네스의 체 : O(nlogn) 과 O(n) 사이..
 * 위 알고리즘은 에라토스네테스의 체를 그대로 시뮬레이션 한 것이다.
 * 시간 복잡도 분석이 구현만큼 간단하지는 않다.
 * 우선 markPrime 을 호출하는 loop에서 i가 2부터 n까지 도는 경우를 생각해보자.
 * loose 하게 말해서 (upper bounding ) markPrime 안의 while loop가 도는 총횟수(즉 알고리즘의 전체 성능)는 다음과 같다.
 * n/2 + n/3 + .... + n/n 
 * = n ( 1/2 + 1/3 + ... + 1)
 * < n ( 1/2 + 1/2 + 1/4 + 1/4 + 1/4 + 1/4 + 1/8 + .... ) 
 * <= n logn 
 * ( 항을 2^k 개씩 grouping 해서 1이 총 몇개 만들어지는지 생각해보면 된다.  항의 개수는 총 n개이다. ) 
 * ( 항의 수 : 2^1 + 2^2 + ... 2^k = n => k = logn (대충) 이 식의 각 항 하나가 1 한개를 만든다.. )
 * 
 * 그런데 여기서 좀더 최적화를 할 수 있다.
 * 점근적 성능에는 영향을 미치지 않지만 상수팩터를 줄일 수 있다.
 * 에라토스테네스의 채에서는 a의 배수들을 계속 지워나간다.
 * 즉 임의의 어떤 수 num = a*q 로 표현되는데, 여기서 a(또는 q)의 최대값을 알면 거기까지만 루프를 돌리면 된다.
 * n = sqrt(n)*sqrt(n) 이므로 a의 최대값은 ceil(sqrt(n)) 으로 upper bounding 시킬 수 있다.
 * ceil(sqrt(n)) 까지만 루프를 돌릴 경우 원래의 식은 아래와 같이 된다.
 * n/2 + n/3 + .... + n/ceil(sqrt(n))
 * ...
 * <= n log(sqrt(n))
 * 
 * 그러므로 이 경우에도 시간복잡도는 O(nlogn) 이 되는데, 앞의 경우에 비해 시간은 절반이 걸린다.
 */
