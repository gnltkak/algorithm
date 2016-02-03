package interview;

import java.util.Random;

/*
 * input : nxn grid
 * find : robot이 움직일 수 있는 모든 경로를 출력(경로 : 더이상 로봇이 진행할 수 없을 때까지의 경로)
 *        robot은 우,하 로만 움직일 수 있음
 *        robot의 시작 위치는 (0,0)임
 * follow up : 특정 cell에 장애물이 있어 거기로는 갈수 없는 제약을 추가
 */
public class _2011_02_01_RobotWays {
	public static void testRobotWays(int n) {
		boolean[][] board = new boolean[n][n];
		Random rand = new Random(System.currentTimeMillis());
		
		//랜덤하게 장애물을 n/2 개 넣는다.
		for(int k=0;k<=n/2;k++)
		{
			int i = rand.nextInt(n);
			int j = rand.nextInt(n);
			board[i][j] = true;
		}
		
		robotWays(n,board);
	}
	
	//board[i][j] == true인 지점은 장애물이 있어서 로봇이 갈 수 없는 곳임
	public static void robotWays(int n,boolean[][] board) {
		boolean[][] mark = new boolean[n][n];
		doRobotWays(n,board,mark,0,0);
	}

	private static void doRobotWays(int n, boolean[][] board,boolean[][] mark,int r, int c) {	
		boolean canGoMore = false;
		mark[r][c] = true;
		if(r<n-1 && board[r+1][c]==false)
		{
			canGoMore = true;
			doRobotWays(n,board,mark,r+1,c);
		}
		if(c<n-1 && board[r][c+1]==false)
		{
			canGoMore = true;
			doRobotWays(n,board,mark,r,c+1);
		}
		if(!canGoMore)
			printPath(board,mark);
		
		mark[r][c] = false;		
	}

	private static void printPath(boolean[][] board,boolean[][] mark) {
		for(int i=0;i<mark.length;i++)
		{
			for(int j=0;j<mark.length;j++)
			{
				if(mark[i][j]==true)
					System.out.print('O');
				else if(board[i][j]==true)
					System.out.print('■');
				else
					System.out.print('.');
				System.out.print('|');
			}
			System.out.println();
		}
		System.out.println();
	}
}
