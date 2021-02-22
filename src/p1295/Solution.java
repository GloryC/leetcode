package p1295;

/**
 * @author Glory
 * @date 2020/3/26 14:34
 */
public class Solution {

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (even(nums[i])) count++;
        }
        return count;
    }

    private static boolean even(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        int[] data = {555, 901, 482, 1771};
        Solution solution = new Solution();
        System.out.println(solution.findNumbers(data));
    }

}
