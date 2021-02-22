package p785;

/**
 * @author Glory
 * @date 2020/7/16 8:34
 */
public class Solution {
    //我敢说这是我见过最详细的代码了，第一次在提交记录里面看到带注释的代码，tql
    private boolean[] visited;
    //每个顶点的颜色，0是蓝色，1是绿色
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        //将图放进类的成员变量中
        this.graph = graph;
        int V = graph.length;
        visited = new boolean[V];
        colors = new int[V];
        /*对每一个联通分量进行检测，如果有一个联通分量不是二分图，
          整个图就不是二分图*/
        for (int v = 0; v < V; v++)
            if (!visited[v])
                if (!dfs(v, 0)) return false;
        return true;
    }

    //从v出发，检测是否满足二分图性质
    private boolean dfs(int v, int color) {
        visited[v] = true;
        //染色
        colors[v] = color;
        for (int w : graph[v]) {
            //如果相邻顶点w没有被遍历过就要去遍历w并染色
            if (!visited[w]) {
                /*通过相邻顶点w检测到不是二分图了就返回false，
                  不需要再看其他相邻顶点了*/
                if (!dfs(w, 1 - color)) return false;
            }
            /*如果相邻顶点遍历了而且颜色和当前这个顶点颜色一样，就不满足二分图性质
              直接返回false，不需要再看其他相邻顶点了*/
            else if (colors[v] == colors[w])
                return false;
        }
        /*所有相邻顶点都检查了都没发现违反二分图性质，
          就代表从当前v出发去检测满足二分图，返回true*/
        return true;
    }
}