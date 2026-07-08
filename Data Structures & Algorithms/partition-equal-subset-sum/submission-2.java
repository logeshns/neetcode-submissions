class Solution {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base Case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill table
        for (int index = n - 1; index >= 0; index--) {

            for (int t = 1; t <= target; t++) {

                boolean take = false;

                if (nums[index] <= t) {
                    take = dp[index + 1][t - nums[index]];
                }

                boolean notTake = dp[index + 1][t];

                dp[index][t] = take || notTake;
            }
        }

        return dp[0][target];
    }
}