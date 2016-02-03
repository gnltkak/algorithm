/*
 * http://www.programming-challenges.com
 * problem id : 110101
 */

import java.io.*;
import java.util.*;

class _2011_04_08_3n1 { //업로드시에는 클래스명을 Main으로 수정할 것.
    public static void main(String args[]) throws IOException  // entry point from OS
    {
    	HashMap<Long,Long> hm = new HashMap<Long,Long>();
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	String line;
    	while((line=br.readLine())!=null)
    	{
    		String[] tokens = line.trim().split("\\s+");
    		int i = Integer.parseInt(tokens[0]);
    		int j = Integer.parseInt(tokens[1]);    		
    		
    		System.out.println(i+" "+j+" "+maxCycle(i,j));
    	}          
    }

    private static long maxCycle(long lbound,long ubound)
    {
    	if(lbound>ubound)
    	{
    		long temp = lbound;
    		lbound = ubound ;
    		ubound = temp;
    	}
    	
		long length,max_length = 0;
		long i,j;
		
		for(i=lbound;i<=ubound;i++) {
			j=i;
			length = 1;
			while(j!=1) {
				if((j&1)!=0) {
					j=j*3+1;
					length++;
				}
				while((j&1)==0) {
					j>>=1;
					length++;
				}
			}
			if(length>max_length)
				max_length = length;
		}
		
		return max_length;
    }
    
    private static long maxCycle(long i,long j,HashMap<Long,Long> hm)
    {    	
    	long max = getCycle(i,hm);
    	for(long k=i+1;k<=j;k++)
    	{
    		long currCycle = getCycle(k,hm);
    		if(currCycle>max)
    			max = currCycle;    		
    	}
    	return max;
    }

	private static long getCycle(long n_, HashMap<Long, Long> hm) {
		if(hm.containsKey(n_))
			return hm.get(n_);
		
		long n = n_;
		
		long cycle = 1;
		while(n!=1)
		{			
			if((n&1)==0)
				n >>= 2;
			else
				n = 3*n + 1;
			
			if(hm.containsKey(n))
			{
				cycle += hm.get(n);
				break;
			}
			
			cycle++;
		}
		
		hm.put(n_, cycle);
		return cycle;
	}
}

/*
 * 매우 쉬운 문제이다. ( input을 받으면서 매우 삽질했지만 -_-;; 왜 Java를 미워하나요.. ㅠㅠ)
 * 다만 한가지 유의할 점은 % 연산과 / 연산이 비싸다는 점이다.
 * 홀,짝을 판단할때 % 를 사용하면 시간초과가 되어버린다.
 * 그리고 또한가지, hash table을 이용하여 최적화 해보려 시도했는데 아무 소용이 없었다는 점이다.
 * 아무래도 hash table 에서 별로 hit 되지 않았거나 hash table lookup 시간등이 길어서 인것 같다.
 * 아니면 bottleneck이 n값을 바꾸는데에서 걸려서 그랬는지도..
 * 
 * 아참.. input 으로 읽는 두개의 숫자중 어느것이 크다는 가정이 없다는 점도 간과해서는 안된다.
 * 또한 n값을 갱신하는 과정에서 32bit integer는 넘는 경우가 있다는 사실도..(이건 문제만 읽고 알아내기는 참 어렵다)
 */
