package p207;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2020/8/4 8:31
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 0}, {0, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.canFinish(2, data));
    }

}
