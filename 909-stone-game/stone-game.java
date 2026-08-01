class Solution {
     static int rec(int i,int j,int nums[],int dp[][])
    {
        if(i>j)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int s1=nums[i]-rec(i+1,j,nums,dp);
        int s2=nums[j]-rec(i,j-1,nums,dp);
        return dp[i][j]=Math.max(s1,s2);
    }
    public boolean stoneGame(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return rec(0,nums.length-1,nums,dp)>=0;
    }
}