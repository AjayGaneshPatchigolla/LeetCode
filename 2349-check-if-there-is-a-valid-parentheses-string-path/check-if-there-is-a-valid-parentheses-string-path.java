class Solution {
    static boolean rec(int i,int j,char grid[][],int s,int r,int c,int dp[][][])
    {
        if(i>=r || i<0 || j<0 || j>=c)
        return false;
        char tc=grid[i][j];
        if(tc=='(')
        s+=1;
        else
        s-=1;
        if(s<0)
        {
            return false;
        }
        if(dp[i][j][s]!=-1)
        return (dp[i][j][s]==1);
        if(i==r-1 && j==c-1)
        {
            if(s==0)
            dp[i][j][s]=1;
            else
            dp[i][j][s]=0;
            return dp[i][j][s]==1;
        }
        boolean ans=false;
        ans=(rec(i+1,j,grid,s,r,c,dp)||rec(i,j+1,grid,s,r,c,dp));
        dp[i][j][s]=(ans)?1:0;
        return ans;
    }
    public boolean hasValidPath(char[][] grid) {
        int r=grid.length,c=grid[0].length;
        int dp[][][]=new int[r][c][r+c+1];
        for(int i[][]: dp)
        {
            for(int j[]: i)
            Arrays.fill(j,-1);
        }
        return rec(0,0,grid,0,r,c,dp);
    }
}