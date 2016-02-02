package osy.algorithm;

/**
 * Created by maxwell on 2016-02-02.
 */
public class ReplaceSpace {
    public static void replaceSpace(char[] str, int strLength) {
        int resultLength = strLength;
        for (int i = 0; i < strLength; ++i) {
            if (str[i] == ' ') resultLength += 2;
        }
        
        int i = strLength - 1;
        int j = resultLength - 1;
        
        while (i >= 0 && j >= 0) {
            if (str[i] != ' ') {
                str[j--] = str[i--];
            } else {
                str[j--] = '0';
                str[j--] = '2';
                str[j--] = '%';
                i--;
            }
        }
        
        if (!(i == -1 && j == -1)) {
            throw new RuntimeException("알고리즘 잘못짠듯");
        }
    }
}
