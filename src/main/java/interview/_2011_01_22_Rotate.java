package interview;

/*
 * input : integer array, integer k(회전수)
 * find : array를 k번 right rotation 시키기
 * 예) {1,2,3,4,5} , k=2 가 주어지면
 *     {4,5,1,2,3} 을 만들어야 한다.
 */
public class _2011_01_22_Rotate {
	public static void rotateNaive(int[] array,int k) {
		if(array.length==0)
			return;
		
		if(k>=array.length)
			k = k%array.length;
		
		for(int i=0;i<k;i++)
			rotateNaiveOnce(array);
	}
	
	private static void rotateNaiveOnce(int[] array) {
		int n = array.length;
		int temp = array[n-1];
		for(int i=n-1;i>=1;i--) //shift
			array[i] = array[i-1];
		array[0] = temp;
	}	
	
	public static void rotate(int[] array, int k) {		
		if(array.length==0)
			return;
		
		if(k>=array.length)
			k = k%array.length;	
		
		int s = array.length-k;
		reverse(array,0,s-1);
		reverse(array,s,array.length-1);
		reverse(array,0,array.length-1);		
	}

	private static void reverse(int[] array, int l, int r) {
		for(int i=l;i<=(l+r)/2;i++)
		{
			int temp = array[i];
			array[i] = array[l+r-i];
			array[l+r-i] = temp;
 		}
	}
}

/*
 * 1.O(kn) (보다 정확히는 O((k%n)n) ) 
 * rotation 1회를 k번 한다.
 * 
 * 2.O(n)
 * 약간의 수학적 통찰이 필요하다.
 * 전체 array를 두개의 부분으로 나누어 생각하자. ( a b 로 )
 * 예를들어 {1,2,3,4,5} k=2 의 경우
 * a = {1,2,3} , b= {4,5} 로 나눈다.
 * 우리가 원하는 결과 {4,5,1,2,3} 은 b a 라고 할 수 있다.
 * 
 * 여기서 reverse 의 성질을 이용해보자.
 * 벡터에서 (ab)^r = b^r a^r 이라는 성질이 있다.
 * 이 문제에 이것을 적용하면
 * 1) a,b 를 각각 reverse 시킴 ( a b => a^r b^r 이 됨 )
 * 2) 전체를 reverse 시킴 ( a^r b^r = > b a 가 됨)
 * 
 * reverse는 O(n) 이므로 알고리즘의 전체 성능은 O(n)이 된다.
 */
