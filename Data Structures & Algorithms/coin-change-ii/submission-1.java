class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        return dfs(amount, coins, 0);
    }

    private int dfs(int amount, int[] coins, int index) {

        if (amount == 0)
            return dp[index][amount]=1;

        if (amount < 0 || index == coins.length)
            return 0;
        if(dp[index][amount]!=0){
            return dp[index][amount];
        }

        int take = dfs(amount - coins[index], coins, index);
        int notTake = dfs(amount, coins, index + 1);

        return dp[index][amount]=take + notTake;
    }
}