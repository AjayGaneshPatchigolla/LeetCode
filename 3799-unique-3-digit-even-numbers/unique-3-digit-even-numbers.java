class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(i!=j && j!=k && i!=k)
                    {
                        int val=digits[i]*100+digits[j]*10+digits[k];
                        // System.out.println(val);
                        if(val%2==0 && digits[i]>0){
                        hs.add(val);
                        // System.out.println(val+"*");
                        }
                    }
                }
            }
        }
        return hs.size();
    }
}