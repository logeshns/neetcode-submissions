class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1)return nums.length;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ma=1;
        Arrays.sort(nums);
        map.put(nums[0],1);
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],map.get(nums[i]-1)+1);
                map.remove(nums[i]-1);
            }else{
                map.put(nums[i],1);
            }
            ma=Math.max(ma,map.get(nums[i]));
        }
        return ma;
    }
}
