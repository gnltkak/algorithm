package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Bitmap;

public class Test_Bitmap {
	@Test
	public void testBitmapInit1() {	
		Bitmap bm = new Bitmap(10);
		String expected = "[0~] 0000000000";
		String actual = bm.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBitmapInit2() {		
		Bitmap bm = new Bitmap(4);
		String expected = "[0~] 0000";
		String actual = bm.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBitmapInit3() {		
		Bitmap bm = new Bitmap(32);
		String expected = "[0~] 0000000000\n[10~] 0000000000\n[20~] 0000000000\n[30~] 00";
		String actual = bm.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBitmapInit4() {		
		Bitmap bm = new Bitmap(33);
		String expected = "[0~] 0000000000\n[10~] 0000000000\n[20~] 0000000000\n[30~] 000";
		String actual = bm.toString();
		assertEquals(expected,actual);
	}	

	@Test
	public void testBitmapClear() {		
		Bitmap bm = new Bitmap(33);
		bm.set(1);
		bm.set(10);
		bm.clear();
		String expected = "[0~] 0000000000\n[10~] 0000000000\n[20~] 0000000000\n[30~] 000";
		String actual = bm.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBitmapSet() {
		Bitmap bm = new Bitmap(35);
		for(int i=0;i<bm.size();i++)
			bm.set(i);
		bm.set(21);
		
		String expected = "[0~] 1111111111\n[10~] 1111111111\n[20~] 1111111111\n[30~] 11111";
		String actual = bm.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBitmapReset() {
		Bitmap bm = new Bitmap(35);
		for(int i=0;i<bm.size();i++)
			bm.set(i);
		
		bm.reset(0);
		bm.reset(1);
		bm.reset(31);
		bm.reset(0);
		
		String expected = "[0~] 0011111111\n[10~] 1111111111\n[20~] 1111111111\n[30~] 10111";		
		String actual = bm.toString();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testBitmapIsSet() {
		Bitmap bm = new Bitmap(35);
		for(int i=0;i<bm.size();i++)
			bm.set(i);
		
		bm.reset(0);
		bm.reset(1);
		bm.reset(31);
		bm.reset(0);		
		
		assertEquals(bm.isSet(0),false);
		assertEquals(bm.isSet(1),false);
		assertEquals(bm.isSet(31),false);
		assertEquals(bm.isSet(2),true);
		assertEquals(bm.isSet(12),true);
	}
}
