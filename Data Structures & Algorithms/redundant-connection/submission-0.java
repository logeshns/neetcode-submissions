class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int x=edge[0];
            int y=edge[1];
            if(find(x)==find(y)){
                return edge;
            }
            union(x,y);
        }
        return new int[0];
    }
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX==rootY)return;
        if(rootX>rootY){
            parent[rootY]=rootX;
        }else if(rootY>rootX){
            parent[rootX]=rootY;
        }else{
            parent[rootY]=rootX;
            rank[rootX]++;
        }
    }
}
