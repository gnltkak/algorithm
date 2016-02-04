package inerview3;

/**
 * Created by maxwell on 2016-02-02.
 */
// [0, n] 에 포함된 2의 개수 세기. Note: 22의 2는 2개로 세어야 함
public class _2016_02_02_CountTwo {
    // O(n) solution
    public static int countTwo(int n) {
        if (n <= 1) return 0;
        
        int temp = 0;
        int count = 0;
        
        for (int i = 2; i <= n; ++i) {
            count = temp + countTwoOneNumber(i);
            temp = count;           
        }
        return count;
    }

    private static int countTwoOneNumber(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 2) ++count;
            num /= 10;
        }
        return count;
    }
    
    // O(log n) solution
    public static int countTwo2(int n) {
        if (n <= 1) return 0;
        if (n <= 9) return 1;
        
        if (n % 10 == 9) {  // [0, n] 의 개수가 10의 배수
            return 10 * countTwo2(n / 10) + (n / 10 + 1);    
        }
        
        int d = n - (n % 10 + 1);
        int count = countTwo2(d) + (n - d) * countTwoOneNumber(d + 1);
        if (n % 10 >= 2) {
            count += 1;
        }
        return count;
    }    
}
