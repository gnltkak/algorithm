package interview;

/*
 * n by n array를 90도 반시계 방향으로 rotate 한다. ( in-place 로 해야 한다) 
 */
public class _2011_03_01_ArrayRotate {
	public static void rotate(int[][] matrix) {
		/*
		int n = matrix.length;
		doRotate(matrix,n-1);
		reverseEachRow(matrix);
		*/
		rotate3(matrix);
	}

	//lb는 leftBottom
	private static void doRotate(int[][] matrix, int lb) {
		if(lb==0)
			return;
		
		int n = matrix.length;
		int i=lb; //row쪽 finger
		int j=n-1-lb; //col쪽 finger
		
		while(i>=0 && j<=n-1)
		{
			int temp=matrix[i][n-1-lb];
			matrix[i][n-1-lb]=matrix[lb][j];
			matrix[lb][j]=temp;
			i--;
			j++;
		}
		doRotate(matrix,lb-1);
	}
	
	private static void reverseEachRow(int[][] matrix) {
		int n = matrix.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-1-j];
				matrix[i][n-1-j] = temp;
			}
		}
	}
	
	/////////////////////////////////////////////////
	
	public static void rotate2(int[][] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				int temp = arr[j][i];
				arr[j][i] = arr[n-1-i][n-1-j];
				arr[n-1-i][n-1-j] = temp;
			}
		}		
		
		//각 row를 reverse
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int temp = arr[i][j];
				arr[i][j] = arr[i][n-1-j];
				arr[i][n-1-j] = temp;
			}
		}
	}
	
	public static void rotate3(int[][] arr) {
		int n = arr.length;
		int p = n - 1;
		int q = 0;
		
		while (p >= 0 && q < n) {
			for (int i = 0; i < p; ++i) {
				// Swap arr[i][q] and arr[p,n-1-i]
				int temp = arr[i][q];
				arr[i][q] = arr[p][n-1-i];
				arr[p][n-1-i] = temp;
			}
			
			--p;
			++q;
		}
		
		//각 row를 reverse
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int temp = arr[i][j];
				arr[i][j] = arr[i][n-1-j];
				arr[i][n-1-j] = temp;
			}
		}
	}
}

/*
 * in-place 로 하지 않는 방법은 너무 쉽다.
 * n by n array를 하나 더 잡고 적절히 복사해넣으면 되기 때문이다.
 * 
 * in-place로 하려면 어떻게 해야할까?
 * 2차원 array는 row 나 col 간의 관계로 살펴보는 관점이 유효하다.
 * 그리고 in-place로 하려면 결국 swap을 primitive로 해야 한다는 뜻이 된다.
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 를 예로 들어보자.
 * 
 * 우리가 원하는 결과는
 * 3 6 9
 * 2 5 8
 * 1 4 7
 * 이다.
 * 
 * 1,7을 바꾸고 4,8을 바꾸고.. 이런식으로 해보면 알겠지만 원소들의 위치를 추적할수가 없다.
 * (추적하려면 n by n 의 공간을 써야한다)
 * 그러니 하나씩 바꾸지 말고 row나 col 단위로 생각해보자.
 * 1,4,7 을 7,8,9와 바꾸어보면 어떨까.
 * 여기서 위치가 망가지지 않도록 7,4,1 을 7,8,9 와 바꾸는 것이다.
 * 그러면 다음과 같은 모양이 된다.
 * 
 * 9 2 3
 * 8 5 6
 * 7 4 1
 * 
 * 7 4 1 은 이제 완전히 제자리를 잡았다(뒤집혀져 있지만 그건 나중에 뒤집으면 된다)
 * 그리고 9 8 7 도 제 형태를 유지하고 있다.
 * 
 * 이제 2 5 와 5 6을 같은 방식으로 바꾼다. 그러면 다음과 같이 된다.
 * 9 6 3
 * 8 5 2
 * 7 4 1
 * 
 * 마지막으로 각 row를 뒤집는다.
 * 3 6 9
 * 2 5 8
 * 1 4 7
 * 
 * 수행시간은 O(n^2)이 된다.
 * 
 * 한개의 col 과 한개의 row 를 바꾸는 것을 구현할때 유의하도록 하자.
 * swap 하려고 하는 두 원소의 행과 열의 합이 일정함을 이용하면 된다.
 */
