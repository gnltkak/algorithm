package interview;

import util.Util;

/*
 * input : integer array
 * find : LIS(longest increasing sequence) 의 길이, LIS 중 하나.
 * 예) 0,1,1,2,5,3,4,1,7,8 에서 LIS 의 길이는 8 이고
 *     그 중 하나는 0,1,1,2,3,4,7,8 이다.
 * LIS의 길이는 유일하나, LIS는 유일하지 않다. 여기서는 LIS의 길이와 LIS중 하나를 출력하도록 한다.
 */
public class _2011_02_13_LIS {
	public static int lis1(int[] arr) {
		int[] e = new int[arr.length]; //ending here
		int[] s = new int[arr.length]; //solution
		int[] p = new int[arr.length]; //prev - 수열 출력을 위한 것
		
		e[0] = 1;
		s[0] = 1;
		p[0] = -1;
		
		for(int i=1;i<arr.length;i++)
		{
			int t = -1;
			int max = -1;
			for(int k=0;k<=i-1;k++)
			{
				if(arr[k]<=arr[i] && e[k] > max)
				{
					max = e[k];
					t = k;
				}
			}
			
			if(t!=-1)
				e[i] = max + 1;
			else
				e[i] = 1;
			p[i] = t;
			s[i] = Math.max(s[i-1], e[i]);
		}	
		
		//LIS를 출력함
		int k = -1;		
		for(int i=0;i<arr.length;i++)
		{
			if(e[i]==s[arr.length-1])
			{
				k = i;
				break;
			}
		}
		
		System.out.println("-----O(n^2) solution-----");
		System.out.println("arr:"+Util.arrayToString(arr, ","));
		System.out.print("LIS(역순):"+arr[k]);
		while(p[k]!=-1)
		{			
			System.out.print(","+arr[p[k]]);
			k = p[k];			
		}
		System.out.println();
		
		return s[arr.length-1];
	}
	
	public static int lis2(int[] arr) {
		int[] e = new int[arr.length]; //ending here
		int[] s = new int[arr.length]; //solution
		int[] p = new int[arr.length]; //prev - 수열 출력을 위한 것
		int[] m = new int[arr.length+1]; //k 값을 logn 에 select 하기 위한 것
				
		e[0] = 1;
		s[0] = 1;
		p[0] = -1;
		for(int i=0;i<m.length;i++)
			m[i] = -1;
		m[1] = 0;
		
		int currMax = 1; //현재까지 발견된 LIS의 길이
		for(int i=1;i<arr.length;i++)
		{			
			int k = bSearch(arr,m,i,1,currMax); //k는 m 상의 index임에 유의하자.
			if(k==-1)
			{
				e[i] = 1;
				p[i] = -1;
			}
			else	
			{
				e[i] = e[m[k]] + 1;
				p[i] = m[k];	
			}		
					
			//길이가 e[i]인 것이 처음으로 나타난 경우를 빼먹지 않도록 유의! 
			if(m[e[i]]==-1 || arr[i]<arr[m[e[i]]])
				m[e[i]]=i;
			
			s[i] = Math.max(s[i-1], e[i]);
			if(s[i]>currMax)
				currMax = s[i];			
		}
		
		//LIS를 출력함
		int k = -1;		
		for(int i=0;i<arr.length;i++)
		{
			if(e[i]==s[arr.length-1])
			{
				k = i;
				break;
			}
		}
		
		System.out.println("-----O(n log n) solution-----");
		System.out.println("arr:"+Util.arrayToString(arr, ","));
		System.out.print("LIS(역순):"+arr[k]);
		while(p[k]!=-1)
		{			
			System.out.print(","+arr[p[k]]);
			k = p[k];			
		}
		System.out.println();
		
		return s[arr.length-1];
	}

	private static int bSearch(int[] arr, int[] m, int i, int l, int r) {
		if(l>r)
			return -1;
		
		int mid = (l+r)/2;	
		
		if(arr[i]<arr[m[mid]])
			return bSearch(arr,m,i,l,mid-1);
		int rightTry = bSearch(arr,m,i,mid+1,r);
		if(rightTry!=-1)
			return rightTry;
		return mid;
	}
}


