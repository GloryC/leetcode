package p997;

/**
 * @author Glory
 * @date 2020/6/28 16:35
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] people = new int[n + 1][2];
        for (int[] person : trust) {
            int out = person[0]; // out degree
            int in = person[1];  // in degree
            people[out][0]++;
            people[in][1]++;
        }

        for (int i = 1; i <= n; i++) {
            if (people[i][0] == 0 && people[i][1] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {
                {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}
        };
        Solution solution = new Solution();
        System.out.println(solution.findJudge(4, trust));
    }
}
