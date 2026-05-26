class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int x=0,y=1;
      for(int i=0;i<numbers.length;i++){
        for(int j=i+1;j<numbers.length;j++){
            if(numbers[i]+numbers[j]==target){
                x=i;
                y=j;
            }
        }
      }
      return new int[]{x+1,y+1}; 
    }
}
