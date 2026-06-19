class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            minHeap.add(stones[i]);
        }
        while(minHeap.size()>1){
            int x=minHeap.poll();
            int y=minHeap.poll();
            if(x!=y){
                minHeap.add(Math.abs(x-y));
            }
        }
        return minHeap.isEmpty()?0:minHeap.poll();
    }
}