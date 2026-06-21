class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
        helper(res,temp,nums,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> temp,int[] nums,int index){
        if(index==nums.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        helper(res,temp,nums,index+1);
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        temp.remove(temp.size()-1);  
        helper(res,temp,nums,index+1);

    }
}
