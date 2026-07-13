class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int l=(int)Math.log10(low)+1,h=(int)Math.log10(high)+1;
        List<Integer> ans=new ArrayList<>();
        for(int i=l;i<=h;i++)
        {
            StringBuilder sb=new StringBuilder();
            int j=1;
            for(j=1;j<=i;j++)
            sb.append(j);
            long val=Long.parseLong(sb.toString());
            if(val>=low && val<=high)
            ans.add((int)val);
            while(j<=9)
            {
                sb.deleteCharAt(0);
                sb.append(j);
                val=Long.parseLong(sb.toString());
                if(val>=low && val<=high)
                ans.add((int)val);
                j+=1;
            }
        }
        return ans;
    }
}