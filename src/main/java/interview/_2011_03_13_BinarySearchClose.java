package interview;

/*
 * sorted integer array, integer k 가 주어졌을때
 * array에서 k와 가장 가까운 숫자를 찾는다.
 */
public class _2011_03_13_BinarySearchClose {
	public static int bSearchClosest(int[] arr,int key) {
		return arr[doBSearchClosest(arr,key,0,arr.length-1)];
	}	
	
	private static int doBSearchClosest(int[] arr, int key, int l, int r) {		
		if(l==r) //원소의 개수가 1개
			return l;
		if(r-l==1) //원소의 개수가 2개
		{
			if(Math.abs(key-arr[l]) < Math.abs(key-arr[r]))
				return l;
			else
				return r;
		}
		
		int m = (l+r)/2;	
		
		if(key==arr[m])
			return m;
		if(key<arr[m])
			return doBSearchClosest(arr,key,l,m);
		if(key>arr[m])
			return doBSearchClosest(arr,key,m,r);
		
		return -1; //never reach here!
	}
}

/*
 * 원소의 개수가 작은 경우를 잘 따져봐야 한다. boundary case!!
 */
