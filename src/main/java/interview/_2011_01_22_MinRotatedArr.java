package interview;

/*
 * input : rotated sorted array ( 얼만큼 rotation 됐는지는 주어지지 않는다 )
 *         모든 원소는 distinct 하다. (몇몇 test case가 잘못되었음)
 * find : minimum element of the array
 */
public class _2011_01_22_MinRotatedArr {
	public static int findMin(int[] array) {
		return doFindMin(array,0,array.length-1);
	}

	private static int doFindMin(int[] array,int l,int r) {		
		if(l==r)
			return array[l];
		if(r-l==1)
			return Math.min(array[l], array[r]);
		
		int m = (l+r)/2;		
		if(array[m]<=array[r])			
			return doFindMin(array, l, m);
		else			
			return doFindMin(array, m, r);
	}	
}

/*
 * 한번 쭉 훑어보는 O(n)은 본래의 array가 sorting 되어 있다는 특징을 전혀 살리지 못한 것이다.
 * 따라서 우리는 O(logn) 을 목표로 하자.
 * sorting 되어 있으므로 binary search 를 써보자. ( sorting된 array가 2개 이상이면 merge sort 와 같은 방식을 쓸수 있다)
 * binary search의 핵심은 문제공간의 범위를 점점 줄여나가는 것이므로
 * binary search에서와 마찬가지로 recursive 하게 하고, l,r 값을 두도록 하자.
 * 
 * 우선 a[m]을 취하고 생각한다.
 * 1.a[m]<a[r] 인 경우 : 답은 [l,m] 범위에 있다.
 * 2.a[m]>a[r] 인 경우 : 답은 [m,r] 범위에 있다.
 * 3.a[m]==a[r] 인 경우 : 답은 [l,m] 범위에 있다.
 * 
 * a[l]과 비교해서 판단해도 될 것 같지만 rotation이 하나도 안 된 경우를 생각해보면 안된다는 것을 알 수 있다.
 * 
 * 3번 케이스를 유의!
 * 
 * 여기서 등호가 어디에 들어가는지도 중요하다. 그림을 그려서 생각해보도록 하자.
 *    
 *  이제 base case를 생각해보자.
 *  1.l==r 이면 그냥 a[l] 을 리턴하면 된다.
 *  2.r-l==1 이면 min(a[l],a[r])을 리턴하면 된다.
 *    왜 이런 처리가 필요하냐면, 우리가 m을 계산할 때 (l+r)/2 로 계산했기 때문이다.
 *    원소의 개수가 2개라면 m은 l과 같아지게 되는데, [m,r] 범위에서 계속 call이 일어나게 되면 stackoverflow가 된다.
 *    
 * 문제를 풀 때 다음의 boundary case를 잘 생각해야 한다.
 * 1.rotation 이 전혀 되지 않은 경우
 * 2.rotation 이 완전히 된 경우 ( array가 뒤집힌 경우 )
 * 3.원소의 개수가 1개인 경우
 * 4.같은 원소만으로 가득찬 경우
 */