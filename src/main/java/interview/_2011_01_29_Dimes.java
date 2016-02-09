package interview;

/*
 * input : integer n(n>0)
 * find : 25,10,5,1 cent 를 이용하여 n cent를 만드는 경우의 수
 * assume : 각 동전의 수는 무한개 있다고 가정
 */
public class _2011_01_29_Dimes {
	public static int moneyWays(int n) {
		return doMoneyWays(n,25);
	}

	private static int doMoneyWays(int n, int dime) {
		if(dime==1 || n==0)
			return 1;
		
		int nextDime = -1;
		if(dime==25)
			nextDime = 10;
		else if(dime==10)
			nextDime = 5;
		else if(dime==5)
			nextDime = 1;
		
		int ways = 0;
		for(int i=0;i*dime<=n;i++)
			ways += doMoneyWays(n-i*dime,nextDime);		
		
		return ways;
	}

    // 추가 (2016-02-09)
	public static int moneyWays2(int n) {
		int count = 0;
        int remain = n;
        for (int i = 0; i <= remain / 25; ++i) {
            remain -= 25 * i;
            for (int j = 0; j <= remain / 10; ++j) {
                remain -= 10 * j;
                for (int k = 0; k <= remain / 5; ++k) {
                    ++count;
                }
                remain += 10 *j;
            }
            remain += 25 * i;
        }
        return count;
	}
}

/*
 * 그냥 리컬시브하게 풀면 된다.
 * 성능은 O(경우의수) 가 된다.
 */
