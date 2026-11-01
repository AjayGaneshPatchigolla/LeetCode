class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans=0,n=nums.length;
        for(int i=n-1;i>=1;i--)
        {
            int tmp=(nums[i]+ans-nums[0]);
            nums[0]+=tmp;
            ans+=tmp;
        }
        return ans;
    }
}