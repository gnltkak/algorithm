package osy.test;

import org.junit.*;
import osy.algorithm.CountTwo;

/**
 * Created by maxwell on 2016-02-02.
 */
public class CountTwoTest {
    @Test
    public void testCountTwo1() {
        int n = 1;        
        Assert.assertEquals(0, CountTwo.countTwo(n));
    }

    @Test
    public void testCountTwo2() {
        int n = 2;
        Assert.assertEquals(1, CountTwo.countTwo(n));
    }

    @Test
    public void testCountTwo3() {
        int n = 22;
        Assert.assertEquals(6, CountTwo.countTwo(n));
    }
}
