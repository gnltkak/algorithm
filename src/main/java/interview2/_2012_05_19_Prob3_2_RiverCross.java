package interview2;

public class _2012_05_19_Prob3_2_RiverCross {
	// Precondition: size of stone is w + 1
	public static boolean reachable(boolean[] stone) {
		int w = stone.length - 1;
		int[][] sub = new int[w][w];
		for (int i = 0; i < w; ++i) {
			for (int j = 0; j < w; ++j)
				sub[i][j] = -1;
		}
		return reachable(stone, sub, 0, 1, w);
	}

	private static boolean reachable(boolean[] stone, int[][] sub, int curr,
			int jump, int w) {
		if (curr + jump > w) return true;
		if (curr + jump == w) return !stone[w];
		if (sub[curr][jump] == 0) return false;
		else if (sub[curr][jump] == 1) return true;
		if (stone[curr + jump]) return false;
		
		boolean try1 = false, try2 = false, try3 = false;
		if (jump - 1 > 0)
			try1 = reachable(stone, sub, curr + jump, jump - 1, w);
		if (jump > 0)
			try2 = reachable(stone, sub, curr + jump, jump, w);
		if (jump + 1> 0)
			try3 = reachable(stone, sub, curr + jump, jump + 1, w);
		boolean result = try1 || try2 || try3;
		if (result)
			sub[curr][jump] = 1;
		else
			sub[curr][jump] = 0;
		return result;
	}
}
