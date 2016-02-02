package osy.algorithm;

/**
 * Created by maxwell on 2016-02-02.
 */
public class CountTwo {
    public static int countTwo(int n) {
        if (n == 1) return 0;
        return countTwo(n - 1) + countTwoOneNumber(n);
    }
    
    private static int countTwoOneNumber(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 2) ++count;
            num /= 10;
        }
        return count;
    }
}
