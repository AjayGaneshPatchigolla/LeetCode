class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=nums[n-1]*nums[n-2]*nums[n-3];
        System.out.println(ans);
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<0 && nums[i+1]<0 && (i+1)!=(n-1))
            ans=Math.max(ans,nums[i]*nums[i+1]*nums[n-1]);
            // System.out.println(ans+" "+nums[i]*nums[i+1]*nums[n-3]);
        }
        return ans;
    }
}