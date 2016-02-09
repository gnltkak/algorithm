package interview;

/*
 * input : integer n>0
 * find : 1) n과 1bit의 개수가 같으면서 n보다 큰 수 중 n과 가장 가까운 수
 *        2) n과 1bit의 개수가 같으면서 n보다 작은 수 중 n과 가장 가까운 수
 * assumption : reasonable한 범위 내에 n이 있다고 가정한다.
 * 예) n=1 일 경우, 0보다 크고 1보다 작은 정수는 없다.
 * 예) n=2^31-1 인 경우, bit 1 의 개수는 31개가 되는데 bit 1의 수가 31개 이면서 2^31-1 보다 큰 수는 integer로 표현불가능하다.
 *    (overflow 발생)
 *    (구체적으로 그 범위가 어떻게 될까?) 
 */
public class _2011_01_28_NextLargeSmallSameBitOne {
	public static int nextLarge(int n) {
		/*
		int firstOneBit = findOneBitPosFromRight(n, 0);
		int i = findZeroBitPosFromRight(n,firstOneBit+1);
		int j = findOneBitPosFromLeft(n,i-1);
		*/
		
		int firstOneBit = 0;
		while(!getBit(n,firstOneBit))
			firstOneBit++;
		int i = firstOneBit+1;
		while(getBit(n,i))
			i++;
		int j = i-1;
		
		n = turnOn(n,i);
		n = turnOff(n,j);		
		
		//남은부분 재배열
		n = rearrange(n,j-1,true);		
		
		return n;
	}

	public static int prevSmall(int n) {
		/*
		int firstZeroBit = findZeroBitPosFromRight(n,0);
		int i = findOneBitPosFromRight(n,firstZeroBit+1);
		int j = findZeroBitPosFromLeft(n,i-1);
		*/
		
		int firstZeroBit = 0;
		while(getBit(n,firstZeroBit))
			firstZeroBit++;
		int i = firstZeroBit + 1;
		while(!getBit(n,i))
			i++;
		int j = i - 1;
		
		n = turnOff(n,i);
		n = turnOn(n,j);
		
		n = rearrange(n,j-1,false);
		
		return n;
	}

	private static int findZeroBitPosFromLeft(int n, int s) {		
		int result = s;
		int mask = 1<<s;
		while(mask>0 && (n&mask)!=0)
		{
			result--;
			mask = mask >>> 1;
		}
		
		if(mask==0) //없으면 -1이 리턴된다.
			return -1;
				
		return result; 
	}
	
	private static int findZeroBitPosFromRight(int n, int s) {			
		int result = s;
		int mask = 1<<s;
		while(mask>0 && (n&mask)!=0)
		{
			result++;
			mask = mask << 1;
		}
		
		if(mask<0) //없으면 1이 리턴된다.
			return -1;
		
		return result;
	}

	private static int findOneBitPosFromLeft(int n, int s) {		
		int result = s;
		int mask = 1<<s;
		while(mask>0 && (n&mask)==0)
		{
			result--;
			mask = mask >>> 1;
		}
		
		if(mask==0) //없으면 -1이 리턴된다.
			return -1;
		
		return result;
	}
	
	private static int findOneBitPosFromRight(int n, int s) {		
		int result = s;
		int mask = 1<<s;
		while(mask>0 && (n&mask)==0)
		{
			result++;
			mask = mask << 1;
		}
		
		if(mask<0) //없으면 1이 리턴된다.
			return -1;
		
		return result;
	}
	
	private static int turnOff(int n, int pos) {
		return n&(~(1<<pos));
	}

	private static int turnOn(int n, int pos) {
		return n|(1<<pos);
	}
	
	//LSB로부터 index k 까지의 bit를 재배열하여 최소 또는 최대로 만든다.
	private static int rearrange(int n, int k,boolean toSmall) {
		if(k<0)
			return n;
		
		//1인 bit 수를 샌다.
		/*
		int mask = ((1<<(k+1))-1); //LSB로부터 index k까지만 취하기 위한 mask
		int oneCnt = bitCntOne(n&mask);
		*/
		int oneCnt = 0;
		for(int i=0;i<=k;i++)
		{
			if(getBit(n,i))
				oneCnt++;
		}
		
		/*
		//boundary case(1만 가득한 경우, 0만 가득한 경우)		
		if(oneCnt==0 || oneCnt==k+1)
			return n;
		*/			
		
		/*
		n = n&(~mask); //0~k까지의 bit를 0으로 만든다.
		if(toSmall)			
			return n|((1<<oneCnt)-1);		
		else	
			return n|((~((1<<oneCnt)-1))&mask);
		*/		
		
		if(toSmall)
		{
			//0을 쓰고, 1을 쓴다.
			for(int i=k;i>=oneCnt;i--)
				n = turnOff(n,i);
			for(int i=oneCnt-1;i>=0;i--)
				n = turnOn(n,i);
		}
		else
		{
			//1을 쓰고, 0을 쓴다.			
			for(int i=k;i>=(k-oneCnt+1);i--)
				n = turnOn(n,i);
			for(int i=k-oneCnt;i>=0;i--)
				n = turnOff(n,i);
		}
		return n;
	}

