package interview;

import java.util.Random;

import util.Util;

/*
 * integer array에서 k번째 작은 수를 찾는다.
 * array의 size가 n일때, k의 범위는 [1,n] 이다. 
 */
public class _2011_03_14_KthSmall {
	public static int kthSmall(int[] arr,int k) {
		if(!(k>=1 && k<=arr.length))
			throw new RuntimeException("k의 범위가 잘못되었습니다.");	
		
		Random rand = new Random();
		return doKthSmall(arr,k,0,arr.length-1,rand);
	}

	private static int doKthSmall(int[] arr, int k, int l, int r, Random rand) {		
		int p = partition(arr,l,r,rand);
		int pIndex = p-l+1; //arr[p] 가 arr[l,r] 에서 몇번째로 작은가.
		
		if(k==pIndex)
			return arr[p];
		if(k<pIndex)
			return doKthSmall(arr, k, l, p-1, rand);
		return doKthSmall(arr,k-pIndex, p+1, r, rand);
	}

	private static int partition(int[] arr, int l, int r, Random rand) {
		int p = rand.nextInt(r-l+1)+l;
		Util.swap(arr, l, p);
		int pivot = arr[l];
		
		int u = l+1;
		int ls = l+1;
		
		while(u<=r)
		{
			if(arr[u]<=pivot)
			{
				Util.swap(arr,ls,u);
				ls++;
			}
			u++;
		}
		Util.swap(arr,l,ls-1);
		return ls-1;
	}
}

/*
 * 이렇게 안하고 bitmap 쓰면 훨씬 간단하고 빠르지 않나.. 
 * _2011_05_10_LinearSelection 이랑 같은 문제인데 왜 해놨지
 */
