class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n) {
    if (i == m - 1 && j == n - 1)
        return 1;
    if (i >= m || j >= n)
        return 0;
    if(dp[i][j]!=0){
        return dp[i][j];  
        }
    int down = dfs(i + 1, j, m, n);
    int right = dfs(i, j + 1, m, n);
    return dp[i][j]=down+right;
}
}
