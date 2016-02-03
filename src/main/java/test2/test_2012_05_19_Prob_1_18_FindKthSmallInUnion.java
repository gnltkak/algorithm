package test2;

import static org.junit.Assert.*;
import interview2._2012_05_19_Prob_1_18_FindKthSmallInUnion;

import org.junit.Test;

public class test_2012_05_19_Prob_1_18_FindKthSmallInUnion {
	@Test
	public void testFindKthSmallInUnion1() throws Exception {
		int[] a = {0};
		int[] b = {0};
		int k = 1;
		int expected = 0;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion2() throws Exception {
		int[] a = {0};
		int[] b = {0};
		int k = 2;
		int expected = 0;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion3() throws Exception {
		int[] a = {1,1,1};
		int[] b = {2};
		int k = 1;
		int expected = 1;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion4() throws Exception {
		int[] a = {1,1,1};
		int[] b = {2};
		int k = 2;
		int expected = 1;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion5() throws Exception {
		int[] a = {1,1,1};
		int[] b = {2};
		int k = 3;
		int expected = 1;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion6() throws Exception {
		int[] a = {1,1,1};
		int[] b = {2};
		int k = 4;
		int expected = 2;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion7() throws Exception {
		int[] a = {1,2,3,4};
		int[] b = {0,5,6,7,8,9,10};
		int k = 1;
		int expected = 0;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion8() throws Exception {
		int[] a = {1,2,3,4};
		int[] b = {0,5,6,7,8,9,10};
		int k = 2;
		int expected = 1;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion9() throws Exception {
		int[] a = {1,2,3,4};
		int[] b = {0,5,6,7,8,9,10};
		int k = 9;
		int expected = 8;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion10() throws Exception {
		int[] a = {1,2,3,4};
		int[] b = {0,5,6,7,8,9,10};
		int k = 11;
		int expected = 10;
		int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindKthSmallInUnion11() throws Exception {
		int[] a = {1,2,3,4};
		int[] b = {5,6};
		int[] k = {1,2,3,4,5,6};
		int[] expected = {1,2,3,4,5,6};
		for (int i = 0; i < k.length; ++i) {
			int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k[i]);
			assertEquals(expected[i], actual);
		}
	}
	
	@Test
	public void testFindKthSmallInUnion12() throws Exception {
		int[] a = {5,6};
		int[] b = {1,2,3,4};
		int[] k = {1,2,3,4,5,6};
		int[] expected = {1,2,3,4,5,6};
		for (int i = 0; i < k.length; ++i) {
			int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k[i]);
			assertEquals(expected[i], actual);
		}
	}
	
	@Test
	public void testFindKthSmallInUnion13() throws Exception {
		int[] a = {1};
		int[] b = {1,1};
		int[] k = {1,2,3};
		int[] expected = {1,1,1};
		for (int i = 0; i < k.length; ++i) {
			int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k[i]);
			assertEquals(expected[i], actual);
		}
	}
	
	@Test
	public void testFindKthSmallInUnion14() throws Exception {
		int[] a = {1,2,3,4,5};
		int[] b = {2,4,6};
		int[] k = {3,4,5,6};
		int[] expected = {2,3,4,4};
		for (int i = 0; i < k.length; ++i) {
			int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k[i]);
			assertEquals(expected[i], actual);
		}
	}
	
	@Test
	public void testFindKthSmallInUnion15() throws Exception {
		int[] a = {1,1,1,2};
		int[] b = {1};
		int[] k = {2};
		int[] expected = {1};
		for (int i = 0; i < k.length; ++i) {
			int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k[i]);
			assertEquals(expected[i], actual);
		}
	}
	
	@Test
	public void testFindKthSmallInUnion16() throws Exception {
		int[] a = {5,6,7,8,9};
		int[] b = {1,2,3};
		int[] k = {1,2,3,4,5,6,7,8};
		int[] expected = {1,2,3,5,6,7,8,9};
		for (int i = 0; i < k.length; ++i) {
			int actual = _2012_05_19_Prob_1_18_FindKthSmallInUnion.findKthSamllInUnion(a, b, k[i]);
			assertEquals(expected[i], actual);
		}
	}
}
