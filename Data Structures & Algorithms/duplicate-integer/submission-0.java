class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        while(i<nums.length){
            if(nums[i-1]<nums[i]){
                i++;
                continue;
            }else{
                return true;
            }
        }
        return false;
    }
}