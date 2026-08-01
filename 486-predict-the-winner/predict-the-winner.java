class Solution {
    static int rec(int i,int j,int nums[])
    {
        if(i>j)
        return 0;
        int s1=nums[i]-rec(i+1,j,nums);
        int s2=nums[j]-rec(i,j-1,nums);
        return Math.max(s1,s2);
    }
    public boolean predictTheWinner(int[] nums) {
        return rec(0,nums.length-1,nums)>=0;
    }
}