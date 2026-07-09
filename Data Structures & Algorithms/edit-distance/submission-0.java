class Solution {

    Integer[][] dp;

    public int minDistance(String word1, String word2) {

        dp = new Integer[word1.length() + 1][word2.length() + 1];

        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String w1, String w2, int i, int j) {

        if (i == w1.length())
            return w2.length() - j;

        if (j == w2.length())
            return w1.length() - i;

        if (dp[i][j] != null)
            return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j))
            return dp[i][j] = dfs(w1, w2, i + 1, j + 1);

        int insert = dfs(w1, w2, i, j + 1);

        int delete = dfs(w1, w2, i + 1, j);

        int replace = dfs(w1, w2, i + 1, j + 1);

        return dp[i][j] =
                1 + Math.min(insert,
                    Math.min(delete, replace));
    }
}