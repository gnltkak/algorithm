package interview;

/*
 * input:
 *   integer array(size n), integer k(0 <= k < n)
 * find:
 *   array에서 k번째 수만 제외한 모든 수의 곱을 계산
 * example:
 *   array = {6, 1, 4, 10} 
 *   k = 2
 *   답은 6 * 1 * 10 = 60
 */
public class _2011_12_30_MultipleExceptOne {
	public static long multipleExceptOneNaive(int[] arr, int k) {
		if (arr.length == 1)
			throw new RuntimeException();
		
		long multiple = 1;
		for (int i = 0; i < arr.length; ++i) {
			if (i == k)
				continue;
			
			multiple *= arr[i];
			if (multiple == 0)
				break;
		}
		return multiple;
	}
	
	///////////////////////////////////////////////////////////////
	public static long multipleExceptOne1(int[] arr, int k) {
		if (arr.length == 1)
			throw new RuntimeException();
		
		long[] leftAccMultiple = buildLeftAccMultiple(arr);
		long[] rightAccMultiple = buildRightAccMultiple(arr);

		long leftElement = 1;
		if (k > 0)
			leftElement = leftAccMultiple[k - 1];
		long rightElement = 1;
		if (k < arr.length - 1)
			rightElement = rightAccMultiple[k + 1];
		
		return leftElement * rightElement;
	}

	private static long[] buildLeftAccMultiple(int[] arr) {
		int n = arr.length;
		long[] accMultiple = new long[n];
		accMultiple[0] = arr[0];
		for (int i = 1; i < n; ++i) {
			accMultiple[i] = accMultiple[i - 1] * arr[i];
		}
		return accMultiple;
	}
	
	private static long[] buildRightAccMultiple(int[] arr) {
		int n = arr.length;
		long[] accMultiple = new long[n];
		accMultiple[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			accMultiple[i] = accMultiple[i + 1] * arr[i];
		}
		return accMultiple;
	}
	
	/////////////////////////////////////////////////////////////
	public static long multipleExceptOne2(int[] arr, int k) {
		int zeroCount = 0, zeroPos = -1;
		long zeroOmittedMultiple = 1;		
		int n = arr.length;
		
		for (int i = 0; i < n; ++i) {
			if (arr[i] == 0) {
				++zeroCount;
				zeroPos = i;
			} else {
				zeroOmittedMultiple *= arr[i];
			}
		}
		
		if (zeroCount == 0) {
			long leftElement = 1;
			if (k > 0)
				leftElement = getSubMultiple(arr, 0, k - 1);
			long rightElement = 1;
			if (k < arr.length - 1)
				rightElement = getSubMultiple(arr, k + 1, n - 1);
			return  leftElement * rightElement;
		} else if (zeroCount == 1) {
			if (k != zeroPos)
				return 0;
			else
				return zeroOmittedMultiple;
		} else if (zeroCount >= 2) {
			return 0;
		}
		throw new RuntimeException();
	}

	private static long getSubMultiple(int[] arr, int i, int j) {
		long[] leftAccMultiple = buildLeftAccMultiple(arr);
		if (i == 0)
			return leftAccMultiple[j];
		if (leftAccMultiple[i - 1] == 0)
			throw new RuntimeException();
		return leftAccMultiple[j] / leftAccMultiple[i - 1];
	}
}

/*
 * 1. naive: O(n)
 * 그냥 k번째 수만 skip 하고 다 곱하면 된다.
 * 
 * 2. 전처리를 해서 계산을 O(1)로 만들어보자
 * i..j 의 곱을 계산할 수 있으면 되니까 누적곱 array를 만들면 된다.
 * 그런데 문제가 있다. 누적곱 array로 i..j의 곱을 계산할 때 
 * accMultiple[j] / accMultiple[i-1] 로 계산하는데 divider가 0일 수 있기 때문이다.
 * 그렇다면 divider가 0인 경우만 따로 처리할 것인가? 어떻게? 
 * 
 * 3. 위의 생각을 좀 더 발전시켜 보자
 * 0...k-1 k k+1...n-1 에서
 * 0...k-1 의 곱에 k+1...n-1의 곱을 곱하면 된다.
 * 0...k-1 은 좌측부터 계산한 누적곱 array로 나눗셈 연산 없이 쉽게 계산 가능하고
 * k+1...n-1 은 우측부터 비슷하게 우측부터 계산한 누적곱 array로 계산하면 된다.
 * (이 때 우측누적곱 array의 i번째 원소가 무엇을 의미하는지 잘 생각해야 구현시 햇갈리지 않는다)
 * 
 * 이렇게 구현하면 전처리에 O(n)(정확히 2n)의 시간과 2n의 공간이 든다.
 * 
 * 3. 여기서 2n의 공간소모를 보다 줄여볼 수 있을까?
 * 0이 한번 나오면 그 이후의 곱은 모조리 0이 된다. 
 * 그럼 0이 나오기 전까지만 누적곱을 저장하면 되는데 구현이 좀 복잡해진다. 더 쉬운 방법은 없을까?
 * 0을 중심으로 다시 생각해보자.
 * array에 0이 하나도 없다면 좌측누적곱만 있으면 되므로 공간소모가 n 이다
 * array에 0이 2개 이상 있다면 k가 무엇이든 간에 답이 0이 된다.
 * array에 0이 1개 있다면 k가 그 0의 index가 아니면 답이 0이고 그렇지 않으면 0을 제외한 값들의 곱이 된다.
 * 
 * 그러니까 0의 개수를 count 하면 전처리 시간이 좀 더 걸리지만 공간소모는 n으로 줄일 수 있다.
 */