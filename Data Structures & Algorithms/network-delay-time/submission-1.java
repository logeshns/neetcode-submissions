class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Pair>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int t=time[2];
            graph[u].add(new Pair(v,t));
        }
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            if (current.weight > distance[current.node]) {
                    continue;
            }
            for (Pair p : graph[current.node]) {
                int newDistance=current.weight+p.weight;
                if(newDistance<distance[p.node]){
                    distance[p.node]=newDistance;
                    pq.offer(new Pair(p.node,newDistance));
                }                
                }
            }
            int answer=0;
            for(int i=1;i<=n;i++){
                if(distance[i]==Integer.MAX_VALUE){
                    return -1;
                }
                answer=Math.max(answer,distance[i]);
            }
            return answer;
}

    }

