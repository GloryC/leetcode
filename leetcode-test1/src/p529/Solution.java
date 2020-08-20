package p529;

/**
 * @author zhanggc
 * @date 2020/8/20 8:44
 */
public class Solution {
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private int m, n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {   //点击的位置是'M'
            board[x][y] = 'X';
            return board;
        }
        if (board[x][y] == 'E') {   //点击的位置是'E'
            board[x][y] = 'B';
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int count = 0;
        for (int[] ints : d) {  //看当前'E'的周围总共有多少个'M'
            int nextX = x + ints[0];
            int nextY = y + ints[1];
            if (inArea(nextX, nextY) && board[nextX][nextY] == 'M') {
                count++;
            }
        }
        if (count == 0) {   //如果周围没有'M'，则将递归访问它周围的所有'E'
            for (int[] ints : d) {
                int nextX = x + ints[0];
                int nextY = y + ints[1];
                if (inArea(nextX, nextY) && board[nextX][nextY] == 'E') {
                    board[nextX][nextY] = 'B';
                    dfs(board, nextX, nextY);
                }
            }
        } else {   //周围有'M'，则将当前值置为对应的周围'M'总数
            board[x][y] = (char) (count + 48);
        }

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
