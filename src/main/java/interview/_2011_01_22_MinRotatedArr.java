package interview;

/*
 * input : rotated sorted array ( 얼만큼 rotation 됐는지는 주어지지 않는다 )
 *         모든 원소는 distinct 하다. (그렇지 않으면 문제 성립이 안됨 1,1,1,-1,1 이나 1,-1,1,1,1 같은 케이스 때문에)
 * find : minimum element of the array
 */
public class _2011_01_22_MinRotatedArr {
	public static int findMin(int[] array) {
		return doFindMin(array,0,array.length-1);
	}

    private static int doFindMin(int[] arr, int l, int r) {
        if (r - l <= 2) return Math.min(arr[l], arr[r]);
        if (arr[l] < arr[r]) return arr[l]; // 회전이 안 된 경우
        
        int m = (l + r) / 2;
        if (arr[m] > arr[r])  // arr[r] 대신 arr[l] 로 해도 상관없음
            return doFindMin(arr, m + 1, r);
        else
            return doFindMin(arr, l + 1, m);
    }
}

/*
 * 한번 쭉 훑어보는 O(n)은 본래의 array가 sorting 되어 있다는 특징을 전혀 살리지 못한 것이다.
 * 따라서 우리는 O(logn) 을 목표로 하자.
 * sorting 되어 있으므로 binary search 를 써보자. ( sorting된 array가 2개 이상이면 merge sort 와 같은 방식을 쓸수 있다)
 * binary search의 핵심은 문제공간의 범위를 점점 줄여나가는 것이므로
 * binary search에서와 마찬가지로 recursive 하게 하고, l,r 값을 두도록 하자.
 * 
 * array 가 rotation되면 array 전체가 A, B 두 파트로 나누어지므로 l,r,m 의 조합은 다음 케이스중 하나가 된다
 * 1. [l,r] 이 A,B 범위를 모두 커버하고 m 이 A 에 속함
 * 2. [l,r] 이 A,B 범위를 모두 커버하고 m 이 B 에 속함
 * 3. [l,r] 이 A,B 범위를 모두 커버하지 않음. 즉, [l,r] 은 rotation 되지 않음
 *
 * 1은 arr[m] > arr[l] > arr[r] 인 경우이므로 [m + 1, r] 로 recursive call 하면 된다
 * 2는 arr[l] > arr[r] > arr[m] 인 경우이므로 [l + 1 , m] 으로 recursive call 하면 된다
 * 3은 arr[l] < arr[r] 인 경우이다. 따라서 arr[l] 을 리턴한다
 *    
 * 위의 case 1, 2 의 구현에 따라 base case 는 원소의 개수가 1개 or 2개 인 경우가 된다    
 *    
 * 문제를 풀 때 다음의 boundary case를 잘 생각해야 한다.
 * 1.rotation 이 전혀 되지 않은 경우
 * 2.rotation 이 완전히 된 경우 ( array가 뒤집힌 경우 )
 * 3.원소의 개수가 1개인 경우
 * 
 * (2016-02-08 추가)
 * 보다 직관적으로 생각하면 쉽다
 * 우선 array가 rotation 된 모양을 생각하자.
 * 
 */