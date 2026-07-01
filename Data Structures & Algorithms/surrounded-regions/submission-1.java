class Solution {

    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Left and Right borders
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O')
                dfs(i, 0, board);

            if (board[i][n - 1] == 'O')
                dfs(i, n - 1, board);
        }

        // Top and Bottom borders
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O')
                dfs(0, j, board);

            if (board[m - 1][j] == 'O')
                dfs(m - 1, j, board);
        }

        // Convert remaining O -> X
        // Convert # -> O

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {

        board[r][c] = '#';

        for (int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 &&
                nr < board.length &&
                nc >= 0 &&
                nc < board[0].length &&
                board[nr][nc] == 'O') {

                dfs(nr, nc, board);
            }
        }
    }
}