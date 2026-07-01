class Solution {
    int[][] visited;
    public int numIslands(char[][] grid) {
        int c=0;
        int m=grid.length;
        int n=grid[0].length;
        visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='0' || visited[i][j]==1)continue;
                recurse(i,j,grid);
                c++;
            }
        }
        return c;
    }
    void recurse(int i,int j,char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]=='0')return;
        visited[i][j]=1;
        recurse(i+1,j,grid);
        recurse(i-1,j,grid);
        recurse(i,j+1,grid);
        recurse(i,j-1,grid);
    }
}
