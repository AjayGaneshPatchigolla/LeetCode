class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        int jump[]=new int[n];
        Stack<Integer> op=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            op.add(i);
            else if(s.charAt(i)==')')
            {
                int oi=op.pop();
                jump[i]=oi;
                jump[oi]=i;
            }
        }

        int direction=1;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i+=direction)
        {
            char c=s.charAt(i);
            if(c=='(' || c==')'){
            i=jump[i];
            direction=-direction;
            }
            else
            res.append(c);
        }
        return res.toString();
    }
}