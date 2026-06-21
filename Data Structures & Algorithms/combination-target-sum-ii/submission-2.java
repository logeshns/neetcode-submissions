class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int sum=0;
        Arrays.sort(candidates);
        helper(res,temp,candidates,target,0,sum);
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
        helper(res,temp,nums,target,index+1,sum);
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        temp.remove(temp.size()-1);
        sum-=nums[index];
        helper(res,temp,nums,target,index+1,sum);
    }
}
