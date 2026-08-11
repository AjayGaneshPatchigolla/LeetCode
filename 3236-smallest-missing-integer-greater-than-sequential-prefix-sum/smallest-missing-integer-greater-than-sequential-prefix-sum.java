class Solution {
    public int missingInteger(int[] nums) {
        int s=nums[0],n=nums.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int i: nums)hs.add(i);
        for(int i=1;i<n;i++)
        {
            if((nums[i]-1)==nums[i-1])
            {
                s+=nums[i];
            }
            else
            {
               break;
            }
        }
        while(hs.contains(s))
        {
            s+=1;
        }
        return s;
    }
}