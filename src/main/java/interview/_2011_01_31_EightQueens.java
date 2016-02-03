package interview;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * input : 8x8 의 chess board
 * find : queen 8개를 valid 한 position에 배치하는 모든 경우를 출력.
 *        queen을 어떤 위치에 놓을 때 같은 행, 같은 열에 다른 queen이 없어야 하며 모든 대각선 방향에도 queen이 없어야 한다.
 */
public class _2011_01_31_EightQueens {
	private static ArrayList<String> result = new ArrayList<String>();
	private static StringBuffer sb = new StringBuffer();
	
	public static void printAllCase() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> result = _2011_01_31_EightQueens.eightQueens();
		for(int i=0;i<result.size();i++)
		{
			System.out.println("------["+i+"]------");
			System.out.println(result.get(i));
			//sc.nextLine();
		}
	}
	
	private static ArrayList<String> eightQueens() {
		result.clear();
		
		boolean[][] board = new boolean[8][8]; //chess board
		doEightQueens(board,0);		
		
		return result;
	}

	private static void doEightQueens(boolean[][] board, int c) {	
		if(c==8)
		{
			printBoard(board);
			return;
		}
		
		for(int r=0;r<=7;r++)
		{
			if(valid(board,r,c))
			{
				board[r][c] = true;				
				doEightQueens(board,c+1);
				board[r][c] = false;
			}
		}	
	}

	private static boolean valid(boolean[][] board, int r, int c) {		
		//행 검사
		for(int j=c-1;j>=0;j--)
		{
			if(board[r][j])
				return false;
		}
		
		//대각선 검사		
		int i=r-1,j=c-1; 		
		while(i>=0&&j>=0) //왼쪽 위 방향
		{
			if(board[i][j])
				return false;
			i--;
			j--;
		}
		
		i=r+1;
		j=c-1;
		while(i<=7&&j>=0) //왼쪽 아래 방향
		{
			if(board[i][j])
				return false;
			i++;
			j--;
		}		
		
		return true;
	}

	private static void printBoard(boolean[][] board) {
		sb.delete(0, sb.length());
		
		for(int r=0;r<=7;r++)
		{
			for(int c=0;c<=7;c++)
			{
				if(board[r][c]==true)
					sb.append('O');
				else
					sb.append('.');
				sb.append('|');
			}			
			sb.append('\n');
		}
		
		result.add(sb.toString());
	}
}

/*
 * 직접 손으로 놓는 과정을 그대로 옮기면 된다.
 * 각 열,행에는 오직 1개의 퀸만 위치할 수 있으므로 열 또는 행 단위로 퀸을 놓도록 하자. (여기서는 열로 하였다)
 * 0열에 퀸을 놓을수 있는 자리가 여러개 있다. 이 중 하나를 택하여 퀸을 놓는다.
 * 1열에 퀸을 놓을 수 있는 자리도 여러개 있다. valid한 위치를 하나 택하여 퀸을 놓는다.
 * 위 과정을 계속 반복하다가 퀸을 아무 자리에도 놓을 수 없게 되면 앞으로 돌아가서 앞 열의 다른 valid한 위치에 놓아본다.(backtracking)
 * 결국 마지막 열까지 퀸을 놓을 수 있으면 한가지 경우가 완성된 것이다.
 */
