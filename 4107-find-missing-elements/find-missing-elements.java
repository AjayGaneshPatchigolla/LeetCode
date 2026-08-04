class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,l=nums[0],h=nums[n-1];
        List<Integer> ans=new ArrayList<>();
        int tmp=l;
        for(int i=0;i<n;)
        {
            if(nums[i]==tmp)
            {
                i+=1;
                tmp+=1;
            }
            else
            {
                ans.add(tmp);
                tmp+=1;
            }
        }
        return ans;
    }
}