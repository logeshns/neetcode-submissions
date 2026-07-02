class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)return false;
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
        dfs(0,graph,visited);
        for(boolean v:visited){
            if(!v)return false;
        }
        return true;
    }
    private void dfs(int n,List<Integer>[] graph,boolean[] visited){
        visited[n]=true;
        for(int i=0;i<graph[n].size();i++)
        {
            if(!visited[graph[n].get(i)])
            dfs(graph[n].get(i),graph,visited);
        }    
}
}
