class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(dfs(board, word, i, j, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board,
                        String word,
                        int row,
                        int col,
                        int index,
                        boolean[][] visited) {

        if(index == word.length())
            return true;

        if(row < 0 || row >= board.length ||
           col < 0 || col >= board[0].length ||
           visited[row][col] ||
           board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        boolean found =
                dfs(board, word, row + 1, col, index + 1, visited) ||
                dfs(board, word, row - 1, col, index + 1, visited) ||
                dfs(board, word, row, col + 1, index + 1, visited) ||
                dfs(board, word, row, col - 1, index + 1, visited);

        visited[row][col] = false;

        return found;
    }
}