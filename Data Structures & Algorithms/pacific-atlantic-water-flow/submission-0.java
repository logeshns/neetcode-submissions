class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific borders
        for (int i = 0; i < m; i++)
            dfs(i, 0, heights, pacific);

        for (int j = 0; j < n; j++)
            dfs(0, j, heights, pacific);

        // Atlantic borders
        for (int i = 0; i < m; i++)
            dfs(i, n - 1, heights, atlantic);

        for (int j = 0; j < n; j++)
            dfs(m - 1, j, heights, atlantic);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c,
                     int[][] heights,
                     boolean[][] visited) {

        if (visited[r][c])
            return;

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 &&
                nr < heights.length &&
                nc >= 0 &&
                nc < heights[0].length &&
                !visited[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr, nc, heights, visited);
            }
        }
    }
}