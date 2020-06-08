package p303;

/**
 * @author Glory
 * @date 2020/3/6 14:19
 */
public class NumArray {

    int[] sum;

//    public NumArray(int[] nums) {
//        array = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum+=array[k];
//        }
//        return sum;
//    }


    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] data = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(data);
        int i = numArray.sumRange(0, 2);
        System.out.println(i);
    }

}
