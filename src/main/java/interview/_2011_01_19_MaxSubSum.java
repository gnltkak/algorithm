package interview;

import util.Util;

/*
 * input : integer array (반드시 음,양수가 섞여야 함 - 양수만있으면 그냥 다 더한게 답)
 * find : 연속 부분합의 최대값 
 */
public class _2011_01_19_MaxSubSum {	
	public static long maxSubSum(int[] array) {
		return maxSubSumLinear(array);
	}
	
	public static long maxSubSumRef(int[] array) {
		return maxSubSumDivideAndConquer(array);
	}
	
	public static long maxSubSumDPNaive(int[] array) {
		int n = array.length;
		long[][] sum = new long[n][n];
		for(int i=0;i<n;i++)		
			sum[i][i] = array[i];			
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)			
				sum[i][j] = sum[i][j-1] + array[j];			
		}
		
		long max = sum[0][0];
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(sum[i][j]>max)
					max = sum[i][j];
			}
		}				
		
		return max;
	}
	
	public static long maxSubSumDP(int[] array) {
		//한번씩만 훑어보면 되기 때문에 memoization을 할 필요가 없다.
		int n = array.length;		
		long max = array[0];		
		
		for(int i=0;i<n;i++)
		{
			long sum = 0;
			for(int j=i;j<n;j++)
			{
				sum += array[j];
				if(sum>max)
					max = sum;
			}
		}
		return max;
	}

	public static long maxSubSumDivideAndConquer(int[] array) {			
		return doMaxSubSumDivideAndConquer(array,0,array.length-1);
	}

	private static long doMaxSubSumDivideAndConquer(int[] array, int l, int r) {
		if(l>r)
			return 0;
		
		if(l==r)			
			return array[l];	
		
		int m =(l+r)/2;
		long leftMaxSubSum = doMaxSubSumDivideAndConquer(array, l, m);
		long rightMaxSubSum = doMaxSubSumDivideAndConquer(array, m+1, r);
		
		long middleLeftSubSum = array[m];		
		long middleRightSubSum = array[m+1];
		long middleLeftMax = array[m];
		long middleRightMax = array[m+1]; 
		
		//compute middleLeftSubSum
		for(int i=m-1;i>=0;i--)
		{			
			middleLeftSubSum += array[i];
			if(middleLeftSubSum>middleLeftMax)
				middleLeftMax = middleLeftSubSum;
		}
		
		//compute middleRightSubSum
		for(int i=m+2;i<=r;i++)
		{			
			middleRightSubSum += array[i];	
			if(middleRightSubSum>middleRightMax)
				middleRightMax = middleRightSubSum;
		}
		
		long[] candidates = new long[] {leftMaxSubSum,rightMaxSubSum,middleLeftMax+middleRightMax};		
		
		return Util.max(candidates);
	}
	
	public static long maxSubSumLinear(int[] array) {
		long maxEndingHere = array[0];
		long maxSoFar = array[0];
		
		for(int i=1;i<array.length;i++)
		{
			if(maxEndingHere>=0)
				maxEndingHere += array[i];
			else
				maxEndingHere = array[i];
			
			maxSoFar = Util.max(new long[] {maxSoFar,maxEndingHere});
		}
		return maxSoFar;
	}
}

/*
 * 1.O(n^2) 알고리즘. (DP)
 * i,j 모두 [0,n-1] 범위이므로 DP를 사용하여 O(n^2) 에 가능함을 알 수 있다. (i<=j 임은 당연하다)
 * 다만 유의할 점은 이 경우에는 memoization을 하지 않아도 된다는 것이다.
 * 한번씩만 훑어보면서 (지금까지 계산된)max값과 비교하기만 하면 되기 때문이다.
 * memoization을 하게 될 경우 메모리 사용량이 n^2 이 되므로 좋지 않다.
 * 
 * 2.O(nlogn) 알고리즘. (Divide & Conquer)
 * array를 반으로 쪼개서 좌측,우측에서 각각 recursive하게 계산하고
 * sub array가 중간에 걸친 경우 (즉, array[m]과 array[m+1]을 반드시 포함하는 경우) 의 최대합을 구한다.
 * 이 중 가장 큰 것이 답이 된다.
 * T(n) = 2T(n/2) + O(n) 이므로 성능은 merge sort 와 마찬가지이므로 O(nlogn) 이 된다.
 * 
 * 3.O(n) 알고리즘. ( scanning alg. )
 * k와 k-1의 관계를 잘 살펴보자.
 * [0,k] 범위의 최대 부분합과 [0,k-1] 범위의 최대 부분합은 어떤 관계가 있을까.
 * maxSubSum[0,k] 에 array[k] 가 포함되느냐 아니냐가 중요하다.
 * array[k] 로 끝나는 sub array중 합이 최대인 것을 찾고 ( 이를 maxEnding(k) 라 하자) 
 * maxSubSum[0,k-1] 과 비교하여 둘 중 큰 것이 maxSubSum[0,k] 가 될 것이다.
 * 하지만 maxEnding(k) 를 계산하는 것이 O(n)이 된다면 
 * T(n) = T(n-1) + O(n) 이 되어 결국 O(n^2)의 성능이 되버린다.
 * 그렇다면 maxEnding(k) 를 O(1)에 가능하도록 해보자.
 * 
 * 역시 여기서도 DP를 사용하면 된다. 이미 계산된 값인 maxEnding(k-1)을 잘 활용하자.
 * maxEnding(k) = maxEnding(k-1) + array[k] ( maxEnding(k-1) >=0 )
 *                array[k] (maxEnding(k-1) < 0)
 * 위와 같이 계산하면 O(1) 시간에 maxEnding(k)를 계산할 수 있다. 
 */
