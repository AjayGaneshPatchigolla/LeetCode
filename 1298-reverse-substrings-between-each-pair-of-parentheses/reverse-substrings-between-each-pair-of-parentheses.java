class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c==')')
            {
                StringBuilder tmp=new StringBuilder();
                while(!st.isEmpty())
                {
                    char tc=st.pop();
                    if(tc=='(')
                    break;
                    tmp.append(tc);
                }
                for(int j=0;j<tmp.length();j++)
                st.push(tmp.charAt(j));
            }
            else
            {
                st.push(c);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty())
        res.append(st.pop());
        return res.reverse().toString();
    }
}