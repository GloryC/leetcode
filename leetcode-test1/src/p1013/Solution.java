package p1013;

/**
 * @author Glory
 * @date 2020/3/11 0:35
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int value : a) {
            sum += value;
        }

        int divide;
        if (sum % 3 != 0) return false;
        else divide = sum / 3;

        sum = 0;
        for (int i = 0; i < a.length; i++) {
            if ((sum += a[i]) == divide) {
                sum = 0;
                for (int j = i + 1; j < a.length - 1; j++) {
                    if ((sum += a[j]) == divide) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(data));
    }

}
