class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> hs=new HashSet<>();
        int tmp[];
        StringBuilder sb;
        int ans=0;
        for(String i: startWords)
        {
            tmp=new int[26];
            sb=new StringBuilder();
            for(int j=0;j<i.length();j++)
            tmp[i.charAt(j)-'a']+=1;
            for(int j=0;j<26;j++)
            sb.append(tmp[j]);
            hs.add(sb.toString());
        }
        for(String i: targetWords)
        {
            tmp=new int[26];
            sb=new StringBuilder();
            for(int j=0;j<i.length();j++)
            tmp[i.charAt(j)-'a']+=1;
            for(int j=0;j<26;j++)
            sb.append(tmp[j]); 
            boolean found=false;
            for(int j=0;j<26;j++)
            {
                int val=sb.charAt(j)-'0';
                if(val>=1)
                {
                    sb.setCharAt(j,(char)(48+val-1)); 
                    if(hs.contains(sb.toString())){
                    ans+=1;
                    found=true;
                    }
                    sb.setCharAt(j,(char)(48+val));
                }
                if(found)break;
            }
        }
        return ans;
    }
}