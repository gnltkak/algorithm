package interview;

/*
 * input : integer array , integer k (원소는 distinct)
 * find : array 에서 k개의 원소를 선택하여 만들 수 있는 모든 combination
 * (0<= k <= array.length)
 */
public class _2011_01_21_Combination {
	private static StringBuffer result;
	
	//precondition : 0<= k <= array.length 
	public static String makeCombination(int[] array,int k) {
		result = new StringBuffer();
		boolean[] used = new boolean[array.length];
		doMakeCombination(array,k,0,used);		
		return result.toString();
	}

	//precondition : 0<= k <= array.length 
	private static void doMakeCombination(int[] array, int k, int start,boolean[] used) {
		int n = array.length;
		
		if(k==0)
		{
			for(int i=0;i<n;i++)
			{				
				if(used[i])
				{
					result.append(array[i]);
					result.append(",");
				}
			}
			if(result.length()>0)
			{
				result.deleteCharAt(result.length()-1); //맨뒤의 , 를 삭제
				result.append('\n');
			}
			return;
		}
		
		for(int i=start;i<=n-k;i++)
		{
			used[i] = true;
			doMakeCombination(array, k-1, i+1, used);
			used[i] = false;
		}
	}
	
	public static String makeCombination2(int[] arr, int k) {
        result = new StringBuffer();
        boolean[] used = new boolean[arr.length];
        doMakeCombination2(arr, 0, k, used);
        return result.toString();
	}

    private static void doMakeCombination2(int[] arr, int l, int k, boolean[] used) {
        int n = arr.length;
        if (k == 0) {
            for(int i = 0; i < n; ++i) {
                if (used[i]) {
                    result.append(arr[i]);
                    result.append(",");
                }
            }
            if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1); //맨뒤의 , 를 삭제
                result.append('\n');
            }
            return;
        }
        
        if (l == n) return;
        
        used[l] = true;
        doMakeCombination2(arr, l + 1, k - 1, used);
        used[l] = false;
        doMakeCombination2(arr, l + 1, k, used);
    }
}

/*
 * 딱히 재기발랄한[?] 최적화를 할 수 있는 문제는 아닌 것 같다.
 * 하지만 구현하는 연습을 한다는 데에 의미가 있다.
 * combination을 손으로 만드는 과정을 그대로 시뮬레이션 하면 된다.
 * 위의 구현에서 i(41라인)의 최대값이 start 에 영향을 받지 않는다는 점에 유의하자.
 * (그림을 그려 생각해보면 쉽다.) 
 * 
 * (추가) 2011-01-29
 * 위 구현에서 used[] 에 bitmap을 쓴다면 추가 메모리 사용량을 약 8분의1로 낮출수 있다.
 * 
 * 위 구현보다 훨씬 간단한 구현이 있는데, 추가메모리 사용은 동일하지만 구현이 초 간단하다.
 * used 가 boolean 값이므로 used[] 를 binary string 으로 보는 것이다.
 * 따라서 integer를 사용하여 값을 1씩 증가시키면서 이것을 used[] 로 취급하면 된다.
 * 단, 이쁜 순서[?]로 출력되지 않는다는 단점이 있다.
 * integer 값에 따라 다음과 같은 순서로 나올 것이다.
 * {} {0} {1} {0,1} {2} {0,2} ... ( 0 1 01 10 11 100 101 )
 * integer를 사용하면 input size 가 32가 넘는 것은 처리하지 못하므로
 * ( 사실 2^32 정도만 해도 엄청나게 큰 수이므로 충분할듯 싶지만... )
 * bitmap을 사용하면 input size에 무관하게 처리할 수 있다.
 * (단, bitmap에 +1 하는 연산을 추가해야 한다)
 * bitmap 까지 쓰지 않더라도 long을 사용하면 64개는 되니까 충분하다고 생각한다.
 * 
 * (추가) 2016-02-08
 * 보다 직관적인 알고리즘 추가
 */
