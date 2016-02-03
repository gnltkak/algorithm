package interview;

/*
 * input : sorted integer array
 * find : array에서 특정 숫자가 나타나는 횟수를 구하라.
 */
public class _2011_01_18_ElemCount {
	//precondition : array is sorted
	public static int elemCount(int[] array, int num) {
		return elemCount2(array, num);
		
		/*
		int l = findLeftMostIndex(array,num);
		int r = findRightMostIndex(array,num);
		
		if(l==-1 && r==-1)
			return 0;
		
		if(l==-1 || r==-1)
			throw new RuntimeException("알고리즘이 잘못되었습니다.");
		
		return r-l+1;
		*/
	}
	
	private static int findLeftMostIndex(int[] array, int num) {
		return doFindLeft(array,num,0,array.length-1);
	}

	private static int doFindLeft(int[] array, int num, int l, int r) {
		if(l>r)
			return -1;
		
		int m =(l+r)/2;
		
		if(num>array[m])
			return doFindLeft(array,num,m+1,r);
		if(num<array[m])
			return doFindLeft(array,num,l,m-1);
		if(num==array[m])
		{
			int tryLeft = doFindLeft(array,num,l,m-1);
			if(tryLeft==-1)
				return m;
			return tryLeft;
		}
		
		return -1; //must never reach here
	}
	
	private static int findRightMostIndex(int[] array, int num) {
		return doFindRight(array,num,0,array.length-1);
	}	
	
	private static int doFindRight(int[] array, int num, int l, int r) {
		if(l>r)
			return -1;
		
		int m =(l+r)/2;
		
		if(num>array[m])
			return doFindRight(array,num,m+1,r);
		if(num<array[m])
			return doFindRight(array,num,l,m-1);
		if(num==array[m])
		{
			int tryRight = doFindRight(array,num,m+1,r);
			if(tryRight==-1)
				return m;
			return tryRight;
		}
		
		return -1; //must never reach here
	}
	
	/////////////////////////////////////////////////////////
	public static int elemCount2(int[] arr, int num) {
		return doElemCount2(arr, num, 0, arr.length - 1);
	}

	private static int doElemCount2(int[] arr, int num, int l, int r) {
		if (l > r)
			return 0;
		if (l == r) {
			if (arr[l] == num)
				return 1;
			return 0;
		}
		
		int m = (l + r) / 2;
		if (arr[m] < num)
			return doElemCount2(arr, num, m + 1, r);
		else if (arr[m] > num)
			return doElemCount2(arr, num, l, m - 1);
		
		int ml = (l + m) / 2;
		int mr = (m + r) / 2;
		
		int count = 1;
		if (arr[m] == arr[ml]) {
			count += m - ml;
			count += doElemCount2(arr, num, l, ml - 1);			
		} else {
			count += doElemCount2(arr, num, ml + 1, m - 1);
		}
		
		if (arr[m] == arr[mr]) {
			count += mr - m;
			count += doElemCount2(arr, num, mr + 1, r);			
		} else {
			count += doElemCount2(arr, num, m + 1, mr - 1);
		}
		
		return count;
	}
}

/*
 * 1. O(n) solution
 * 그냥 처음부터 쭉 훑으면 된다.
 * binary search로 하나를 찾고 좌우로 훑어도 O(n) 이다.
 * 물론 처음부터 쭉 훑는 naive 한 방법보다는 좋겠지만...
 * 
 * 2.O(logn) solution
 * 결국 sorting 되었다는 것은 binary search나 merge sort에서와 같은 알고리즘을 쓸 수 있다는 것이다.
 * binary search를 약간 변형하여 해당 원소가 나타나는 가장 좌측 index, 가장 우측 index를 계산하면 된다.
 * 
 * **2번 솔루션의 생각의 흐름
 * **binary search는 원소가 나타날 수 있는 범위를 점차 좁혀 나가는 과정을 거친다.
 *   원래의 binary search는 가장 좌측 혹은 우측 원소를 찾아주지 않고 임의의 위치의 원소를 찾아준다.(물론 그 원소가 존재하는 경우)
 *   가장 좌측의 원소를 찾는 경우를 생각해보자.
 *   임의의 원소를 찾았다면 그 좌측에 (즉 l~m-1 범위 ) 원소가 있는지 찾아본다. 없다면 m이 답이 된다.
 *   있다면? 이 알고리즘이 l~m-1 범위에서 가장 좌측 원소를 찾아줄 것이므로 그것이 답이다!
 * 
 * 3. O(logn) solution
 * binary search의 핵심은 각 recursive step 마다 검색 범위를 반씩 버리는 것이다.
 * 이 경우 l과 m의 중간점, m과 r의 중간점을 취하면 반을 버릴 수 있다.
 * l  ml  m  mr  r
 * boundary case에 유의하자(원소가1개, 2개)
 * 그리고 구현시에 중복count 하지 않도록 유의하자.
 */
