package interview2;

public class _2012_03_16_Prob1_4_FindSameWithValue {
	public static int findSameWithValue(int[] arr) {
		return findSameWithValue(arr, 0, arr.length - 1);
	}

	private static int findSameWithValue(int[] arr, int l, int r) {
		if (l > r) return -1;
		int m = l + (r - l)/2;
		if (arr[m] == m) return m;
		else if (arr[m] > m) return findSameWithValue(arr, l, m - 1);
		else return findSameWithValue(arr, m + 1, r);
	}
}
