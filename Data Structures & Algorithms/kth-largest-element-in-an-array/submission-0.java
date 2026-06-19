class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
            if(minHeap.size()<k){
                minHeap.offer(nums[i]);
            }else if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
        
    }
}
