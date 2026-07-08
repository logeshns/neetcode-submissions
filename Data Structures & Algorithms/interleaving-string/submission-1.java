class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length())
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case
        dp[m][n] = true;

        // Last column (only s1 remaining)
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = dp[i + 1][n] &&
                       s1.charAt(i) == s3.charAt(i + n);
        }

        // Last row (only s2 remaining)
        for (int j = n - 1; j >= 0; j--) {
            dp[m][j] = dp[m][j + 1] &&
                       s2.charAt(j) == s3.charAt(m + j);
        }

        // Fill remaining states
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int k = i + j;

                dp[i][j] =
                    (s1.charAt(i) == s3.charAt(k) && dp[i + 1][j]) ||
                    (s2.charAt(j) == s3.charAt(k) && dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}