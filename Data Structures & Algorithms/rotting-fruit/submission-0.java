class Solution {

    public int orangesRotting(int[][] grid) {

        int min = 0;

        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        if (queue.isEmpty())
            return -1;

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] node = queue.poll();

                int row = node[0];
                int col = node[1];

                for (int[] d : dir) {

                    int r = row + d[0];
                    int c = col + d[1];

                    if (r < 0 || c < 0 || r >= m || c >= n)
                        continue;

                    if (grid[r][c] != 1)
                        continue;

                    grid[r][c] = 2;

                    fresh--;

                    queue.offer(new int[]{r, c});
                }
            }

            min++;
        }

        return fresh == 0 ? min : -1;
    }
}