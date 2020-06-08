package p945;

/**
 * @author Glory
 * @date 2020/3/22 1:01
 */
public class Solution2 {

    public int minIncrementForUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] status =  new int[50000];
        int counts = 0;

        for(int num : nums) {
            status[num]++;
        }

        for(int i = 0; i < 50000; i++) {
            if(status[i] > 1) {
                int expect = status[i] - 1;
                counts += expect;
                status[i + 1] += expect;
                status[i] = 1;
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] data = {3, 2, 1, 2, 1, 7};
        System.out.println(solution.minIncrementForUnique(data));
    }

}
