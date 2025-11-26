class Solution {
    static int mod=(int)Math.pow(10,9)+7;
    static int rec(int i,int j,int grid[][],int k,int s,int dp[][][])
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
        return 0;
        if(dp[i][j][s%k]!=-1)
        return dp[i][j][s%k];
        if(i==grid.length-1 && j==grid[0].length-1)
        {
            if((s+grid[i][j])%k==0)
            return 1;
            return 0;
        }
        return dp[i][j][s%k]=(rec(i+1,j,grid,k,s+grid[i][j],dp)%mod+rec(i,j+1,grid,k,s+grid[i][j],dp)%mod)%mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int r=grid.length,c=grid[0].length;
        int dp[][][]=new int[r][c][k];
        for(int i[][]: dp)
        {
            for(int j[]: i)
            Arrays.fill(j,-1);
        }
        return rec(0,0,grid,k,0,dp);
    }
}