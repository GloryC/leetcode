package p191;

/**
 * @author Glory
 * @date 2020/3/8 23:01
 */
public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i = 1;
        int count = 0;
        while (n != 0) {
            if ((n & i) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

}
