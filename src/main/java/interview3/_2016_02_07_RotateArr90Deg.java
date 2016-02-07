package interview3;

/**
 * Created by osy on 2016-02-07.
 */
public class _2016_02_07_RotateArr90Deg {
    public static void rotateArr90Deg(int[][] arr) {
        int n = arr.length;
        int allStep = n - 2;
        if (n == 2) allStep = 1;
        
        int s = 0;        
        for(; s < allStep; ++s) {
            int i = s;
            int j = n - 1 - s;
            while (i < j) {
                swap3(arr, i , j);
                --j;
            }
            
        }
    }

    private static void swap3(int[][] arr, int i, int j) {
        int n = arr.length;
        
        int p = i;
        int q = j;
        int p2 = n - 1 - q;
        int q2 = p;
        
        for (int k = 0; k < 3; ++k) {
            int temp = arr[p][q];
            arr[p][q] = arr[p2][q2];
            arr[p2][q2] = temp;
            
            p = p2;
            q = q2;
            p2 = n - 1 - q;
            q2 = p;
        }
    }
}
