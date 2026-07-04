class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        HashSet<Integer> visited=new HashSet<>();
        pq.add(new Pair(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            if(visited.contains(current.node)){
                continue;
            }
            visited.add(current.node);
            cost+=current.weight;
            int x1=points[current.node][0];
            int y1=points[current.node][1];
            for(int i=0;i<n;i++){
                if(!visited.contains(i)){
                    int x2=points[i][0];
                    int y2=points[i][1];
                    int distance=Math.abs(x1-x2)+Math.abs(y1-y2);
                    pq.add(new Pair(i,distance));
                }
            }
        }
        return cost;
    }
}
