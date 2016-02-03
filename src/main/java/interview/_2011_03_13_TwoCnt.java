package interview;

import java.util.HashMap;

/*
 * 0~n중 2의 개수를 센다.
 * ex) n=12 라면 0,1,2,3,4,5,6,7,8,9,10,11,12 중 2는 2개.
 */
public class _2011_03_13_TwoCnt {
	public static int twoCnt(int n)	{
		return twoCntLogN3(n);
	}
	
	public static int twoCntLogN1(int n) {
		if(n<=1) //n=0,1
			return 0;
		if(n<=9) //n=2,3,4,5,6,7,8,9
			return 1;		
		
		String s = Integer.toString(n);
		int[] fullCnt = twoCntFull(s.length()-1);		
		int[] pow = new int[s.length()];
		for(int i=0;i<pow.length;i++)
			pow[i] = (int)Math.pow(10, i);		
		
		return doTwoCnt(s,0,fullCnt,pow);
	}
	
	private static int doTwoCnt(String s,int i,int[] fullCnt,int[] pow) {		
		int msd = Integer.parseInt(""+s.charAt(i));		
		if(i==s.length()-1)
		{
			if(msd<2)
				return 0;
			return 1;
		}
		
		int result = msd*fullCnt[s.length()-2-i];		
		if(msd>2)
			result += pow[s.length()-1-i];
		else if(msd==2)
			result += (Integer.parseInt(s.substring(i+1)))+1;		
		
		result += doTwoCnt(s,i+1,fullCnt,pow);
		
		return result;
	}

	private static int[] twoCntFull(int d) {
		int[] result = new int[d];
		result[0] = 1;		
		
		int pow = 10;
		for(int k=1;k<result.length;k++)
		{
			result[k] = 10*result[k-1]+ pow;
			pow *= 10;
		}
		return result;
	}
	
	/////////////////////////////////////////////
	public static int twoCntNlogN(int n) {
		int result = 0;
		for(int i=0;i<=n;i++)
		{
			String s = Integer.toString(i);
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)=='2')
					result++;
			}	
		}
		return result;
	}
	
	/////////////////////////////////////////////
	public static int twoCntLogN2(int n)	{
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		return doTwoCntLogN2(n,hm);
	}
	
	private static int doTwoCntLogN2(int n,HashMap<Integer,Integer> hm)	{
		if(n<=1) //n=0,1
			return 0;
		if(n<=9) //n=2,3,4,5,6,7,8,9
			return 1;		
		
		if(hm.containsKey(n))
			return hm.get(n);
		
		String nStr = Integer.toString(n);
		int digits = nStr.length();		
		char first = nStr.charAt(0);
		
		int multiply = (int)(Math.pow(10, digits-1));
		int remainder = n%multiply;
		
		int result = twoCnt(multiply*Integer.parseInt(""+first)-1);
		result += twoCnt(remainder);
		
		if(first=='2')
			result += remainder + 1;
		
		hm.put(n, result);
		
		return result;
	}
	
	/////////////////////////////////////////////
	public static int twoCntLogN3(int n) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		return doTwoCntLogN3(n, hm);
	}
	
	public static int doTwoCntLogN3(int n, HashMap<Integer, Integer> hm) {
		if (n <= 1)
			return 0;
		if (n <= 9)
			return 1;
		
		if (hm.containsKey(n))
			return hm.get(n);
		
		int q = n / 10;
		int r = n % 10;
		int qResult = doTwoCntLogN3(q, hm);
		int qMinus1Result = doTwoCntLogN3(q - 1, hm);
		
		int result = q;
		result += 10 * qMinus1Result;
		result += doTwoCntLogN3(r, hm);		
		result += (r + 1) * (qResult - qMinus1Result);
		
		hm.put(n, result);
		
		return result;
	}
}

