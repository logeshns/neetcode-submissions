class Solution {
    public int maxProfit(int[] prices) {
       int profit =0,ans=0;
       int currMin=Integer.MAX_VALUE;
       for(int i=0;i<prices.length;i++){
          currMin=Math.min(currMin,prices[i]);
          profit=prices[i]-currMin;
          if(profit>0){
            ans=Math.max(ans,profit);
          }
       }
       return ans; 
    }
}
