package interview;

/*
 * input : m by n 의 integer array
 * do : a[i][j]==0 이면 i행과 j열에 있는 모든 원소의 값을 0으로 만들기
 */
public class _2011_05_16_SetArrWithZero {
	public static void setArrWithZero(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		
		boolean[] rowZero = new boolean[m];
		boolean[] colZero = new boolean[n];
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j]==0)
				{
					rowZero[i]=true;
					colZero[j]=true;
				}					
			}
		}		
		
		for(int i=0;i<m;i++)
		{
			if(rowZero[i]==true)
			{
				for(int p=0;p<n;p++)
					arr[i][p]=0;
			}
		}
		
		for(int i=0;i<n;i++)
		{
			if(colZero[i]==true)
			{
				for(int p=0;p<m;p++)
					arr[p][i]=0;
			}
		}	
	}
}

/*
 * 쉬워보이지만 주의해서 풀어야 한다.
 * 전처리를 반드시 해야 한다는 사실에 주의하자.
 * 
 * 공간 복잡도 : O(m+n)
 * 시간 복잡도 : O(mn)
 */