/*
 * n의 자리수는 O(logn) 이다.
 * 
 * 1.O(nlogn) solution 
 * 가장 바보같고 가장 심플한 솔루션이다 말이 필요없다.
 * 
 * 2.O(logn) solution
 * 우선 숫자들을 늘어놓고 관찰해보자.
 *  0  1  2  3  4  5  6  7  8  9
 * 10 11 12 13 14 15 16 17 18 19
 * 20 21 22 23 24 25 26 27 28 29
 * 30 31 32 33 34 35 36 37 38 39
 * 
 * 십의자리가 2인 경우를 제외하면 각 행에는 2가 한번씩 등장한다.
 * 2를 special case로 처리해야 함을 알 수 있다.
 * 
 * 이제 recursive하게 풀어보자.
 * 345를 예로 들어보자.
 * 
 * 백의 자리에는 0(아무것도 안옴),1,2,3 가 올 수 있다.
 * 0 - 나머지는 0~99 가 올 수 있음
 * 1 - 나머지는 0~99 가 올 수 있음
 * 2 - 나머지는 0~99 가 올 수 있음, 또한 0~99(100개) 만큼 2가 더 추가됨
 * 3 - 나머지는 0~45 가 올 수 있음
 * 
 * 답 = 3*(n이99인경우의 답)
 * 답 += 100(10^2)
 * 답 += (n이45인경우의답)
 * 
 * 이렇게 된다.
 * 
 * 그리고 여기서 다른 예외는 245 같은 경우이다. 이 경우는 다음과 같이 된다.
 * 0 - 나머지는 0~99 가 올 수 있음
 * 1 - 나머지는 0~99 가 올 수 있음
 * 2 - 나머지는 0~45 가 올 수 있음, 또한 0~45(46개) 만큼 2가 더 추가됨
 * 
 * 구현상에서 불필요한 중복계산을 막기 위해 
 * fullCnt ( n=9,n=99,n=999, ... 인 경우를 array로 저장) 와
 * pow ( 1,10,100,1000, ... 을 저장) 을 미리 계산해둔다.
 * (이 부분은 처음부터 생각하지 못해도 좋다. 점진적 개선을 하면 되니까)
 * fullCnt 는 f(d) = 10*f(d-1) + 10^d ( d>=1)
 *                = 1 (d=0)
 * 의 점화식으로 구할 수 있다.
 * 
 * n의 자리수에 비례하는 연산을 하게 되므로 성능은 O(logn)이 된다.
 * 
 * 3.O(logn) solution. (2보다 simple)
 * 2와 기본적인 방향은 비슷하나 더 간단하다.
 * 포인트는 구간을 나누는 것이다.
 * 
 * 3234를 예로 들어보자.
 * [0,3234] 구간을 [0,2999] 와 [3000,3234] 로 나눈다.
 * [0,2999] 는 recursive 하게 풀면 되고
 * [3000,3234] 는  [0,234] 인 경우와 같으므로 역시 recursive 하게 풀면 된다.
 * 
 * 첫자리가 2인 경우는 이야기가 조금 다르다.
 * 2234 를 예로 들어보자.
 * [0,2234] 구간을 [0,1999] 와 [2000,2234] 로 나눈다.
 * [0,1999] 는 recursive 하게 풀면 되고
 * [2000,2234] 는 [0,234] 인 경우 + (234 + 1) 이 된다.
 * 
 * 여기서도 call tree 를 그려보면 중복 call 이 상당히 많음을 알 수 있는데, 
 * HashTable로 해결하면 된다.(Dynamic Programming)
 * 
 * 성능을 분석해보자. 숫자 하나를 예로 잡아서 call-tree를 그려보면 쉽다.
 * 4567의 경우는 3999 2999 1999, 999,899, ... ,199, 99,89, ... 19, 9 거의 이런식의 call 이 된다.
 * 각 자리마다 최대9 번씩 call 하기 때문에 전체성능은 O(9logN)= O(logN) 이 된다.
 * 저 숫자들에 대해 전처리를 해놓는다면 상수를 1로 만들수 있기 때문에 수행시간이 9분의1이 될 것이다. 
 * 
 * 4. 3보다 간단한 O(logn) 솔루션
 * 기본적 방향은 비슷한데 생각하기도 구현하기도 훨씬 간단하고 logN 앞의 상수도 9가 아니라 2이다.
 * 우선 base case는 n<=9 인 경우로 한다.
 * 234 의 경우 [0, 229] 와 [230, 234] 로 나누어 생각한다.
 * 10으로 나눈 몫과 나머지를 기준으로 생각해보자.
 * [0, 229] 는 [0, 9], [10, 19], ..., [220, 229] 의 sub구간으로 나눌 수 있다.
 * 이 23개(==n/10)의 sub구간에는 각각 1의 자리의 수가 2인 숫자가 1개씩 있다. 즉, 2가 23개 있다.
 * 그리고 각 sub구간에 포함된 숫자를 10으로 나눈 몫에 포함된 2의 개수 * 10 개만큼 더 있다.
 * 예를 들어 [120, 129] 의 sub구간에 속한 숫자는 10으로 나눈 몫이 12인데,
 * 12에는 2가 1개 있고 구간에 속한 숫자의 개수가 10개이므로 10개의 2를 더하면 된다.
 * [0, 229] 에 속하는 23개 각 sub구간들의 앞대가리들(10으로 나눈 몫들)은 0~22 이므로
 * 10 * f(22(==n/10 - 1)) 을 추가해주면 된다.
 * 즉, [0, 229] 에 속한 2의 개수는 23 + 10*f(22) 라는 것이다.
 * 이제 [230, 234] 를 생각해보자.
 * 맨 끝 숫자의 일의 자리가 9가 아닌 것만 고려해 주면 [0, 229]에서와 같다.
 * 1) 23에 포함된 2의 개수 * 이 구간의 길이
 *    = (f(24) - f(23)) * (234%10 + 1)    
 * 2) 0 ~ 4 에 포함된 2의 개수
 *    = f(4)
 * 1)과 2)를 더해주면 된다.   
 * 
 * 성능을 분석하기 위해 call tree를 그려보면
 * leaf 의 개수가 2^log(10,2) = n^log(10,2) 여서 O(n^log(10,2)) 임을 알 수 있다.
 * 그리고 중복된 call이 엄청나게 많음을 알 수 있는데 DP로 제거해주면 된다.
 * 중복된 것들을 지워보면 결국 풀게 되는 subproblem 수는 2*logN 이 된다.
 * 고로 전체 성능은 O(logN)이다.
 */
