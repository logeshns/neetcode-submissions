class Solution {

    private int[][] dp;
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {

        // Already computed
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int best = 1; // Path containing only this cell

        for (int k = 0; k < 4; k++) {

            int ni = i + dr[k];
            int nj = j + dc[k];

            if (ni >= 0 && ni < matrix.length &&
                nj >= 0 && nj < matrix[0].length &&
                matrix[ni][nj] > matrix[i][j]) {

                best = Math.max(best, 1 + dfs(matrix, ni, nj));
            }
        }

        dp[i][j] = best;
        return best;
    }
}