package test2;

import static org.junit.Assert.*;
import interview2._2012_05_19_Prob3_2_RiverCross;

import org.junit.Test;

public class test_2012_05_19_Prob3_2_RiverCross {
	@Test
	public void testRiverCross1() throws Exception {
		boolean[] stone = {false, true};
		boolean expected = false;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross2() throws Exception {
		boolean[] stone = {false, false};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross3() throws Exception {
		boolean[] stone = {false, false, true};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross4() throws Exception {
		boolean[] stone = {false, false, false};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross5() throws Exception {
		boolean[] stone = {false, false, true, false};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross6() throws Exception {
		boolean[] stone = {false, false, false, true};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross7() throws Exception {
		boolean[] stone = {false, false, true, true};
		boolean expected = false;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross8() throws Exception {
		boolean[] stone = {false, false, false, true, true, false};
		boolean expected = false;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross9() throws Exception {
		boolean[] stone = {false, false, false, false, true, true};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross10() throws Exception {
		boolean[] stone = {false, false, false, false, true, false, true, false, true};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRiverCross11() throws Exception {
		boolean[] stone = {false, false, true, false, true, true, false, true, true, true, false};
		boolean expected = true;
		boolean actual = _2012_05_19_Prob3_2_RiverCross.reachable(stone);
		assertEquals(expected, actual);
	}
}
