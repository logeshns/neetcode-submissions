class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        if(s.length()<t.length())return 0;
        dp=new Integer[s.length()][t.length()];
        return dfs(s,t,0,0);
    }
    private int dfs(String s,String t,int i,int j){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int take=0;
        if(s.charAt(i)==t.charAt(j)){
            take=dfs(s,t,i+1,j+1);
        }
        int nottake=dfs(s,t,i+1,j);
        return dp[i][j]=take+nottake;
    }
}