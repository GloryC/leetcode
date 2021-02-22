package p283;

/**
 * @author Glory
 * @date 2019/10/22 10:56
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                if(i>index){
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }

}
