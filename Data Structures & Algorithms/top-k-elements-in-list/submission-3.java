//import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(
            (a,b) ->map.get(a)-map.get(b)
        );
        for(int key:map.keySet()){
            minHeap.add(key);
            if(minHeap.size()>k){
               minHeap.poll(); 
            }
        }
        int[] an=new int[k];
        for(int i=0;i<an.length;i++){
            an[i]=minHeap.poll();
        }
        return an;
    }
}
