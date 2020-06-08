package p945;

/**
 * @author Glory
 * @date 2020/3/22 1:01
 */
public class Solution {

    public int minIncrementForUnique(int[] a) {
        if (a.length == 1) return 0;
        int[] data = new int[50005];
        for (int i = 0; i < a.length; i++) {
            data[a[i]]++;
        }

        int move = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 1) {
                int index = i;
                for (int j = 1; j < data[i]; j++) {
                    for (int k = index; k < data.length; k++) {
                        if (data[k] == 0) {
                            data[k] = 1;
                            move += k - i;
                            index = k;
                            break;
                        }
                    }
                }
            }
        }
        return move;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {3, 2, 1, 2, 1, 7};
        System.out.println(solution.minIncrementForUnique(data));
    }

}
