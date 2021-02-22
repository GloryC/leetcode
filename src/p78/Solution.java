package p78;

import java.util.*;

/**
 * @author Glory
 * @date 2020/3/23 13:29
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = result.size();
            for (int j = 0; j < all; j++) {
                // 每次取出原数组，再加一个元素
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        Solution solution2 = new Solution();
        List<List<Integer>> res = solution2.subsets(data);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> tem = res.get(i);
            for (int j = 0; j < tem.size(); j++) {
                System.out.print(tem.get(j) + " ");
            }
            System.out.println();
        }
    }

}
