package interview;

import util.Util;

/*
 * input : integer array
 * find : k번째 작은 수(0 based)의 index
 */

public class _2011_05_10_LinearSelection {
	public static int kthSmall(int[] arr,int k) {
		return doKthSmall(arr,k,0,arr.length-1);
	}

	private static int doKthSmall(int[] arr, int k, int l, int r) {
		if(l==r) //원소의 개수가 1개
			return l;
		
		int p = partition(arr,l,r);
		int pivotSmallIndex = p - l; //pivot 이 [l,r]에서 몇번째로 큰지를 나타냄(0 based)
		
		if(k==pivotSmallIndex)
			return p;
		if(k<pivotSmallIndex)
			return doKthSmall(arr,k,l,p-1);
		if(k>pivotSmallIndex)
			return doKthSmall(arr,k-pivotSmallIndex-1,p+1,r);
		
		return -1; //never reach here
	}

	private static int partition(int[] arr, int l, int r) {
		int u = l+1;
		int s = l;
		int pivot = arr[l];
		
		while(u<=r)
		{
			if(arr[u]<pivot)
			{
				s++;
				Util.swap(arr, s, u);
			}
			u++;
		}
		Util.swap(arr, l,s);
		return s;
	}
}
