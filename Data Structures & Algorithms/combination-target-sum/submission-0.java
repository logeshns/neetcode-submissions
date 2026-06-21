class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int sum=0;
        helper(res,temp,nums,target,0,sum);
        return res;
    }
    public void helper(List<List<Integer>> res,
                        List<Integer> temp,
                        int[] nums,
                        int target,
                        int index,int sum){
        if(sum==target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target){
            return;
        }
        if(index==nums.length)return;
        temp.add(nums[index]);
        sum+=nums[index];
        helper(res,temp,nums,target,index,sum);
        //helper(res,temp,nums,target,index+1,sum);
        temp.remove(temp.size()-1);
        sum-=nums[index];
        helper(res,temp,nums,target,index+1,sum);
    }
}
