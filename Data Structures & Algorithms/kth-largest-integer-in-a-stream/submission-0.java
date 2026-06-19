class KthLargest {
    private PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap=new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.add(val);
        }else if(minHeap.peek()<val){
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
