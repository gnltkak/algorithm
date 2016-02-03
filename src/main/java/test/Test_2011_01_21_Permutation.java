package test;

import static org.junit.Assert.*;
import interview._2011_01_21_Permutation;

import org.junit.Test;

public class Test_2011_01_21_Permutation {
	@Test
	public void testPermutation1() {		
		int[] array = new int[] {1,2,3,4};
		String expected = "1,2,3,4\n1,2,4,3\n1,3,2,4\n1,3,4,2\n1,4,3,2\n1,4,2,3\n2,1,3,4\n2,1,4,3\n2,3,1,4\n2,3,4,1\n2,4,3,1\n2,4,1,3\n3,2,1,4\n3,2,4,1\n3,1,2,4\n3,1,4,2\n3,4,1,2\n3,4,2,1\n4,2,3,1\n4,2,1,3\n4,3,2,1\n4,3,1,2\n4,1,3,2\n4,1,2,3\n";
		String actual = _2011_01_21_Permutation.makePermutation(array);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPermutation2() {		
		int[] array = new int[] {1};
		String expected = "1\n";
		String actual = _2011_01_21_Permutation.makePermutation(array);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testPermutation3() {		
		int[] array = new int[] {1,2,3};
		String expected = "1,2,3\n1,3,2\n2,1,3\n2,3,1\n3,2,1\n3,1,2\n";
		String actual = _2011_01_21_Permutation.makePermutation(array);
		
		assertEquals(expected,actual);
	}
}