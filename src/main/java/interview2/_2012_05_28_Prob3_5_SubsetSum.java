package interview2;

public class _2012_05_28_Prob3_5_SubsetSum {
	public static boolean subsetExist(int[] arr, int s) {
		int n = arr.length;
		boolean[][] subsol = new boolean[n][s + 1];
		for (int j = 1; j <= s; ++j)
			subsol[0][j] = (arr[0] == j);
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j<=s; ++j) {
				subsol[i][j] = (arr[i] == j) || subsol[i - 1][j];
				if (j - arr[i] > 0)
					subsol[i][j] = subsol[i][j] || subsol[i - 1][j - arr[i]];
			}
		}
		return subsol[n - 1][s];
	}
}
