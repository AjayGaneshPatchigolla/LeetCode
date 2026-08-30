class Solution {
    public int minimumDeletions(int[] nums) {
        int mie=nums[0],mii=0,mae=nums[0],mai=0,n=nums.length;
        if(n<=2)
        return n;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mae)
            {
                mae=nums[i];
                mai=i;
            }
            if(nums[i]<mie)
            {
                mie=nums[i];
                mii=i;
            }
        }
        int mi=Math.min(mii,mai),ma=Math.max(mii,mai);
        int ans=n;
        ans=Math.min(ans,ma+1);
        ans=Math.min(ans,n-mi);
        ans=Math.min(ans,mi+1+n-ma);
        return ans;
    }
}