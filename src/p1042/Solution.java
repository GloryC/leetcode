package p1042;

import java.util.*;

/**
 * @author Glory
 * @date 2020/6/28 16:45
 */
public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        // 初始化路径信息
        for (int[] path : paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // 查看当前节点的所有邻接点的色彩
            boolean[] used = new boolean[5];
            for (int adj : graph.get(i)) {
                used[res[adj]] = true;
            }

            // 为当前节点染色
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] paths = {
                {1, 2}, {2, 3}, {3, 1}
        };
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.gardenNoAdj(3, paths)));
    }
}
