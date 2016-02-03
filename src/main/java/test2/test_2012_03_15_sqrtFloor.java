package test2;

import static org.junit.Assert.*;
import interview2._2012_03_15_sqrtFloor;

import org.junit.Test;

public class test_2012_03_15_sqrtFloor {
	@Test
	public void testSqrtFloor1() throws Exception {
		long n = 0;
		long expected = 0;
		long actual = _2012_03_15_sqrtFloor.sqrtFloor(n); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSqrtFloor2() throws Exception {
		long n = (((long)1)<<32)-1;
		long expected = 65535;
		long actual = _2012_03_15_sqrtFloor.sqrtFloor(n); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSqrtFloor3() throws Exception {
		// 이 test는 시간이 매우 많이 걸리니 유의 바람.(i3 쿼드코어에서 10분 정도)
		for (long i = 0; i < ((long)1)<<32; ++i) {
			if (i%10000000 == 0)
				System.out.println("i="+i);
			long expected = (long)(Math.floor(Math.sqrt(i)));
			long actual = _2012_03_15_sqrtFloor.sqrtFloor(i); 
			assertEquals(expected, actual);
		}
	}
}
