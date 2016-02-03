package test2;

import static org.junit.Assert.*;
import interview2._2012_05_19_Prob1_22_SalaryDecrease;

import org.junit.Test;

public class test_2012_05_19_Prob1_22_SalaryDecrease {
	@Test
	public void testSalaryDecrease1() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 210;
		int expected = 60;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease2() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 280;
		int expected = 100;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease3() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 0;
		int expected = 0;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease4() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 100;
		int expected = 20;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease5() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 50;
		int expected = 10;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease6() throws Exception {
		int[] s = {10, 20};
		int wanna_be_sum = 0;
		int expected = 0;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease7() throws Exception {
		int[] s = {10, 20};
		int wanna_be_sum = 30;
		int expected = 20;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease8() throws Exception {
		int[] s = {10, 20};
		int wanna_be_sum = 15;
		int expected = -1;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease9() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 34;
		int expected = -1;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease10() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 143;
		int expected = 31;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease11() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 144;
		int expected = -1;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease12() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 145;
		int expected = -1;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
	
	public void testSalaryDecrease13() throws Exception {
		int[] s = {20, 30, 40, 90, 100};
		int wanna_be_sum = 146;
		int expected = 32;
		int actual = _2012_05_19_Prob1_22_SalaryDecrease.findSalaryUpperBound(s, wanna_be_sum);
		assertEquals(expected, actual);
	}
}
