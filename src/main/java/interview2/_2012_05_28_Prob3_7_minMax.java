package interview2;

public class _2012_05_28_Prob3_7_minMax {
	public static int minMax(int[] a, int[] b) {
		return minMaxNew(a, b);
		
		/*
		int n = a.length;
		if (a[0] >= b[0]) return a[0];
		if (b[n - 1] >= a[n - 1]) return b[n - 1];
		
		int leftR = leftRmost(a, b, 0, n - 1);
		int rightL = rightLmost(a, b, 0, n - 1);
		
		return Math.min(b[leftR], a[rightL]);
		*/
	}

	private static int leftRmost(int[] a, int[] b, int l, int r) {
		if (l > r) return -1;
		int m = (l + r) / 2;
		if (a[m] == b[m]) return m;
		else if (a[m] > b[m])
			return leftRmost(a, b, l, m - 1);
		else {
			int tryRight = leftRmost(a, b, m + 1, r);
			if (tryRight == -1) return m;
			else return tryRight;
		}
	}

	private static int rightLmost(int[] a, int[] b, int l, int r) {
		if (l > r) return -1;
		int m = (l + r) / 2;
		if (a[m] == b[m]) return m;
		else if (a[m] < b[m])
			return rightLmost(a, b, m + 1, r);
		else {
			int tryLeft = rightLmost(a, b, l, m - 1);
			if (tryLeft == -1) return m;
			else return tryLeft;
		}
	}
	
	/////////////////////////////////////////////////////////////////
	private static int minMaxNew(int[] a, int[] b) {
		int n = a.length;
		if (a[0] >= b[0]) return a[0];
		if (a[n - 1] <= b[n - 1]) return b[n - 1];
		
		return minMaxNew(a, b, 0, n - 1);
	}

	private static int minMaxNew(int[] a, int[] b, int l, int r) {
		if (l == r) return a[l];
		if (r - l == 1)
			return Math.min(Math.max(a[l], b[l]), Math.max(a[r], b[r]));
		
		int m = (l + r) / 2;
		if (a[m] == b[m]) return a[m];
		if (a[m] < b[m]) return minMaxNew(a, b, m, r);
		return minMaxNew(a, b, l, m);
	}
}
