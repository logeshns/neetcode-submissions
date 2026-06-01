class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int x = st.pop();
                int y = st.pop();

                if (token.equals("+")) {
                    st.push(y + x);
                } else if (token.equals("-")) {
                    st.push(y - x);
                } else if (token.equals("*")) {
                    st.push(y * x);
                } else {
                    st.push(y / x);
                }

            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}