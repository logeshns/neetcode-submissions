class Solution {
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public class Point{
        int x;
        int y;
        int elevation;
        Point(int x,int y,int elevation){
            this.x=x;
            this.y=y;
            this.elevation=elevation;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<Point> pq=new PriorityQueue<>(
            (a,b)->a.elevation-b.elevation
        );
        boolean[][] visited = new boolean[n][n];
        pq.add(new Point(0,0,grid[0][0]));
        visited[0][0]=true;
        while(!pq.isEmpty()){
            Point current=pq.poll();
            if(current.x==n-1 && current.y==n-1){
                return current.elevation;
            }
            for(int[] d:dir){
                int nx=current.x+d[0];
                int ny=current.y+d[1];
                if(nx<0 || ny<0 || nx>=n || ny>=n){
                    continue;
                }
                if(visited[nx][ny])continue;
                int nelevation=Math.max(current.elevation,grid[nx][ny]);
                pq.offer(new Point(nx,ny,nelevation));
                visited[nx][ny]=true;
            }
        }
        return -1;
    }
}
