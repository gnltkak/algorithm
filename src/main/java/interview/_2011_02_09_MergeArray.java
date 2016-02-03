package interview;

/*
 * input : 두개의 sorting된 integer array A,B ( increasing order )
 * A의 끝부분에는 B를 hold 할만큼 충분한 buffer 공간이 있다고 가정.
 * (여기서는 정확히 B의 원소의 개수만큼의 공간이 있다고 가정하였다)
 * A에 B를 sorted order 로 merge 해야 한다.
 * 문제에서 뉘앙스가 풍기고 있지만, 추가 메모리 공간을 사용할 수 없다. ( 인덱스 변수 ,temp 변수 는 제외 )
 */
public class _2011_02_09_MergeArray {	
	public static void mergeArray2(int[] a,int[] b) {
		int i = a.length-1-b.length;
		int j = b.length-1;		
		int k = a.length-1;
		
		while(i>=0 && j>=0)
		{
			if(a[i]>b[j])
				a[k--] = a[i--];
			else
				a[k--] = b[j--];
		}
		
		while(j>=0)
			a[k--] = b[j--];
	}	
	
	public static void mergeArray(int[] a,int[] b) {
		int i= a.length-1-b.length;
		int j = b.length -1;
		int bufEnd = a.length-1;
		
		while(i>=0 && j>=0)
		{
			if(a[i]>b[j])
				i--;
			else
			{
				for(int k=bufEnd-j-1;k>=i+1;k--)
				{
					a[k+j+1] = a[k];
					bufEnd--;
				}		
				a[bufEnd--] = b[j--];
			}
		}
		
		if(j>=0)
		{			
			for(int k=bufEnd-(j+1);k>=0;k--)
			{
				a[k+j+1] = a[k];
				bufEnd--;
			}
			
			while(j>=0)
				a[bufEnd--] = b[j--];
		}		
	}
}

/*
 * sorted array 2개가 나오면 merge sort를 연상하면 된다.
 * merge sort는 두 array를 가리키는 finger 2개와 target 을 가리키는 finger 1개가 존재하여 이를 조작한다.
 * 이 문제에서 추가 메모리 공간을 사용할 수 없으므로, 결국 a 내에서 원소들을 밀어야 한다.
 * 그런데 finger를 앞에서부터 scan하게 되면 한 원소가 2번 이상 이사가야 하는 일이 생긴다.
 * 그러므로 뒤에서부터 finger를 움직이도록 하자.
 * mergeArray() 는 직접 구현한 지저분한 코드이고
 * mergeArray2() 는 책에 나와있는 깔끔한 코드이다.
 * finger 가 움직이는 한 순간마다 swap이라거나 밀기라거나 그런 연산을 하는것이 깔끔하다는 것을 알 수 있다.
 * (mergeArray() 에서는 누울자리[?]를 먼저 찾은 다음 한꺼번에 밀고 어쩌고 하느라 지저분해졌다)
 * 
 * 최악의 경우는 a의 모든 원소가 이사를 가야하므로
 * a의 size가 n, b의 size가 m이면 성능은 O(n+m)이 된다.
 */
