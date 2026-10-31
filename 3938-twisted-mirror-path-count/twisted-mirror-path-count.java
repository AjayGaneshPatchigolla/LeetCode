class Solution {
    static int mod=1000000007;
    public int rec(int i,int j,int grid[][],int r,int c,int pp,int dp[][][])
    {
        if(i>=r || j>=c)
        return 0;
        if(dp[i][j][pp]!=-1)
        return dp[i][j][pp];
        if(i==(r-1) && j==(c-1))
        return 1;
        int ans=0;
        if(grid[i][j]==1)
        {
            if(pp==1)
                ans=(ans%mod+rec(i+1,j,grid,r,c,2,dp)%mod)%mod;
            else if(pp==2)
                ans=(ans%mod+rec(i,j+1,grid,r,c,1,dp)%mod)%mod;
        }
        else
        {
            ans=(ans%mod+rec(i,j+1,grid,r,c,1,dp)%mod)%mod;
            ans=(ans%mod+rec(i+1,j,grid,r,c,2,dp)%mod)%mod;
        }
        return dp[i][j][pp]=ans;
    }
    public int uniquePaths(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int dp[][][]=new int[r][c][3];
        for(int i[][]: dp)
        {
            for(int j[]: i)
            Arrays.fill(j,-1);
        }
        return rec(0,0,grid,r,c,0,dp);
    }
}