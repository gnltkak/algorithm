package interview;

/*
 * input : integer n
 * find : n이 power of 2 인지 찾기
 */
public class _2011_01_28_PowerOf2 {
	public static boolean isPowerOf2(int num) {
		return num>0 && ( (num & (num-1)) == 0);
	}
}

/*
 * 이 문제에서 주의 할 점은 역시 binary case 이다.
 * num이 음수일때와 0일때를 주의하도록 하자.
 */
