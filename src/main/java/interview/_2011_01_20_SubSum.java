package interview;

/*
 * input : integer array
 * find : i...j 까지의 합 ( i<=j , i,j는 [0,n-1] 범위, n은 array의 size )
 */
public class _2011_01_20_SubSum {
	public static long subSumNaive(int[] array, int i, int j) {
		long sum = 0;
		for(int k=i;k<=j;k++)
			sum += array[k];
		
		return sum;
	}

	public static long subSum(int[] array, int i, int j) {
		//전처리 : O(n)
		long[] sum = new long[array.length];
		sum[0] = array[0];
		for(int k=1;k<array.length;k++) {			
			sum[k] = sum[k-1] + array[k];
		}
		
		//lookup : O(1)
		if(i==0)
			return sum[j];
		return sum[j]-sum[i-1];		
	}
}

/*
 * 1.O(n) : 그냥 루프돌면된다.
 * 2.<O(n),O(1)> : 전처리는 O(n), lookup은 O(1)
 * 이것도 매우 쉽지만.... 정말로 조심해야 할 것은 boundary case 이다.
 * i가 0인 경우를 조심해야 한다. 
 * (index에 +1 -1 등이 되는 경우는 항상 조심하자!)
 */
