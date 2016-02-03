package interview;

/*
 * input : k번(주어지지 않음) rotation 된 sorted integer array ( size=n, 0<=k<=n)
 *         key(integer)
 *         모든 원소는 distinct 하다. (몇몇 test case가 잘못되었음)
 * find : array에 key가 존재하면 그 index를, 존재하지 않으면 -1을 리턴
 */
public class _2011_05_09_ItemInRotatedArr {
	public static int findItem(int[] arr,int key) {
		return doFindItem2(arr,key,0,arr.length-1);
	}
	
	private static int doFindItem(int[] arr,int key,int l,int r) {		
		if(l==r) //원소의 개수가 1개
		{
			if(arr[l]==key)
				return l;
			return -1;
		}
		if(r-l==1) //원소의 개수가 2개
		{
			if(arr[l]==key)
				return l;
			if(arr[r]==key)
				return r;
			return -1;
		}
		
		int m = (l+r)/2;
		
		if(key==arr[m])
			return m;
		
		if(arr[m]==arr[r])
			return doFindItem(arr,key,l,m-1);		
		else if(arr[m]>arr[r])
		{
			if(key>arr[m])
				return doFindItem(arr,key,m+1,r);
			else
			{
				if(key<arr[l])
					return doFindItem(arr,key,m+1,r);
				else
					return doFindItem(arr,key,l,m-1);
			}	
		}
		else
		{
			if(key>arr[m])
			{
				if(key>arr[r])
					return doFindItem(arr,key,l,m-1);
				else
					return doFindItem(arr,key,m+1,r);				
			}
			else
				return doFindItem(arr,key,l,m-1);
		}
	}
	
	private static int doFindItem2(int[] arr,int key,int l,int r) {	
		if (l > r)
			return -1;
		
		int m = (l + r) / 2;
		if (key == arr[m])
			return m;
		if (arr[m] > arr[r]) {
			if (key < arr[m] && key >= arr[l])
				return doFindItem2(arr, key, l, m - 1);
			return doFindItem2(arr, key, m + 1, r);
		} else {
			if (key > arr[m] && key <= arr[r])
				return doFindItem2(arr, key, m + 1, r);
			return doFindItem2(arr, key, l, m -1);
		}
	}
}

/*
 * binary search를 변형하면 된다. 성능은 O(logn) 이다.
 * m 을 기준으로 어느 한쪽을 버려야 한다는 것을 늘 명심하자.
 * 
 * 그리고 arr[m] 이 arr[r]과 같은 경우도 명심하자!
 * 
 * 내가 풀어본 binary search 문제중에는 가장 어려운듯. 
 * 
 * --------------------------------------------
 * 
 * 두번째 구현이 좀 더 깔끔하다. (알고리즘은 같음)
 * arr[m] == arr[r] 인 경우를 따로 뗄 필요가 없음..
 */
