package interview2;

import java.util.HashSet;

public class _2012_05_28_Prob3_4_StringDecomposition {
	public static String decomposition(String str, HashSet<String> dic) {
		int[] subsolution = new int[str.length()];
		for (int i = 0; i < subsolution.length; ++i)
			subsolution[i] = -1;
		String[] subsolutionStr = new String[str.length()];
		return decomposition(str, dic, subsolution, subsolutionStr, 0);
	}

	private static String decomposition(String str, HashSet<String> dic,
			int[] subsolution, String[] subsolutionStr, int start) {
		if (subsolution[start] != -1) {
			if (subsolution[start] == 0) return null;
			return subsolutionStr[start];
		}
		for (int i = start; i < str.length(); ++i) {
			String head = str.substring(start, i + 1);
			if (!dic.contains(head)) continue;
			if (i == str.length() - 1) {
				subsolutionStr[start] = head;
				subsolution[start] = 1;
				return head;
			}
			String subresult = decomposition(str, dic, subsolution, subsolutionStr, i + 1);
			if (subresult == null) continue;
			subsolutionStr[start] = head + " " + subresult;
			subsolution[start] = 1;
			return subsolutionStr[start];
		}
		subsolutionStr[start] = null;
		subsolution[start] = 0;
		return null;
	}
}
