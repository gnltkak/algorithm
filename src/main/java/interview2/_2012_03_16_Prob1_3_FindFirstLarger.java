package interview2;

public class _2012_03_16_Prob1_3_FindFirstLarger {
	public static int findFirstLarger(int[] arr, int k) {
		return findLarger(arr, k, 0, arr.length - 1);
	}

	private static int findLarger(int[] arr, int k, int l, int r) {
		if (l > r) return -1;
		int m = l + (r - l)/2;
		if (arr[m] <=k ) return findLarger(arr, k, m+1, r);
		else {
			int tryLeft = findLarger(arr, k, l, m-1);
			if (tryLeft == -1) return m;
			else return tryLeft;
		}
	}
	
	////////////////////////////////////////////////
	public static int findFirstLarger2(int[] arr, int k) {
        if (arr[arr.length - 1] <= k) return -1;
		return findLarger2(arr, k, 0, arr.length - 1);
	}

	private static int findLarger2(int[] arr, int k, int l, int r) {
        if (l == r) return l;
        
		int m = (l + r) / 2;
		if (arr[m] <= k ) return findLarger2(arr, k, m + 1, r);
		else return findLarger2(arr, k, l, m);			
	}
}
