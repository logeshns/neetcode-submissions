class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->(b-a));
        heap.addAll(map.values());
        int time=0;
        while(!heap.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(!heap.isEmpty()){
                temp.add(heap.poll());
            }
        }
            for(int x:temp){
                if(--x>0){
                    heap.add(x);
                }
            }
            time+=heap.isEmpty()?temp.size():n+1;
        }
        return time;
    }
}
