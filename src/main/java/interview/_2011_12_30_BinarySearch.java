package interview;

/*
 * input:
 *   sorted integer array(arr), integer number(num)
 */
public class _2011_12_30_BinarySearch {
	public static int binarySearchIterative(int[] arr, int num) {
		int l = 0;
		int r = arr.length - 1;
		int m = (l + r) / 2;
		
		while (l <= r) {
			if (arr[m] == num)
				return m;
			if (arr[m] < num)
				l = m + 1;
			else if (arr[m] > num)
				r = m - 1;
			
			m = (l + r) / 2;
		}
		
		return -1;
	}
}
