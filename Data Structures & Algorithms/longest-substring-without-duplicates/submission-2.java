class Solution {
    public int lengthOfLongestSubstring(String s) {
      if(s.length()<=1)return s.length();
      int i=0,ma=1;
      for(int j=1;j<s.length();j++){
        char ch=s.charAt(j);
        if(s.substring(i,j).indexOf(ch)==-1){
          ma=Math.max(ma,j-i+1);
        }else{
          while(s.substring(i,j).indexOf(ch)!=-1){
            i++;
          }
        }
      }
      return ma;
    }
}
