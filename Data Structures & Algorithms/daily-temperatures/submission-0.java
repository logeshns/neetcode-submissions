class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[temperatures.length];
        int c=0;
        st.push(0);
        for(int i=1;i<temperatures.length;i++){
          if(temperatures[i]<=temperatures[st.peek()]){
            st.push(i);
          }else{
            while( !st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
              ans[st.peek()]=i-st.pop();
            }
            st.push(i);
          }
        }
        return ans;
    }
}