	//n에 포함된 0 또는 1의 bit수를 샌다. 부호비트는 없는 것으로 취급한다.(즉,31개 bit만 취급)
	private static int bitCntOne(int n) {
		int oneCnt = 0;
		int mask = 1;
		while(mask>0)
		{
			if((mask&n)>0)
				oneCnt++;
			mask = mask << 1;
		}
		
		return oneCnt;		
	}
	
	//k번째 bit가 1이면 true, 0이면 false를 리턴
	private static boolean getBit(int n,int k) {
		return (n&(1<<k))!=0;
	}
	
	/////////////////////////////////////////////////
	// 2012.1.2 추가 
	// 이렇게 해도 됨.(이게 조금 더 심플해보임)
	public static int nextLarge2(int n) {		
		int firstOneBit = 0;
		while(!getBit(n,firstOneBit))
			firstOneBit++;
		int zeroBitToShuffle = firstOneBit+1;
		while(getBit(n,zeroBitToShuffle))
			zeroBitToShuffle++;	
		
		n = turnOn(n,zeroBitToShuffle);
		n = turnOff(n,firstOneBit);		
		
		//남은부분 재배열
		n = rearrange(n,zeroBitToShuffle-1,true);		
		
		return n;
	}
	
	// 2016.2.9 추가
    public static int nextLarge3(int num) {
        int k = 0;
        while ((num & (1 << k)) == 0) ++k;
        int s = 0;
        while ((num & (1 << k)) != 0) {
            ++k;
            ++s;
        }
        int p = k;
        
        num = num | 1 << p;
        num = num & ~(1 << (p - 1));
        num = num & ~(1 << (p - 1) - 1);                
        num = num & (1 << s - 1);
        
        return num;
    }
}

