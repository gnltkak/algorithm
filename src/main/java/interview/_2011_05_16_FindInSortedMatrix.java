package interview;

/*
 * input : 각 row, col 이 sorting(오름차순)된 m by n matrix
 * find : 이 matrix에서 특정 원소의 position 찾기 
 *        (string 으로 리턴 "0,1" 이런식으로. 없으면 "-1,-1" 리턴)
 */
public class _2011_05_16_FindInSortedMatrix {
	public static String findInSortedMatrix(int[][] matrix,int key) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int r = 0;
		int c = n-1;		
		
		while(r!=m && c!=-1)
		{
			if(matrix[r][c]==key)
				return r+","+c;
			if(matrix[r][c]<key)
				r++;
			else //else 안쓰면 안된다!!!
				c--;
		}
		
		return "-1,-1";
	}
}

/*
 * 각 행마다 binary search를 하면 O(mlogn) 이 된다.
 * 그런데 이렇게 하면 column 도 sorting 되어 있다는 사실을 전혀 이용하지 못한게 된다.
 * 
 * examplify 를 해서 성질을 잘 살펴보면 답을 쉽게 알 수 있다.
 * 오른쪽 맨위 구석에서 시작하여 매번 한 열이나 한 행을 제거해 나가면 된다. 성능은 O(n+m)이 된다.
 * 사실 마지막 행이나 열에서 binary search를 써도 되지만 전체 성능에 큰 영향은 주지 않는다.
 * 
 * 한가지 주의할 점은 역시나 array bound 이다. 
 * 위 코드에서 else 대신에 if(matrix[r][c]>key) 라고 쓰면 boundary 에서 에러가 난다.
 */
