class Solution {

    int[][] dp;
    int[] arr;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];

        dp = new int[n + 2][n + 2];

        return dfs(0, n + 1);
    }

    private int dfs(int left, int right) {

        if (right - left == 1)
            return 0;

        if (dp[left][right] != 0)
            return dp[left][right];

        int ans = 0;

        for (int k = left + 1; k < right; k++) {

            int coins =
                    dfs(left, k)
                  + arr[left] * arr[k] * arr[right]
                  + dfs(k, right);

            ans = Math.max(ans, coins);
        }

        return dp[left][right] = ans;
    }
}