import java.io.*;

/*
 * http://www.programming-challenges.com
 * problem id : 110102
 */

class _2011_04_10_MineSweeper {
	public static void main(String args[]) throws IOException
    {    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	
    	int fieldNum = 1;
    	while(true)
    	{
    		String line = br.readLine();
        	String[] tokens = line.trim().split("\\s+");
    		int n = Integer.parseInt(tokens[0]);
    		int m = Integer.parseInt(tokens[1]); 
    		if(n==0 && m==0) //end of input
    			break;    		
    		
    		char[][] field = new char[n][m];
    		
    		for(int i=0;i<n;i++)
    		{    			
    			line = br.readLine().trim();
    			field[i] = line.toCharArray();
    		} 
    		
    		if(fieldNum>1)
    			System.out.println();
    		
    		System.out.println("Field #"+fieldNum+":");
    		countMine(field,n,m);   		
    		fieldNum++;
    	}    
    }

	private static void countMine(char[][] field, int n, int m) {
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
				System.out.print(checkMine(field,i,j,n,m));
			System.out.println();
		}
	}

	private static String checkMine(char[][] field, int r, int c, int n, int m) {
		if(field[r][c]=='*')
			return "*";
		
		int mineCount = 0;
		for(int i=r-1;i<=r+1;i++)
		{
			if(i<0 || i==n)
				continue;
			
			for(int j=c-1;j<=c+1;j++)
			{
				if(j<0 || j==m)
					continue;
				if(field[i][j]=='*')
					mineCount++;
			}
		}
		
		return Integer.toString(mineCount);
	}
}

/*
 * 쉬운 문제다. 수행시간은 O(nm) 이다. 
 * nm size의 추가공간을 사용하면 상수를 줄일 수 있다.
 * 
 * 더 생각해볼 점은 n,m이 매우 클 때이다.
 * 위와 같은 구현을 사용할 때, input을 모두 읽어서 nm size의 array에 저장하지 말고 3줄씩 읽으면 메모리를 절약할 수 있다.
 * 3 x m size 만큼의 메모리만 사용해서 window 를 sliding 시키면 된다.
 */
