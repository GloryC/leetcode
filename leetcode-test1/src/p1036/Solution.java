package p1036;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/6/28 14:39
 */
public class Solution {

    /**
     * 使用BFS进行查找
     *
     * @param blocked 障碍物方位
     * @param source  起点
     * @param target  终点
     * @return 是否找到
     */
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int m = 100, n = 100, x = source[0], y = source[1], dx = target[0], dy = target[1];
        boolean[][] mark = new boolean[m][n];
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (x == dx && y == dy) return true;
        mark[x][y] = true;

        Map<String, Integer> blockMap = new HashMap<>();
        for (int i = 0; i < blocked.length; i++) {
            blockMap.put(blocked[i][0] + "," + blocked[i][1], 1);
        }

        Queue<Point> queue = new ArrayDeque<>(m * n);
        Point start = new Point(x, y);
        queue.add(start);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < next.length; i++) {
                int nextx = point.x + next[i][0];
                int nexty = point.y + next[i][1];
                if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) continue;
                if (!blockMap.containsKey(nextx + "," + nexty) && !mark[nextx][nexty]) {
                    if (nextx == dx && nexty == dy) return true;
                    mark[nextx][nexty] = true;
                    Point newPoint = new Point(nextx, nexty);
                    queue.add(newPoint);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isEscapePossible(new int[][]{
                {0, 1}, {0, 2}
        }, new int[]{0, 0}, new int[]{3, 3}));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
