package interview2;

public class _2012_05_19_Prob1_22_SalaryDecrease {
	public static int findSalaryUpperBound(int[] s, int wanna_be_sum) {
		int n = s.length;
		if (n == 1) {
			if (s[0] >= wanna_be_sum) return wanna_be_sum;
			else return -1;
		}
		accSumArr = new int[n];
		accSumArr[0] = s[0];
		for (int i = 1; i < n; ++i)
			accSumArr[i] = accSumArr[i - 1] + s[i];
		
		int k = find_search_start_index(s, wanna_be_sum);
		return findSalaryUpperBound(s, k, wanna_be_sum);
		
	}

	private static int findSalaryUpperBound(int[] s, int k, int wanna_be_sum) {
		int l = s[k];
		int r  = s[k + 1];
		while (r - l > 1) {
			int m = (l + r) / 2;
			int snew = accSum(k) + (s.length - 1 - k)*m;
			if (snew == wanna_be_sum) return m;
			else if (snew > wanna_be_sum) r = m;
			else l = m;
		}
		if (accSum(k) + (s.length - 1 - k) * l == wanna_be_sum)
			return l;
		if (accSum(k) + (s.length - 1 - k) * r == wanna_be_sum)
			return r;
		return -1;
	}	

	private static int find_search_start_index(int[] s, int wanna_be_sum) {
		return find_search_start_index(s, wanna_be_sum, 0, s.length - 1);
	}

	private static int find_search_start_index(int[] s, int wanna_be_sum,
			int l, int r) {
		int m = (l + r) / 2;
		int snew_first = accSum(m) + (r - m) * s[m];
		int snew_second = accSum(m + 1) + (r - m - 1) * s[m + 1];
		if (snew_first <= wanna_be_sum && wanna_be_sum <= snew_second)
			return m;
		else if (snew_first > wanna_be_sum) {
			if (r - l == 1) return -1;
			return find_search_start_index(s, wanna_be_sum, l, m);
		}
		else
			return find_search_start_index(s, wanna_be_sum, m + 1, r);
	}
	
	private static int accSum(int k) {
		return accSumArr[k];
	}
	private static int[] accSumArr;
}
