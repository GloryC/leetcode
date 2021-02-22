package lcp1;

/**
 * @author Glory
 * @date 2019/10/15 9:07
 */
public class Solution {

    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

}
