package p303;

/**
 * @author Glory
 * @date 2020/3/6 14:19
 */
public class NumArray {

    private int[] sum;

    /**
     * 使用前缀和
     */
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
