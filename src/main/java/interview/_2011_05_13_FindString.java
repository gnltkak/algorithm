package interview;

/*
 * input : 중간중간에 empty string이 삽입된 sorted string array
 *         key ( string )
 * find : string array에서 key의 index를 찾기 ( 없으면 -1 리턴 )
 */
public class _2011_05_13_FindString {
	//assumption : arr is not null, key is not null or empty string
	public static int findString(String[] arr,String key) {
		return doFindString(arr,key,0,arr.length-1);
	}

	private static int doFindString(String[] arr, String key, int l, int r) {
		if(l>r)
			return -1;
		
		int m = (l+r)/2;
		int m2 = m;
		while(m2<=r && arr[m2].equals(""))
			m2++;
		
		if(m2>r)
			return doFindString(arr,key,l,m-1);
		
		if(key.equals(arr[m2]))		
			return m2;
		if(key.compareTo(arr[m2])>0)
			return doFindString(arr,key,m2+1,r);
		if(key.compareTo(arr[m2])<0)
			return doFindString(arr,key,l,m-1);
		
		return -2; //never reach here
	}
}
