class Solution {
    public int maxArea(int[] heights) {
      int left=0,right=heights.length-1;
      int maxArea=0;
      while(left<right){
        int currWidth=right-left;
        int currArea=Math.min(heights[left],heights[right])*currWidth;
        maxArea=Math.max(currArea,maxArea);
        if(heights[left]<heights[right]){
            left++;
        }else{
            right--;
        }
      }
      return maxArea;  
    }
}
