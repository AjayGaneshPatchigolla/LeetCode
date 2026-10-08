class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            st.add(c+"");
            else
            {
                int ans=0;
                while(true)
                {
                    String tmp=st.pop();
                    if(tmp.equals("("))
                    {
                        st.add((ans==0)?"1":(2*ans+""));
                        break;
                    }
                    else
                    {
                        ans+=Integer.parseInt(tmp);
                    }
                }
            }
        }
        int ans=0;
        while(!st.isEmpty())
        ans+=Integer.parseInt(st.pop());
        return ans;
    }
}