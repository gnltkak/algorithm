package test;

import static org.junit.Assert.*;
import interview._2011_01_28_NextLargeSmallSameBitOne;

import org.junit.Test;

import util.Util;

public class Test_2011_01_28_NextLargeSmallSameBitOne {
	private int numOfBitOne(int n) {
		int cnt = 0;
		int mask = 1;
		while(mask>0)
		{
			if((mask&n)!=0)
				cnt++;
			mask = mask << 1;
		}
		return cnt;
	}
	
	private int nextLargeNaive(int n) {
		int result = n + 1;
		int oneBitCnt = numOfBitOne(n);
		while(numOfBitOne(result)!=oneBitCnt)
			result++;
		return result;
	}
	
	private int prevSmallNaive(int n) {
		int result = n - 1;
		int oneBitCnt = numOfBitOne(n);
		while(numOfBitOne(result)!=oneBitCnt)
			result--;
		return result;
	}
	
	@Test
	public void testNextLarge1() {
		int n = 0x5;
		int expected = 0x6;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNextLarge2() {
		int n = 0x8;
		int expected = 0x10;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNextLarge3() {
		int n = 0xb;
		int expected = 0xd;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNextLarge4() {
		int n = 0x1c;
		int expected = 0x23;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testNextLarge5() {
		int[] n = Util.makeRandIntArr(1000, Integer.MAX_VALUE, true);
		
		for(int i=0;i<n.length;i++)
		{
			//i가 valid 한지 검사
			boolean valid = true;
			
			for(int j=0;j<=31;j++)
			{				
				int invalid1 = (1<<j)-1;
				int invalid2 = ~invalid1;
				
				if(n[i]==invalid1 || n[i]==invalid2)
				{
					valid = false;
					break;
				}
			}
			if(!valid)
				continue;
			
			int expected = nextLargeNaive(n[i]);
			int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge(n[i]);
			assertEquals(expected,actual);
		}
	}
	
	@Test
	public void testPrevSmall1() {
		int n = 0x5;
		int expected = 0x3;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.prevSmall(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPrevSmall2() {
		int n = 0x8;
		int expected = 0x4;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.prevSmall(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPrevSmall3() {
		int n = 0xb;
		int expected = 0x7;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.prevSmall(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPrevSmall4() {
		int n = 0x23;
		int expected = 0x1c;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.prevSmall(n);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPrevSmall5() {
		int[] n = Util.makeRandIntArr(1000, Integer.MAX_VALUE, true);
		
		for(int i=0;i<n.length;i++)
		{
			//i가 valid 한지 검사
			boolean valid = true;
			
			for(int j=0;j<=31;j++)
			{				
				int invalid1 = (1<<j)-1;
				int invalid2 = ~invalid1;
				
				if(n[i]==invalid1 || n[i]==invalid2)
				{
					valid = false;
					break;
				}
			}
			if(!valid)
				continue;
			
			int expected = prevSmallNaive(n[i]);
			int actual = _2011_01_28_NextLargeSmallSameBitOne.prevSmall(n[i]);
			assertEquals(expected,actual);
		}
	}

	@Test
	public void testNextLarge6() {
		int n = 0x5;
		int expected = 0x6;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testNextLarge7() {
		int n = 0x8;
		int expected = 0x10;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testNextLarge8() {
		int n = 0xb;
		int expected = 0xd;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testNextLarge9() {
		int n = 0x1c;
		int expected = 0x23;
		int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge2(n);
		assertEquals(expected,actual);
	}

	@Test
	public void testNextLarge10() {
		int[] n = Util.makeRandIntArr(1000, Integer.MAX_VALUE, true);

		for(int i=0;i<n.length;i++)
		{
			//i가 valid 한지 검사
			boolean valid = true;

			for(int j=0;j<=31;j++)
			{
				int invalid1 = (1<<j)-1;
				int invalid2 = ~invalid1;

				if(n[i]==invalid1 || n[i]==invalid2)
				{
					valid = false;
					break;
				}
			}
			if(!valid)
				continue;

			int expected = nextLargeNaive(n[i]);
			int actual = _2011_01_28_NextLargeSmallSameBitOne.nextLarge2(n[i]);
			assertEquals(expected,actual);
		}
	}
}
