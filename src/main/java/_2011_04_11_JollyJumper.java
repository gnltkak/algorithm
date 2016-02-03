import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * http://www.programming-challenges.com
 * problem id : 110201
 */


class Main {
	public static void main(String args[]) throws IOException
    {    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	
    	String line;
    	while((line=br.readLine())!=null)
    	{    		
        	String[] tokens = line.trim().split("\\s+");        	
    		int n = Integer.parseInt(tokens[0]);
    		int[] seq = new int[n];
    		for(int i=0;i<n;i++)
    			seq[i] = Integer.parseInt(tokens[i+1]);    		
    		
    		if(isJolly(seq))
    			System.out.println("Jolly");
    		else
    			System.out.println("Not jolly");
    	}    
    }

	private static boolean isJolly(int[] seq) {
		int n = seq.length;
		
		boolean[] diffExist = new boolean[n];
		
		for(int i=1;i<n;i++)
		{
			int diff = Math.abs(seq[i]-seq[i-1]);
			if(!(diff>0 && diff<n && !diffExist[diff]))
				return false;
			diffExist[diff] = true;
		}
		return true;
	}
}

/*
 * 쉬운 문제이다. 수행시간은 O(n)이다.
 * 
 * 한가지 생각할 점은 loop를 n번 돌지 않아도 된다는 점이다.
 * 숫자가 n개이므로 diff 는 n-1개가 되는데 1~n-1 범위의 수가 한번씩만 모두 등장해야 하므로
 * diff가 1~n-1 범위를 벗어나거나 전에 나왔던 diff 이면 not jolly가 된다.
 */
