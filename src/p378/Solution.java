package p378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Glory
 * @date 2020/7/2 8:45
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                } else if (queue.peek() > matrix[i][j]) {
                    queue.poll();
                    queue.offer(matrix[i][j]);
                }
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrix, 8));
    }
}
