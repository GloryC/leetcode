package p11;

/**
 * @author Glory
 * @date 2020/4/16 20:54
 */
public class Solution {

    /**
     * 双指针法
     */
    public int maxArea(int[] height) {
        if (height.length <= 1) return -1;
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            // 向内收窄短板·
            if (height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(data));
    }

}
