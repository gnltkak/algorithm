package interview;

/*
 * n by n array의 sub matrix들 중 원소의 총합이 가장 큰 것을 찾는다.
 */
public class _2011_03_07_MaxSubMatrixSum {
	//O(n^4) solution
	public static long maxSubMatrixSum(int[][] arr) {
		long max = Long.MIN_VALUE;
		long[][] colSumPre = colPreprocess(arr);
		int n = arr.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				for(int p=i;p<n;p++)
				{					
					long qSum = colSum(colSumPre,j,i,p);
					for(int q=j;q<n;q++)
					{
						if(q>j)
							qSum += colSum(colSumPre,q,i,p);
						if(qSum>max)
							max = qSum;
					}
				}
			}
		}
		
		return max;
	}

	private static long colSum(long[][] colSumPre, int col, int rowS, int rowE) {
		if(rowS==0)
			return colSumPre[col][rowE];
		return colSumPre[col][rowE]-colSumPre[col][rowS-1];
	}

	private static long[][] colPreprocess(int[][] arr) {
		int n = arr.length;
		long[][] colSum = new long[n][n];
		
		for(int c=0;c<n;c++)
		{
			colSum[c][0] = arr[0][c];
			for(int r=1;r<n;r++)
				colSum[c][r] = colSum[c][r-1] + arr[r][c];
		}
		
		return colSum;
	}
	
	//////////////////////////////////////////////////////////////////
	//O(n^3) solution
	public static long maxSubMatrixSumJaeHwan(int[][] arr) {		
		int n = arr.length;
		int m = arr[0].length;		
		
		long[][] rowAccSum = new long[n][m]; //공간복잡도는 O(mn)		
		
		for (int i=0;i<n;i++)
		{
			rowAccSum[i][0] = arr[i][0];
			for (int j=1;j<m;j++)
				rowAccSum[i][j] = rowAccSum[i][j-1] + arr[i][j];
		}

		long max = arr[0][0];
		for (int cStart=0;cStart<m;cStart++)
		{
			for (int cEnd=cStart;cEnd<m;cEnd++)
			{
				long maxEndingHere = rowSubSum(rowAccSum,0,cStart,cEnd);				
				long maxLocal = maxEndingHere;
				for (int row=1;row<n;row++)
				{
					if(maxEndingHere>=0)
						maxEndingHere += rowSubSum(rowAccSum,row,cStart,cEnd);
					else
						maxEndingHere = rowSubSum(rowAccSum,row,cStart,cEnd);
						
					maxLocal = Math.max(maxEndingHere, maxLocal);					
				}
				max = Math.max(max, maxLocal);
			}
		}
		
		return max;
	}
	
	private static long rowSubSum(long[][] rowAccSum,int row,int cStart,int cEnd) {
		if(cStart==0)
			return rowAccSum[row][cEnd];
		return rowAccSum[row][cEnd]-rowAccSum[row][cStart-1];
	}
	
	/////////////////////////////////////////////////////////////
	//O(n^4) solution (책에 있는 솔루션)
	public static long getMaxMatrix(int[][] original) {
		long maxArea = Long.MIN_VALUE;
		int rowCount = original.length;
		int columnCount = original[0].length;
		long[][] matrix = precomputeMatrix(original);
		for(int row1=0;row1<rowCount;row1++)
		{
			for(int row2=row1;row2<rowCount;row2++)
			{
				for(int col1=0;col1<columnCount;col1++)
				{
					for(int col2=col1;col2<columnCount;col2++)
						maxArea = Math.max(maxArea, computeSum(matrix,row1,row2,col1,col2));
				}
			}
		}
		return maxArea;
	}
	
	private static long[][] precomputeMatrix(int[][] matrix) {
		long[][] sumMatrix = new long[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				if(i==0 && j==0)
					sumMatrix[i][j] = matrix[i][j];
				else if(j==0)
					sumMatrix[i][j] = sumMatrix[i-1][j] + matrix[i][j];
				else if(i==0)
					sumMatrix[i][j] = sumMatrix[i][j-1]+matrix[i][j];
				else
					sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i][j];
			}
		}
		
		return sumMatrix;
	}
	
	private static long computeSum(long[][] sumMatrix, int i1,int i2,int j1,int j2) {
		if(i1==0 && j1==0)
			return sumMatrix[i2][j2];
		else if(i1==0)
			return sumMatrix[i2][j2] - sumMatrix[i2][j1-1];
		else if(j1==0)
			return sumMatrix[i2][j2] - sumMatrix[i1-1][j2];
		else
			return sumMatrix[i2][j2] - sumMatrix[i2][j1-1] - sumMatrix[i1-1][j2] + sumMatrix[i1-1][j1-1];
	}
}


/*
 * 1. O(n^6) solution 
 * sub matrix는 O(n^4) 개이고, 각 matrix의 합을 구하는 것이 O(n^2) 이다.
 * 가장 바보같은 솔루션이다.
 * 
 * 2. O(n^4) solution
 * sub matrix 가 O(n^4) 개 이므로 적절한 DP를 활용하면 된다.
 * sub matrix의 좌상단이 (i,j) 이고 우하단이(p,q) 일때 
 * 0<=i,j<=n-1
 * i<=p<=n-1
 * j<=q<=n-1
 * 이 된다.
 * 
 * 구현에 유의하며 잘 생각해보자.
 * for loop을 i,j,p,q 순으로 돌린다면
 * i,j,p가 고정되고 q만 움직이는 것을 생각해보면 된다.
 * 이때의 sub matrix의 합은 j 열의 i~p행의 합에서 시작하여 누적해 나가면된다.
 * j열의 i~p행의 합은 전처리 O(n), lookup O(1)이다.
 * 모든 열의 전처리에 걸리는 시간이 O(n^2) 이므로
 * 전체 성능은 O(n^4)이 된다.
 * 
 * 3. O(n^3) solution
 * 사실 이 문제는 2011_01_19_MaxSubSum의 2차원 버젼이다. 그와 같은 구조로 푼다.
 * 2차원 행렬이기 때문에 row 간의 관계를 살펴보자. (col 간의 관계로 해도 된다- 사실 이것이 구현이나 생각에 약간 더 유리하다.)
 * row, colS, colE 가 주어졌을 때
 * row 행 에서의 colS~colE 열의 합을 구할 수 있다.
 * colS,colE를 고정시키고  
 * row에 대해 scanning 알고리즘을 실시한다.
 * sub matrix를 만들려면 시점(p,q) 와 종점(r,s)가 필요한데
 * 이렇게 하면 q와 s를 고정킨 상태(q와 s가 주어진 상태)에서의 sub problem 울 푸는 것이다. 
 * 
 * 한번의 스캐닝이 O(n)이 걸리고
 * colS,colE의 조합이 모두 O(n^2)개 이므로
 * 
 * 전체 성능은 O(n^3)이 된다.
 * 
 * 구현에 따라 추가의 자료구조를 써야할 수도 있지만
 * for loop의 구조를 잘 조절하면 안써도 된다.
 * 
 * 4. O(n^2 logn) solution
 * index tree를 이용하면 된다고 한다. 생략-_-
 */