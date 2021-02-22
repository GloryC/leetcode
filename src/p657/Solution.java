package p657;

/**
 * @author zhanggc
 * @date 2020/8/28 8:31
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int[] counts = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'R':
                    counts[0]++;
                    break;
                case 'L':
                    counts[1]++;
                    break;
                case 'U':
                    counts[2]++;
                    break;
                case 'D':
                    counts[3]++;
                    break;
                default:
                    break;
            }
        }
        return counts[0] == counts[1] && counts[2] == counts[3];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("LL"));
    }
}
