package test3;

import interview3._2016_02_02_CountTwo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by maxwell on 2016-02-02.
 */
public class Test_2016_02_02_CountTwo {
    @Test
    public void testCountTwoA1() {
        int n = 1;        
        assertEquals(0, _2016_02_02_CountTwo.countTwo(n));
    }

    @Test
    public void testCountTwoA2() {
        int n = 2;
        assertEquals(1, _2016_02_02_CountTwo.countTwo(n));
    }

    @Test
    public void testCountTwoA3() {
        int n = 22;
        assertEquals(6, _2016_02_02_CountTwo.countTwo(n));
    }

    @Test
    public void testCountTwoB1() {
        int n = 1;
        assertEquals(0, _2016_02_02_CountTwo.countTwo2(n));
    }

    @Test
    public void testCountTwoB2() {
        int n = 2;
        assertEquals(1, _2016_02_02_CountTwo.countTwo2(n));
    }

    @Test
    public void testCountTwoB3() {
        int n = 22;
        assertEquals(6, _2016_02_02_CountTwo.countTwo2(n));
    }

    @Test
    public void testCountTwoAandB() {
        int n = 0;
        try {
            for (; n <= 50000; ++n) {
                if (n % 5000 == 0) {
                    System.out.println("n=" + n);
                }
                assertEquals(_2016_02_02_CountTwo.countTwo(n), _2016_02_02_CountTwo.countTwo2(n));
            }
        } catch(Exception e) {
            System.out.println(e);
            System.out.println("n=" + n);
        }
    }

    @Test
    public void testCountTwoAPerformance() {
        System.out.println("---- O(n) solution ----");
        for (int i = 0; i <= 10000000; i += 100000) {
            long startTime = System.currentTimeMillis();
            _2016_02_02_CountTwo.countTwo(i);
            long endTime = System.currentTimeMillis();
            System.out.println("n=" + i + ": " + (endTime - startTime) + " ms");
        }
        
        System.out.println();
        System.out.println("---- O(log n) solution ----");
        for (int i = 0; i <= 10000000; i += 100000) {
            long startTime = System.currentTimeMillis();
            _2016_02_02_CountTwo.countTwo2(i);
            long endTime = System.currentTimeMillis();;
            System.out.println("n=" + i + ": " + (endTime - startTime) + " ms");
        }
    }
}
