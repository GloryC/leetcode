package p1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Glory
 * @date 2020/6/1 8:42
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;
        for (int candy : candies)
            max = Math.max(max, candy);
        extraCandies = max - extraCandies;
        for (int candy : candies)
            list.add(candy >= extraCandies);
        return list;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        Solution solution = new Solution();
        System.out.println(solution.kidsWithCandies(candies, 3));
    }
}
