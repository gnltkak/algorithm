package interview;

/*
 * set의 모든 subset을 찾는 문제이다. O(2^n) 임이 자명하다.
 * 2011_01_21_Combination과 동일하다.
 * 그냥 연습삼아 또 구현해보았다 -_-
 */
public class _2011_01_29_AllSubset {
	private static StringBuffer result;
	
	public static String allSubset(int[] arr) {
		result = new StringBuffer();		
		
		for(int k=0;k<=arr.length;k++)
			kSubset(arr,k);
		
		return result.toString();
	}

	private static void kSubset(int[] arr, int k) {
		boolean[] used = new boolean[arr.length];
		doKSubset(arr,used,k,0);		
	}

	private static void doKSubset(int[] arr, boolean[] used,int k, int s) {
		if(k==0)
		{			
			result.append('{');
			for(int i=0;i<used.length;i++)				
			{				
				if(used[i])
				{
					result.append(arr[i]);
					result.append(',');
				}				
			}	
			//맨뒤 , 를 삭제
			if(result.charAt(result.length()-1)==',')
				result.deleteCharAt(result.length()-1);
			result.append('}');
			result.append('\n');
			return;
		}
		
		for(int i=s;i<=arr.length-k;i++)
		{
			used[i] = true;
			doKSubset(arr, used, k-1, i+1);
			used[i] = false;
		}
	}
}
