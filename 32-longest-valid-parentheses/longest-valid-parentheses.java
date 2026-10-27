class Solution {
    public int longestValidParentheses(String s) {
        int oc=0,cc=0,ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            oc+=1;
            else
            cc+=1;

            if(cc>oc)
            {
                oc=0;
                cc=0;
            }
            if(oc==cc)
            ans=Math.max(ans,2*cc);
        }
        oc=0;cc=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==')')
            oc+=1;
            else
            cc+=1;

            if(cc>oc)
            {
                oc=0;
                cc=0;
            }
            if(oc==cc)
            ans=Math.max(ans,2*cc);
        }
        return ans;
    }
}