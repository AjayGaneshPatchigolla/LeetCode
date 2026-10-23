class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int tmp[]=new int[n];
        for(int i=0;i<n;i++)
        tmp[i]=nums[i];
        Arrays.sort(tmp);
        int ma=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=tmp[i])
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