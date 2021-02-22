package p841;

import java.util.*;

/**
 * @author Glory
 * @date 2020/6/29 16:30
 */
public class Solution {
    /**
     * 标准BFS
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return true;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                assert cur != null;
                for (Integer next : rooms.get(cur)) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
