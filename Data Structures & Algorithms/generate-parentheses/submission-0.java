class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        helper(n,0,0,temp);
        return res;
    }
    public void helper(int n,int open,int close,StringBuilder temp){
        if(open<close || open>n || close>n ){
            return;
        }
        if(open==n && close==n){
            res.add(temp.toString());
            return;
        }
            temp.append("(");
            helper(n,open+1,close,temp);
            temp.deleteCharAt(temp.length()-1);
            temp.append(")");
            helper(n,open,close+1,temp);
            temp.deleteCharAt(temp.length() - 1);
        
    }
}
