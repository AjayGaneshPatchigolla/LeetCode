class Solution {
    public int minMoves(int[] nums) {
        int ans=0;
        int tmp=Arrays.stream(nums).min().getAsInt();
        for(int i: nums)
        ans+=(i-tmp);
        return ans;
    }
}