class Solution {
    int[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int c=0;
        visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 || visited[i][j]==1)continue;
                c=Math.max(c,recurse(i,j,grid));
            }
        }
        return c;
    }
    int recurse(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]==0)return 0;
        visited[i][j]=1;
        return 1+recurse(i+1,j,grid)+recurse(i-1,j,grid)+recurse(i,j+1,grid)+recurse(i,j-1,grid);
    }
}
