class Solution {

    HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int index, int target) {

        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        String key = index + "," + target;

        if (memo.containsKey(key))
            return memo.get(key);

        int add = dfs(nums, index + 1, target + nums[index]);
        int sub = dfs(nums, index + 1, target - nums[index]);

        memo.put(key, add + sub);

        return memo.get(key);
    }
}