/*
 * 이 문제를 풀기 전에, 다음의 점화식을 상기하자.
 * T(n) = T(n-1) + O(1) => T(n) = O(n)
 * T(n) = T(n-1) + O(n) => T(n) = O(n^2)
 * T(n) = T(n-1) + O(logn) => T(n) = O(logn!) = O(nlogn)
 * 
 * input : A[0...n-1]
 * 
 * 1. O(n^2) solution
 * S[i] : A[0..i] 에서의 LIS의 길이 (subproblem의 해)
 * (사실 s[i]를 모두 저장할 필요는 없다. S[i-1]만 keep 하면 된다)
 * 
 * 이제 S[i] 과 S[i-1]의 관계를 살펴보자.
 * S[i] 가 S[i-1]와 달라지려면, A[i]가 S[i]에 포함되어야 한다.
 * 그렇다면 포함 여부를 어떻게 알 수 있을까?
 * E[i] 를 A[i]로 끝나는 LIS의 길이라고 하자.
 * k=[0,i-1] 범위에서 A[k] <= A[i] 인 k에 대해 E[k]가 가장 큰 것이 있을 것이다.
 * 그 뒤에 A[i]를 붙여봐서 그 길이가 S[i-1]보다 큰지를 보면 된다. 따라서 다음과 같은 식이 성립한다.
 * E[i] =  ( max(0<=k<=i-1) E[k] ) + 1 ( where A[k]<=A[i], i>=1 )
 *         1 ( where i=0 또는 선택된 k가 존재하지 않을 시 )
 * S[i] = max ( S[i-1] , E[i] ) ( i>=1 )
 *        1 ( i=0)  
 * 
 * 따라서 구하고자 하는 답은 S[n-1] 이 된다.
 * 
 * 그렇다면 LIS의 길이가 아니라, LIS중 하나를 출력하는 것은 어떻게 할까?
 * 이를 위해 별도의 데이터가 추가로 필요하다.
 * 다익스트라 알고리즘에서 처럼, 내가 어디에서 왔는지(LIS의 어떤 원소 바로 앞의 원소의 index)를 저장하는 것이다.
 * P[i] 를 A[i]로 끝나는 LIS 에서 A[i] 바로 앞에 오는 원소의 index 라고 하자.
 * 
 * P[i] = -1 ( where i = 0 또는 i>=1,선택된 k가 존재하지 않을 시 )
 *        E[i]를 계산할 때 선택된 k 값 ( where i>=1, 선택된 k가 존재할 시)  
 *        
 * 출력은 다음과 같이 한다. (역순으로 출력)
 * 1.우선 S[n-1] 과 같은 값을 가지는 E[j] 를 찾는다.
 * A[j] 를 출력한다. ( 이것이 LIS의 마지막 원소이다)
 * A[P[j]] 를 P[j]!=-1 인 동안 출력한다.
 * 
 * 
 * 2.O(nlogn) solution
 * 1번 solution에서 k를 찾는 과정(A[i]가 어디 뒤에 붙을지 찾는 과정)을 O(logn) 으로 줄이면 된다.
 * logn 의 대표 알고리즘은 binary search 이다.
 * 그렇다면 도대체 어디서 binary search를 할 것인가? 이를 위해 추가의 자료구조가 필요하다.
 * M[i] 를 길이가 i 인 IS 중 가장 마지막 원소가 제일 작은 것을 택했을 때, 그 마지막 원소의 index 라고 하자.
 * (값을 담지 않고 index를 담는 것은 LIS 를 출력하기 위함이다. 즉 P 를 위함이다 )
 * binary search를 하려면 A[M[i]]가 sorting 되어 있어야 한다. ( sorting 되어있음은 잠시 후에 보자)
 * search의 범위는 [1,currMax] 이다. ( currMax 는 현재까지 알려진 LIS의 길이 )
 * 
 * M에서 중간 원소를 택한다. ( search 범위 : [l,r] )
 * m = (l+r)/2 일때
 * A[i]>=A[M[m]] 이면, A[i]는 A[M[m]]뒤에 붙을 수 있다.
 * 그리고 M[l,m-1]은 볼 필요가 없어진다. ( m보다 길이가 작은 IS 니까..)
 * A[i]<A[M[m]] 이면 어떻게 될까? A[i]는 A[M[m]]뒤에 붙을 수 없다.
 * 그렇다면 문맥상[..] M[l,m-1]을 뒤져봐야 하고 M[m+1,r]은 볼 필요가 없어야 할텐데 과연 그럴까?
 * A[i]<A[M[m]] 이면서 M[m+1,r] 범위에서 찾은 원소 뒤에 붙을 수 있을려면 다음과 같은 상황이어야 한다.
 * 예) A[i] = 5
 *    A[M[l]] .... A[M[m]]=7,1,2,... A[M[r]]
 * 길이 k짜리 IS 는 길이 k-1 짜리 IS를 포함한다.
 * 따라서 위와 같은 상황은 있을 수 없다. A[M[k-1]] <= A[M[k]] 가 성립하기 때문이다.
 * 따라서 A[M[i]] 는 sorting 되어 있다고 할 수 있다.   
 * 
 * 이 솔루션은 생각하기도 까다롭고 구현도 까다롭다 ㅠㅠ
 */
