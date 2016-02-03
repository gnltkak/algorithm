package interview;

import util.Util;

/*
 * input : integer array(원소는 distinct)
 * find : array의 원소들로 만들 수 있는 모든 permutation
 */
public class _2011_01_21_Permutation {
	private static StringBuffer sb;
	
	public static String makePermutation(int[] array) {
		sb = new StringBuffer();
		doMakePermutation(array,0);
		return sb.toString();
	}

	//precondition : start<=array.length-1
	private static void doMakePermutation(int[] array, int start) {
		if(start==array.length-1)
		{
			sb.append(Util.arrayToString(array, ","));
			sb.append('\n');
			return;
		}		
		
		for(int i=start;i<array.length;i++)
		{
			int temp = array[start];
			array[start] = array[i];
			array[i] = temp;
			
			doMakePermutation(array,start+1);
			
			temp = array[start];
			array[start] = array[i];
			array[i] = temp;
		}
	}
	
	/////////////////////////////////////////////////
	
	public static String perm(int[] arr,int k) {
		sb = new StringBuffer();		
		doPerm(arr, 0, k);
		return sb.toString();
	}
	
	private static void doPerm(int[] arr, int p, int k) {
		if (p == k) {
			for (int i = 0; i < p; ++i) {
				sb.append(arr[i]);
				if (i < p - 1)
					sb.append(",");
			}
			sb.append("\n");
			return;
		}
		
		int n = arr.length;
		for (int i = p; i < n; ++i) {
			Util.swap(arr, p, i);
			doPerm(arr, p + 1, k);
			Util.swap(arr, p, i);
		}
	}	
}

/*
 * 매우 쉽다.
 * combination 보다 더 쉽다.
 * 만약 k개를 뽑아서 permutation을 만들라고 한다면
 * combination 으로 우선 k개를 뽑은 뒤에 이 함수를 쓰면 될 것이다. 
 * 
 * (추가)
 * k개를 뽑아서 permutation을 만드는 것은 매우 간단하다.
 * 조건문 하나만 넣어주면 된다.
 */
