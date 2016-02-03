package osy.test;

import org.junit.Assert;
import org.junit.Test;
import osy.algorithm.ReplaceSpace;

/**
 * Created by maxwell on 2016-02-02.
 */
public class _2016_02_02_ReplaceSpaceTest {
    @Test
    public void testReplaceSpace1() {
        String str = "";
        String resultTobe = "";
        
        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);                    
        }
        
        ReplaceSpace.replaceSpace(strArr, str.length());
        
        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace2() {
        String str = " ";
        String resultTobe = "%20";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace3() {
        String str = "a ";
        String resultTobe = "a%20";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace4() {
        String str = " a";
        String resultTobe = "%20a";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace5() {
        String str = " a ";
        String resultTobe = "%20a%20";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace6() {
        String str = "a b";
        String resultTobe = "a%20b";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace7() {
        String str = "a b cde";
        String resultTobe = "a%20b%20cde";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }

    @Test
    public void testReplaceSpace8() {
        String str = "a b  cde";
        String resultTobe = "a%20b%20%20cde";

        char[] strArr = new char[str.length() * 10];
        for (int i = 0; i < str.length(); ++i) {
            strArr[i] = str.charAt(i);
        }
        ReplaceSpace.replaceSpace(strArr, str.length());

        Assert.assertEquals(resultTobe, String.copyValueOf(strArr).trim());
    }
}
