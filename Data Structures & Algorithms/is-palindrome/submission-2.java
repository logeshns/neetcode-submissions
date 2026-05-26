class Solution {
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<right){
            if(!Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            char leftC=Character.toLowerCase(s.charAt(left));
            char rightC=Character.toLowerCase(s.charAt(right));
            if(leftC!=rightC){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
