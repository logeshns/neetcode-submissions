class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int x=e[0];
            int y=e[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        boolean[] visited=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                dfs(i,graph,visited);
            }
        }
        return c;
    }
    public void dfs(int n,List<Integer>[] graph,boolean[] visited){
        visited[n]=true;
        for(int neighbour:graph[n]){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited);
            }
        }
    }
}
