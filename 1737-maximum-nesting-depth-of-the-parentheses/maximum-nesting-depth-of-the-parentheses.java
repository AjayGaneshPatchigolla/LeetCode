class Solution {
    public int maxDepth(String s) {
        int ans=0,cnt=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            cnt+=1;
            else if(c==')')
            cnt-=1;
            ans=Math.max(ans,cnt);
        }
        return ans;
        
    }
}