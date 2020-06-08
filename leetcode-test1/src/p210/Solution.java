package p210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Glory
 * @date 2020/5/17 12:53
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        /*
        我们先记录每个节点的入度，以及使用 map 记录每个节点所能到达的其他节点

        当某个节点的入度为 0，表示没有节点指向它，即该课程不需要先修其他课程，那么我们就可以从 该课程 出发

        然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
        当减为 0 的时候，表示入度为 0，那么添加进队列中
        */

        //存储某个节点能够到达的其他节点集合
        List<Integer>[] lists = new ArrayList[numCourses];
        //记录某个节点的入度
        int[] points = new int[numCourses];
        for (int[] p : prerequisites) {
            /*
            [3, 5] 表示学习 3 之前需要先学习 5
            那么对于 3 来说， 5 指向 3，即 3 的入度 + 1
            而 5 能到达的节点集合需要增加 3 这个节点
            */
            points[p[0]]++;
            if (lists[p[1]] == null) {
                lists[p[1]] = new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        //找到入度为 0 的节点

        for (int i = 0; i < numCourses; i++) {
            //入度为 0，添加到队列中
            if (points[i] == 0) {
                queue.add(i);
            }
        }

        //记录遍历的课程顺序
        int[] res = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            /*
            首先我们应该明确这么一点，在队列中的元素都是 0 入度的课程，即没有需要前修的课程就可以直接学习
            那么我们遍历到该课程，假设学习完，那么它指向的课程入度都需要 -1，当它指向的某个课程入度为 0 的时候，同时也需要将该课程添加到队列中
            */
            while (size-- > 0) {
                int p = queue.poll();
                res[idx++] = p;
                List<Integer> list = lists[p];
                if (list == null) {
                    continue;
                }
                for (int val : list) {
                    points[val]--;
                    if (points[val] == 0) {
                        queue.add(val);
                    }
                }
            }
        }
        //idx == numCourses 意味着全部课程都访问过了，即最终都能够满足 0 入度的条件，即全部能够学习完成
        return idx == numCourses ? res : new int[0];
    }

}
