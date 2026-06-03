class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largestElement=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
          largestElement=Math.max(largestElement,piles[i]);
        }
        int left=1;
        int right=largestElement;
        while(left<=right){
          int mid=left+(right-left)/2;
          int calculatehours=0;
          for(int i=0;i<piles.length;i++){
            if(piles[i]%mid==0){
              calculatehours+=piles[i]/mid;
            }else{
              calculatehours+=(piles[i]/mid)+1;
            }
          }
          if(calculatehours>h){
            left=mid+1;
          }else{
            right=mid-1;
          }
        }
        return left;
    }
}
