class Solution {
    static int rec(int i,String s,int n,String res,int op,int dp[][])
    {
        if(op<0)
        return 0;
        if(i==n)
        {
            if(op==0)
            return 1;
            return 0;
        }
        else
        {
            if(dp[i][op]!=-1)
            {
                return dp[i][op];
            }
            if(s.charAt(i)=='*')
            return dp[i][op]=rec(i+1,s,n,res+'(',op+1,dp) | rec(i+1,s,n,res+')',op-1,dp) | rec(i+1,s,n,res,op,dp);
            else if(s.charAt(i)=='(')
            return dp[i][op]=rec(i+1,s,n,res+'(',op+1,dp);
            else
            return dp[i][op]=rec(i+1,s,n,res+')',op-1,dp);
        }
    }
    public boolean checkValidString(String s) {
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return rec(0,s,s.length(),"",0,dp)==1;
    }
}