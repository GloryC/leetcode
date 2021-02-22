package p841;

import java.util.List;

/**
 * @author Glory
 * @date 2020/6/29 16:30
 */
public class Solution2 {
    private boolean[] visited;
    private int num;

    /**
     * DFS
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        visited = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        visited[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!visited[it]) {
                dfs(rooms, it);
            }
        }
    }
}
