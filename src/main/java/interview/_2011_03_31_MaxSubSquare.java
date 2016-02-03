package interview;

/*
 * input : 각 cell이 black or white 인 square matrix
 * find : 4개의 border가 모두 black pixel 인 maximum subsquare
 */
public class _2011_03_31_MaxSubSquare {
	public static String findMaxSubSquare(int[][] matrix) {
		int n = matrix.length;
		int[][] rowspan = new int[n][n];
		int[][] colspan = new int[n][n];
		
		//rowspan,colspan 초기화
		for(int r=0;r<n;r++)
		{
			int spanSoFar = 0;
			for(int c=n-1;c>=0;c--)
			{
				if(matrix[r][c]==1)
					spanSoFar++;
				else
					spanSoFar=0;
				rowspan[r][c] = spanSoFar;
			}
		}
		
		for(int c=0;c<n;c++)
		{
			int spanSoFar = 0;
			for(int r=n-1;r>=0;r--)
			{
				if(matrix[r][c]==1)
					spanSoFar++;
				else
					spanSoFar=0;
				colspan[r][c] = spanSoFar;
			}
		}

		//max sub square 를 찾는다.
		int p=0;
		int q=0;
		int maxSize = 0;		
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				int trySizeMax = Math.min(rowspan[i][j],colspan[i][j]);
				for(int trySize=trySizeMax;trySize>maxSize;trySize--)
				{
					if(checkSubSquare(rowspan,colspan,i,j,trySize,n)==true)
					{
						maxSize = trySize;
						p = i;
						q = j;
					}
				}
			}
		}
		
		return ""+p+","+q+","+maxSize;
	}

	private static boolean checkSubSquare(int[][] rowspan, int[][] colspan,int i, int j, int trySize, int n) {
		if(i+trySize >n || j+trySize>n)
			return false;
		if(rowspan[i+trySize-1][j]>=trySize && colspan[i][j+trySize-1]>=trySize)
			return true;
		return false;
	}
}

/*
 * 1.나의 솔루션 : O(n^3)
 * 추가 공간을 사용한다. 하나는 열누적행렬 하나는 행누적행렬이다.
 * 누적행렬의 각 cell은 원래 input의 해당 위치에서 우 또는 하 방향으로 나타나는 연속적인 1의 개수를 나타낸다.
 * 0 1 1 0
 * 1 1 0 1
 * 0 1 1 1
 * 1 1 1 0
 * 
 * 이 input으로 주어진 경우
 * 열누적행렬은 
 * 0 4 1 0
 * 1 3 0 2
 * 0 2 2 1
 * 1 1 1 0
 * 
 * 행누적행렬은
 * 0 2 1 0
 * 2 1 0 1
 * 0 3 2 1
 * 3 2 1 0
 * 
 * 이 된다.
 * 
 * 이제 각 cell을 한번씩 훑으면서 각 cell을 좌상단으로 하여 만들수 있는 subsquare의 max값을 체크한다.
 * 위치 i,j 에서를 생각해보자.
 * 열누적행렬[i][j] 와 행누적행렬[i][j] 중 작은값을 택한다. 이 값을 tryMaxSize 라고 하자.
 * trySize는 tryMaxSize에서 시작하여 1까지 가는데,
 * 각 trySize에 대해 올바른 subsquare가 성립하는지 체크한다.( checkSubSquare 함수를 보면 된다 )
 * 
 * tryMaxSize에서 시작해서 1까지 가야하는 이유는 다음의 반례가 말해준다.
 * 		int[][] matrix = { 	{0,1,0,1,0},
							{1,1,1,1,1},
							{0,1,0,1,0},
							{1,1,1,1,1},
							{0,1,0,1,0},};
 * 
 * 
 * 2.책에 있는 솔루션 : O(n^3) (근데 O(n^2) 이라고 우기고 있음 )
 * 이 솔루션은 추가 메모리 공간을 사용하지 않고, 생각하기가 더 편하다.(면접에서는 이게 더 나을지도..)
 * 그냥 각 cell을 돌면서 각 cell마다 tryMaxSize ~ 1 까지 시도해보는 것이다.
 * 올바른 subsquare가 만들어지는지를 체크하는 것은 그냥 무식하게 다 1인지 보는 것이다.
 * 물론 불필요한 루프를 돌지 않게 하기 위해 currentMaxSize 값과 적절히 비교해서 루프를 빠져나가도록 한다.
 */
