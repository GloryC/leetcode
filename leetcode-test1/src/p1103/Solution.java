package p1103;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/5 16:07
 */
public class Solution {

    /**
     * 分糖果
     *
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] results = new int[num_people];
        int now = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies > now) {
                    results[i] += now;
                    candies -= now;
                    now++;
                } else {
                    results[i] += candies;
                    candies = 0;
                    break;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] results = s.distributeCandies(10, 3);
        System.out.println(Arrays.toString(results));
    }

}
