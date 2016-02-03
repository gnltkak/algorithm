package interview;

/*
 * input:
 *   integer array(size n)
 * 
 * find:
 *   minimum element & maximum element
 *   
 * constraint:
 *   비교 연산의 횟수가 2n보다 작아야 함
 */
public class _2011_12_31_MinMax {
	// "min,max" 의 형태로 값을 리턴함
	public static String minMaxNaive(int[] arr) {
		int min = getMin(arr);
		int max = getMax(arr);
		
		return min + "," + max;
	}
	
	private static int getMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] < min)
				min = arr[i];
		}
		
		return min;
	}

	
	private static int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > max)
				max = arr[i];
		}
		
		return max;
	}

	////////////////////////////////////////////////////
	
	// "min,max" 의 형태로 값을 리턴함
	public static String minMax(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return arr[0] + "," + arr[0];
		
		int[] upper = new int[n / 2];
		int[] lower = new int[n / 2];
		int u = 0, l = 0;
		
		for (int i = 0; i < n - 1; i += 2) {
			if (arr [i] > arr[i + 1]) {
				upper[u++] = arr[i];
				lower[l++] = arr[i + 1];
			} else {
				upper[u++] = arr[i + 1];
				lower[l++] = arr[i];
			}
		}
		
		int max = getMax(upper);
		int min = getMin(lower);
		
		if (n % 2 == 1) {
			if (arr[n - 1] > max)
				max = arr[n - 1];
			if (arr[n - 1] < min)
				min = arr[n - 1];
		}
		return min + "," + max;
	}
}

/*
 * naive 하게 하려면 min, max 각각 n번의 비교가 필요하다
 * 착안점은 2개의 원소를 비교하면(1회 비교) 최대,최소가 정해진다는 점이다.
 * 즉 n개의 원소를 2개씩 짝지어서 큰 그룹과 작은 그룹으로 나누고 (n/2 회의 비교)
 * 큰 그룹에서 naive 한 방법으로 max를 뽑고 (n/2 회의 비교)
 * 작은 그룹에서 naive 한 방법으로 min을 뽑으면 (n/2 회의 비교) 된다.
 * n이 홀수인 경우만 예외로 처리해주면 끝.
 */
