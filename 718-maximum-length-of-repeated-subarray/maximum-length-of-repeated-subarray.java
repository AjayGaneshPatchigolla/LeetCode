class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<n1;i++)
        {
            int val=nums1[i];
            if(!hm.containsKey(val))
            hm.put(val,new ArrayList<>());
            hm.get(val).add(i);
        }
        int ans=0;
        for(int j=0;j<n2;j++)
        {
            if(hm.containsKey(nums2[j]))
            {
                for(int tmp: hm.get(nums2[j])){
                int cnt=1,i=tmp+1,k=j+1;
                while(i<n1 && k<n2 && nums1[i]==nums2[k]){
                cnt+=1;
                i+=1;
                k+=1;
                }
                ans=Math.max(ans,cnt);
                }
            }
        }
        return ans;
    }
}