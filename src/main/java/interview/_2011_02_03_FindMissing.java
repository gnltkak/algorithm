package interview;

import java.util.ArrayList;

/*
 * input : integer array ( size = n, 각 원소의 범위는 [0,n] 이고 distinct 함)
 * find : [0,n] 중 array에 포함되지 않은 단 1개의 원소를 O(n)에 찾기
 * constraint : array의 i번째 원소를 임의로 접근할 수 없고,
 *              array의 i번째 원소의 j번째 bit를 get 하는 것만 가능하다.(이 연산은 O(1) 이다 )
 */
public class _2011_02_03_FindMissing {
	public static int findMissing(int[] arr) {
		return findMissing2(arr);
		
		/*
		int[] count = new int[arr.length+1];
		for(int i=0;i<arr.length;i++)
		{
			int num = 0;
			for(int j=0;j<32;j++)
				num += getBit(arr,i,j)<<j;
			count[num]++;
		}
		
		for(int i=0;i<count.length;i++)
		{
			if(count[i]==0)
				return i;
		}		
		
		throw new RuntimeException("arr 가 올바르지 않은 것 같습니다.");
		*/
	}

	private static int getBit(int[] arr, int i, int j) {
		int num = arr[i];
		if((num&(1<<j)) == 0)
			return 0;
		else
			return 1;
	}
	
	///////////////////////////////////////////////////////
	public static int findMissing2(int[] arr) {
		ArrayList<Integer> zero = new ArrayList<Integer>();
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> source = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			source.add(i);
		}
		
		int k = 0;
		int result = 0;
		while (k < 32) {
			split(arr, k, source, zero, one);
			source.clear();
			
			if (one.size() < zero.size()) {
				result += 1<<k;
				source.addAll(one);
			} else {
				source.addAll(zero);
			}				
		
			if (one.size() == 0 || zero.size() == 0)
				break;
			
			zero.clear();
			one.clear();
			++k;
		}
		return result;
	}

	private static void split(int[] arr, int k, ArrayList<Integer> source,
			ArrayList<Integer> zero, ArrayList<Integer> one) {		
		for (int i = 0; i < source.size(); ++i) {
			int index = source.get(i);
			if (getBit(arr, index, k) == 0)
				zero.add(index);
			else
				one.add(index);
		}		
	}
}

/*
 * 1. O(kn) k=32
 * [0,n]에는 n+1개의 정수가 있고 array 의 size는 n 이니 단 한개의 숫자가 비게 된다.
 * 그냥 숫자를 만들어서 카운팅 하면 땡이다..(혹은 bitmap 사용)
 * 
 * 2. k=32가 마음에 들지 않는다. 게다가 32bit가 넘는 범위의 integer도 cover하고 싶다.
 * 그렇다면 반씩 쪼개서 봐야 하는 범위를 점점 줄여나가는 방법을 써보자.
 * 1) n이 홀수일 때 [0, n] 의 LSB를 보면 0인 것의 개수와 1인 것의 개수가 같다.
 *    이 중 한개의 숫자를 빼버렸다면 개수가 맞지 않게 되고 빠진 숫자는 개수가 더 적은 쪽의 LSB를 가진다.
 *    예를 들어, n=3 이고 1을 빼버렸다면
 *    0 (00) 
 *    1 (01)*
 *    2 (10)
 *    3 (11)
 *    LSB가 0인 수는 2개, 1인 수는 1개가 되므로 빠진 숫자의 LSB는 1이 된다는 것이다.
 *    LSB가 0인 2를 빼버렸다고 해도 같은 로직을 적용할 수 있다.
 * 2) n이 짝수일 때 [0, n] 의 LSB를 보면 0인 것의 개수 = 1인 것의 개수 + 1 이다.
 *    예를 들어, n = 4 라면
 *    0 (000)
 *    1 (001)
 *    2 (010)
 *    3 (011)
 *    4 (100)
 *    LSB가 0인 수는 3개, 1인 수는 2개이다.
 *    여기서 1과 같은 LSB가 1인 수를 빼면 LSB가 0인 수는 3개, 1인 수는 1개가 되고
 *    2와 같은 LSB가 0인 수를 빼면 LSB가 0인 수는 2개, 1인 수는 2개가 된다.
 *    즉 LSB가 1인 수를 뺀 경우는 n이 홀수일때와 같은 로직을 적용 가능하고
 *    LSB가 0인 수와 1인 수의 개수가 같으면 빠진 수는 LSB가 0임을 알 수 있다.
 *    
 * 정리하자면, n이 홀수인지 짝수인지에 관계없이 
 * LSB가 0인 수의 개수를 zero 라고 하고 LSB가 1인 수의 개수를 one 이라고 할 때
 * zero <= one 이면 빠진 수의 LSB는 0이고
 * zero > one 이면 빠진 수의 LSB는 1이라는 것이다.
 * 
 * 그러므로 위 로직을 일반화 시켜 recursive하게 반복해주면 된다.
 * 종료조건에 유의해야 하는데, examplify 를 해보면 
 * zero나 one중 어느 한쪽이 0이 되면 종료하면 된다는 사실을 알 수 있다.
 * 
 * 성능은 O(n) + O(n/2) + O(n/4) +... 이므로 O(2n) = O(n) 이다.
 * 위의 구현에서 copy overhead를 생각하면 O(4n)이 되는데 O(32n)보다는 낫다.
 * 책에 나와있는 구현은 recursive하게 되어있어서 copy overhead가 없지만
 * 메모리 할당 overhead가 있고, resursion depth 만큼 계속 결과를 keep 하므로 메모리 사용량이 높다.
 * (시간은 2n 임)
 * 
 * 이런 저런 요소들을 고려해보면 첫번째 구현이 실제로 훨씬 더 빠를 것 같다.
 * 그리고 이 문제는 실용성이 완전 제로이다-_-; constraint가 뭐 저따구야..
 */