/*
 * observation
 * 1. 0을 1개 turn on ( 1로 set ) 하면, 1을 1개 turn off( 0으로 set ) 해야한다.
 *    (turn on 하는 0의 index를 i, turn off 하는 1의 index를 j 라고 하자. LSB의 index가 0이라고 가정한다)
 * 2. 원래의 수보다 커지려면, i>j 여야 한다.
 * 3. i>j 일 경우 원래의 수보다 2^i - 2^j 만큼 커진다.
 * 
 * 우선 원래의 수보다 크게 만드는 경우를 생각해보자.
 * 우리는 적절한 i,j 값을 찾아야 한다.
 * 원래의 수보다 최소한으로 커져야 하므로 i는 작아야 하고 j는 커야한다.
 * 그런데 i>j 이기 때문에 j는 아무리 커봐야 i-1 이다.
 * 그러므로 사실상 i를 작게 만드는 것이 포인트이다.
 * 가장 작은 i는 몇일까. 숫자를 오른쪽부터 스캔해서 나오는 최초의 0의 index가 가장 작은 i의 값이다.
 * 이런 i를 찾았다면 i보다 작은 범위에서 좌->우 로 스캔하여 1이 최초로 나오는 지점을 찾자. 찾았다면 이것이 j값이다.
 * j를 못찾았다면 i값을 보다 좌로 조정하고 j를 다시 찾아야 한다.
 * j값이 찾아질 때까지 위의 과정을 반복하면 된다.
 * 
 * 원래의 수보다 작게 만드는 경우는 위와 symmetric 하다.
 * 
 * integer의 bit 수를 n이라고 하면
 * 성능은 O(n^2) 이 된다.
 * 결국 i,j를 몇번만에 찾느냐가 문제가 되는데 
 * 0을 한번 찾을때마다 그 우측에서 1을 찾기 때문이다.
 * 
 * 보다 빠르게 i,j를 찾을 수는 없을까?
 * 위의 경우에 i를 찾아도 i의 우측에 1이 없으면 말짱 꽝이다.
 * 그렇다면 1부터 찾고나서 생각하자. 
 * 즉, 우->좌 로 스캔해가다가 1이 나오면 그때부터는 0을 찾는 것이다.
 * 0을 찾았다면(이것이 i이다) 다시 그 지점부터 좌->우 로 스캔하여 1을 찾는다. (이것이 j가 된다)
 * 이렇게 하면 O(n) 만에 i,j를 찾을 수 있다.
 * (추가)좌->우 스캔을 다시 하여 j를 찾을 필요가 없다. j는 무조건 i-1 이 된다.(조금만 생각해보면 당연하다)
 * (추가) i,j를 찾는데에는 사실 getBit 연산만 있으면 된다.
 *       위에서 구현한 4개의 find~ 함수들이 getBit 하나로 된다는 의미이다.
 * 
 * 그러나 이것이 끝이 아니다.
 * i,j를 찾았다면.. j의 우측에 있는 bit들을 마음껏[?] 재배열하여 최소화 시킬수 있다.
 * 1을 우측으로 몰고 0을 좌측으로 몰아서..
 * 예를들어보자.
 *     5 4 3 2 1 0
 * xxx 0 1 1 1 0 0
 * 1) 2에서 1 찾음. 이때부터 0을 찾기시작
 * 2) 5 에서 0 찾음. 이것이 i가 됨
 * 3) 4부터 우측방향으로 1을 찾음. 4가 j가 됨
 * 4) i 를 on,j를 off 하면 xxx 1 0 1 1 0 0 이 됨
 * 5) 이제 0~2범위를 재배열하면 xxx 1 0 0 0 1 1 이 됨
 * 
 * 비트 재배열은 우선 1의 개수를 찾고 ( O(n) )
 * 대상이 되는 bit들을 모두 0으로 만들고 ( O(n) )
 * 우측부터 시작하여 1의 개수만큼 1로 만든다 ( O(n) )
 * (추가) 재배열할때, 0의 개수만큼 0을 set 하고 1의 개수만큼 1을 set 하는 방법이 제일 깔금하다.
 *       하지만 이럴 경우 재배열 대상이 되는 bit의 수 만큼 set 연산을 하게 된다.
 *       1111 을 만들때 10000-1 로 만드는 방법을 사용하면 bit 연산의 수를 줄일 수 있다.
 *       그러나 이 경우 재배열 대상이 0으로 가득찬 경우나 1로 가득찬 경우를 예외처리 해야 함에 유의하자.
 * 
 * 따라서 전체 성능은 O(n) 이 된다.
 * 
 * 
 * 그러면 이제 바운더리 케이스를 생각해보자. (잘못된 인풋..)
 * n의 범위는 [0,2^31-1] 인데 이중에 들어와서는 안되는 인풋이 있다.
 * n이 음수가 아니므로 첫번째 bit는 무조건 0 이고 따라서 이에 대해서는 언급하지 않기로 하자.
 * 예를들어 모든 bit가(부호 bit 제외) 1로 가득찬 경우. 즉 n이 2^31-1 이면
 * nextLarge, prevSmall 을 모두 찾을수가 없다.
 * 보다 일반화 시켜보자. 언제 nextLarge, prevSmall을 찾을수가 없을까.
 * 우선 nextLarge의 경우 i>j 가 성립하는 i,j가 적어도 한 쌍 존재해야 한다.
 * 그러므로 111111000000 이런식이라면 nextLarge가 존재하지 않는다.
 * symmetric 하게, prevSmall의 경우는 0000011111 이런식이면 존재하지 않는다.
 * 그러므로 nextLarge는 1^p0^q (p,q>=0 p+q=31) 이면 존재하지 않고
 * prevSmall은 0^p1^q (p,q>=0 p+q=31) 이면 존재하지 않는다.
 * 
 * 전체 과정을 요약해보자.(nextLarge 의 경우)
 * 1. 1의 개수를 보존해야 하므로 1을 off 하면 0을 on 해야한다.
 * 2. 원래 수보다 커져야 하므로 on 하는 0의 index i 가 off 하는 1의 index j 보다 커야한다.
 * 3. 원래 수보다 최소한으로 커져야 하므로 i는 작고 j는 커야한다.
 * 4. j는 아무리 커봐야 i-1 이기 때문에 사실상 i값이 좌우한다.
 * 5. i값은 우측부터 스캔하여 찾으면 되는데, 이렇게 찾아도 우측에 1이 없으면 소용이 없으므로 1부터 찾자.
 * 6. 1이 발견되고 난 이후에 최초로 발견되는 0이 i가 된다.
 * 7. j는 무조건 i-1이 된다. 1이 최초 발견되고 난뒤, 1이 나오는 동안은 스킵하다가 0이 최초로 나오면 그게 i가 되니까.
 * 8. 이게 끝이 아니다. i,j 를 찾았다면 적절히 on,off 해주고 나서 나머지 부분을 생각해야 한다.
 * 9. 나머지 부분을 rearrange 하여 최소로 만들 수 있다. 000111 이런식으로
 * 10. 나머지 부분에서 1의 개수를 세고, 0의 수만큼 0 set, 1의 수만큼 1을 set 하면 자연스럽다.
 * 11. 위 방법보다 1000-1 = 111 이 되는 원리를 이용해도 되는데 이럴 경우 boundary case(전부1 또는 전부0)를 처리해야 한다.
 */
