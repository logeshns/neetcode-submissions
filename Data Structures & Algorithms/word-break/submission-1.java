class Solution {

    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return helper(s, wordDict, 0);
    }

    private boolean helper(String s, List<String> wordDict, int index) {

        // Base Case
        if (index == s.length()) {
            return true;
        }

        // Already computed
        if (dp[index] != null) {
            return dp[index];
        }

        // Try every word
        for (String word : wordDict) {

            // Does the word match from the current index?
            if (s.startsWith(word, index)) {

                // If the remaining part can also be broken
                if (helper(s, wordDict, index + word.length())) {
                    dp[index] = true;
                    return true;
                }
            }
        }

        // No word worked
        dp[index] = false;
        return false;
    }
}