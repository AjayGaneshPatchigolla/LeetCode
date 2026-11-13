class Solution {
    static int rec(int ind,int costs[],int n,int dp[])
    {
        if(ind>=n)return Integer.MAX_VALUE;
        if(ind==(n-1))
        return 0;
        if(ind!=-1 && dp[ind]!=-1)
        return dp[ind];
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++)
        {
            int ni=ind+i;
            if(ni>=n)
            break;
            int tans=costs[ni]+(ni-ind)*(ni-ind)+rec(ni,costs,n,dp);
            if(tans!=Integer.MAX_VALUE && tans>=0)
            ans=Math.min(ans,tans);
        }
        if(ind!=-1)
        dp[ind]=ans;
        return ans;
    }
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return rec(-1,costs,n,dp);
    }
}