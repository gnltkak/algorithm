package interview2;

public class _2012_08_02_RegexMatch {
	public static boolean match(String s, String r) {
		return match(s, r, 0, 0);
	}

	// invariant: i는 *을 가리키지 않는다.
	private static boolean match(String s, String r, int i, int j) {
		if (j == r.length()) return i == s.length();
		if (i == s.length()) return (j == r.length()) || (j == r.length() - 2 && r.charAt(j + 1) == '*');
		
		char sch = s.charAt(i);
		char rch = r.charAt(j);
		
		if (rch != '.' && rch != '*') {
			if (j == r.length() - 1) return (sch == rch) && (i == s.length() - 1);
			if (r.charAt(j + 1) != '*') return (sch == rch) && match(s, r, i + 1, j + 1);
			if (match(s, r, i, j + 2)) return true;
			int k = i;
			while (k < s.length() && s.charAt(k) == rch) {
				if (match(s, r, k + 1, j + 2)) return true;
				++k;
			}
		} else if (rch == '.') {
			if (j == r.length() - 1) return i == s.length() - 1;
			if (r.charAt(j + 1) != '*') return match(s, r, i + 1, j + 1);
			if (match(s, r, i, j + 2)) return true;
			int k = i;
			while (k < s.length()) {
				if (match(s, r, k + 1, j + 2)) return true;
				++k;
			}
		}
		
		return false;
	}
}
