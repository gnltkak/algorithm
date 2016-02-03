package interview;

/*
 * input : integer n,m,i,j
 * find : n의 bit position i~j 에 m을 집어넣기
 * ex) n= 101001, m= 101, i=2,j=4 이면
 *     결과는 110101이 되어야함      
 */
public class _2011_02_01_UpdateBits {
	public static int updateBits(int n,int m,int i,int j) {
		for(int k=i;k<=j;k++)
			n = setBit(n,k,getBit(m,k-i));
		return n;
	}
	
	private static int setBit(int n, int i, boolean isOne) {
		int mask = 1<<i;
		if(isOne)
			return n | mask;
		else
			return n & (~mask);
	}

	private static boolean getBit(int n, int i) {
		int mask = 1<<i;
		return (n&mask)!=0;
	}

	/////////////////////////////////////////////////////
	
	public static int updateBitsOptimal(int n,int m,int i,int j) {
		/*
		int mask = (1<<i)-1;
		mask += 0xffffffff << (j+1);
		n &= mask;
		n |= m << i;
		return n;
		*/		
		int mask = ~(((1 << (j - i + 1)) - 1) << i);
		return (n & mask) | (m << i);	
	}
}

/*
 * optimal solution에서 눈여겨볼 점은 111110000 이런걸 만드는 방법 뿐이다.
 */
