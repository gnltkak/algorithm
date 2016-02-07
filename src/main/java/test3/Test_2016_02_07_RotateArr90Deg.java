package test3;

import interview3._2016_02_07_RotateArr90Deg;
import org.junit.Test;
import static org.junit.Assert.*;

import util.Util;

/**
 * Created by maxwell on 2016-02-02.
 */
public class Test_2016_02_07_RotateArr90Deg {
    @Test
    public void testRotateArr90Deg1() {
        int[][] arr = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        
        int[][] expected = new int[][] {
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5}
        };
        
        _2016_02_07_RotateArr90Deg.rotateArr90Deg(arr);
       
        assertEquals(Util.arrayToString(expected, " ", "\n"), Util.arrayToString(arr, " ", "\n"));
    }

    @Test
    public void testRotateArr90Deg2() {
        int[][] arr = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        int[][] expected = new int[][] {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4},
        };

        _2016_02_07_RotateArr90Deg.rotateArr90Deg(arr);

        assertEquals(Util.arrayToString(expected, " ", "\n"), Util.arrayToString(arr, " ", "\n"));
    }

    @Test
    public void testRotateArr90Deg3() {
        int[][] arr = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}              
        };

        int[][] expected = new int[][] {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        _2016_02_07_RotateArr90Deg.rotateArr90Deg(arr);

        assertEquals(Util.arrayToString(expected, " ", "\n"), Util.arrayToString(arr, " ", "\n"));
    }

    @Test
    public void testRotateArr90Deg4() {
        int[][] arr = new int[][] {
                {1, 2},
                {3, 4},
        };

        int[][] expected = new int[][] {
                {3, 1},
                {4, 2},
        };

        _2016_02_07_RotateArr90Deg.rotateArr90Deg(arr);

        assertEquals(Util.arrayToString(expected, " ", "\n"), Util.arrayToString(arr, " ", "\n"));
    }

    @Test
    public void testRotateArr90Deg5() {
        int[][] arr = new int[][] {
                {1}                
        };

        int[][] expected = new int[][] {
                {1}
        };

        _2016_02_07_RotateArr90Deg.rotateArr90Deg(arr);

        assertEquals(Util.arrayToString(expected, " ", "\n"), Util.arrayToString(arr, " ", "\n"));
    }
}
