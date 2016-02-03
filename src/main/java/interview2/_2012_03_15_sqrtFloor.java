package interview2;

public class _2012_03_15_sqrtFloor {
	private static long sqrtFloor(long n, long l, long r) {
		checkUint32Validity(n);
		checkUint32Validity(l);
		checkUint32Validity(r);

	    long m = (l+r)/2;	    
	    checkUint32Validity(m);
	    //System.out.println("l, r, m = " + l + ", " + r + ", " + m);
	    
	    if (l >= r) {
	       throw new RuntimeException("Algorithm failure");
	    }
	    
	    if (r-l == 1) {
	    	if (n == l*l) return l;
	    	if (n == r*r) return r;
	        if (n < l*l) return l-1;
	        if (n > r*r) return r;
	        return l;
	    }
	    if (n > m*m) {
	        return sqrtFloor(n, m, r);
	    }
	    return sqrtFloor(n, l, m);
	}

	private static void checkUint32Validity(long n) {
		if ((n < 0) || (n > (((long)1)<<32) - 1))
			throw new RuntimeException("invalid uint32 value:" + n);
	}

	public static long sqrtFloor(long n) {
		//return sqrtFloorTextbook(n);
		//return sqrtFloor(n, 0, (1<<16)-1);
		return sqrtFloorClean(n, 0, (1<<16)-1);
	}
	
	//////////////////////////////////////////////
	public static long sqrtFloorTextbook(long input) {
		int begin = 0;
		int end = 65536;
		while (begin + 1 < end) {
			int mid = begin + (end - begin)/2;
		    System.out.println("begin, end, mid = " + begin + ", " + end + ", " + mid);
		    
			long mid_sqr = mid * mid;
			if (mid_sqr == input)
				return mid;
			if (mid_sqr > input)
				end = mid;
			else
				begin = mid;
		}		
		return begin;
	}
	
	////////////////////////////////////////////////
	public static long sqrtFloorClean(long n, long l, long r) {
		if (l == r) return l;
		if (r - l == 1) {
			if (n >= r * r) return r;
			else return l;
		}
		long m = (l + r) / 2;
		if (n == m * m) return m;
		if (n < m * m) return sqrtFloorClean(n, l, m);
		return sqrtFloorClean(n, m, r);
	}
}
