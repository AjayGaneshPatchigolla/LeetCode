class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int maf[]=new int[n];
        maf[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            maf[i]=Math.max(nums[i],maf[i-1]);
        }
        for(int i=n-2;i>=0;i--)
        {
            nums[i]=Math.min(nums[i],nums[i+1]);
        } 
        for(int i=0;i<n;i++)
        {
            if(maf[i]-nums[i]<=k)
            return i;
        }
        return -1;
    }
}