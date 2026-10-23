class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int ma=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=i)
            {
                if(ma==-1)
                ma=nums[i];
                else
                ma&=nums[i];
            }
        }
        return (ma==-1)?0:ma;
    }
}