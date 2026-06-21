class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(res,temp,nums,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> temp,
    int[] nums,int index){
        if(index==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        helper(res,temp,nums,index+1);
        temp.remove(temp.size()-1);
        helper(res,temp,nums,index+1);
        
    }
}
