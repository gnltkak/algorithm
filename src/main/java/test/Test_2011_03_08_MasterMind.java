package test;

import static org.junit.Assert.*;
import interview._2011_03_08_MasterMind;

import org.junit.Test;

public class Test_2011_03_08_MasterMind {
	@Test
	public void testMasterMind1() {
		String solution = "RRRR";
		String guess="RRRR";
		String expected="4,0";		
		String actual = _2011_03_08_MasterMind.masterMind(solution, guess);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMasterMind2() {
		String solution = "RGBY";
		String guess="GRYB";
		String expected="0,4";		
		String actual = _2011_03_08_MasterMind.masterMind(solution, guess);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMasterMind3() {
		String solution = "RGGB";
		String guess="YYYG";
		String expected="0,2";		
		String actual = _2011_03_08_MasterMind.masterMind(solution, guess);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMasterMind4() {
		String solution = "YGRB";
		String guess="YYGG";
		String expected="1,1";		
		String actual = _2011_03_08_MasterMind.masterMind(solution, guess);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMasterMind5() {
		String solution = "GYRB";
		String guess="GRRY";
		String expected="2,1";		
		String actual = _2011_03_08_MasterMind.masterMind(solution, guess);
		assertEquals(expected, actual);
	}

	@Test
	public void testMasterMind6() {
		String solution = "RRRR";
		String guess="RRRR";
		String expected="4,0";
		String actual = _2011_03_08_MasterMind.masterMind3(solution, guess);
		assertEquals(expected, actual);
	}

	@Test
	public void testMasterMind7() {
		String solution = "RGBY";
		String guess="GRYB";
		String expected="0,4";
		String actual = _2011_03_08_MasterMind.masterMind3(solution, guess);
		assertEquals(expected, actual);
	}

	@Test
	public void testMasterMind8() {
		String solution = "RGGB";
		String guess="YYYG";
		String expected="0,2";
		String actual = _2011_03_08_MasterMind.masterMind3(solution, guess);
		assertEquals(expected, actual);
	}

	@Test
	public void testMasterMind9() {
		String solution = "YGRB";
		String guess="YYGG";
		String expected="1,1";
		String actual = _2011_03_08_MasterMind.masterMind3(solution, guess);
		assertEquals(expected, actual);
	}

	@Test
	public void testMasterMind10() {
		String solution = "GYRB";
		String guess="GRRY";
		String expected="2,1";
		String actual = _2011_03_08_MasterMind.masterMind3(solution, guess);
		assertEquals(expected, actual);
	}
}