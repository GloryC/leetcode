package p994;

import java.util.*;

/**
 * @author Glory
 * @date 2020/3/4 15:07
 */
public class Solution {

    public int rotting(int[][] grid) {
        int[] p1 = {1, -1, 0, 0};
        int[] p2 = {0, 0, 1, -1};
        Deque<int[]> queue = new ArrayDeque<>();
        //把腐烂的🍊加入队列中，作为开始扩散的起点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        //从腐烂的🍊开始感染，其实就是一个bfs求无权图最短路的问题
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int j = 0; j < p1.length; j++) {
                    int x = temp[0] + p1[j], y = temp[1] + p2[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
            if (!queue.isEmpty()) {
                steps++;
            }
        }

        //遍历矩阵，判断是否有🍊还未被感染，也就是是否还有grid[i][j] = 1的地儿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return steps;

    }

}
