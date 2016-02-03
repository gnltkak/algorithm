package interview2;

public class _2012_05_19_Prob_1_18_FindKthSmallInUnion {
	public static int findKthSamllInUnion(int[] a, int[] b, int k) {
		return findKthSamllInUnion_NPlusM(a,b,k);
		/*
		int sl = 0, ll = 0;
		int sr = Math.min(a.length - 1, b.length - 1);
		int lr = Math.max(a.length - 1, b.length - 1);
		int[] large = a, small = b;
		if (b.length > a.length) {
			large = b;
			small = a;
		}
		
		while (true) {
			if (lr - ll == 0) { // 이 경우 sr-sl 도 0 이다.
				if (k == 1) return Math.min(large[ll], small[sl]);
				else if (k == 2) return Math.max(large[ll], small[sl]);
			}
			if ((lr - ll + 1) + (sr - sl + 1) == k) //종료 조건
				return Math.max(large[lr], small[sr]);
			
			int p = (ll + lr) / 2; // pivot index
			int s = findLargestSmallOrEqual(small, large[p]);
			int smallerOrEqualThanP_size = p - ll + 1;
			if (s >= 0) smallerOrEqualThanP_size += (s - sl + 1);
			if (k <= smallerOrEqualThanP_size) {
				if (s < 0) return large[ll + k - 1];
				lr = p;
				sr = s;
			} else {
				k -= smallerOrEqualThanP_size;
				if (s == sr) return large[p + k];
				ll = p + 1;
				if (s >= 0) sl = s + 1;
			}
			if (lr - ll < sr - sl) {
				int[] temp_arr = small;
				small = large;
				large = temp_arr;
				int temp = ll;
				ll = sl;
				sl = temp;
				temp = lr;
				lr = sr;
				sr = temp;
			}
		}
		*/
	}

	private static int findLargestSmallOrEqual(int[] small, int k) {
		return findLargestSmallOrEqual(small, k, 0, small.length - 1);
	}

	private static int findLargestSmallOrEqual(int[] small, int k, int l, int r) {
		if (l > r)
			return -1;
		int m = (l + r) / 2;
		if (small[m] > k)
			return findLargestSmallOrEqual(small, k, l, m - 1);
		else {
			int tryRight = findLargestSmallOrEqual(small, k, m + 1, r);
			if (tryRight != -1)
				return tryRight;
			return m;
		}
	}
	
	//////////////////////////////////////////////////////
	// O(m+n) solution
	private static int findKthSamllInUnion_NPlusM(int[] a, int[] b, int k) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (i + j + 1 == k)
				return Math.min(a[i], b[j]);
			if (a[i] < b[j]) ++i;
			else ++j;
		}
		
		if (i == a.length) return b[k - i - 1];
		return a[k - j - 1];
	}
}
