class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int INF = Integer.MAX_VALUE - 1;

        int[][] dp = new int[n + 1][amount + 1];

        // Base case:
        // No coins left
        for (int a = 1; a <= amount; a++) {
            dp[n][a] = INF;
        }

        // amount = 0 requires 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int index = n - 1; index >= 0; index--) {

            for (int a = 1; a <= amount; a++) {

                int take = INF;

                if (a >= coins[index]) {
                    take = 1 + dp[index][a - coins[index]];
                }

                int notTake = dp[index + 1][a];

                dp[index][a] = Math.min(take, notTake);
            }
        }

        return dp[0][amount] == INF ? -1 : dp[0][amount];
    }
}