package test;

import static org.junit.Assert.*;
import interview._2011_03_02_IntegerAdd;

import org.junit.Test;

public class Test_2011_03_02_IntegerAdd {
	@Test
	public void testIntegerAdd1() {
		int n1=0;
		int n2=0;
		
		int expected = n1+n2;
		int actual = _2011_03_02_IntegerAdd.add(n1,n2);
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testIntegerAdd2() {
		int n1=-100;
		int n2=-1000;
		
		int expected = n1+n2;
		int actual = _2011_03_02_IntegerAdd.add(n1,n2);
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testIntegerAdd3() {
		int n1=124697124;
		int n2=123123;
		
		int expected = n1+n2;
		int actual = _2011_03_02_IntegerAdd.add(n1,n2);
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testIntegerAdd4() {
		int n1=-124697124;
		int n2=123123;
		
		int expected = n1+n2;
		int actual = _2011_03_02_IntegerAdd.add(n1,n2);
		assertEquals(expected,actual);		
	}
	
	@Test
	public void testIntegerAdd5() {
		int n1=124697124;
		int n2=-123123;
		
		int expected = n1+n2;
		int actual = _2011_03_02_IntegerAdd.add(n1,n2);
		assertEquals(expected,actual);		
	}
}
