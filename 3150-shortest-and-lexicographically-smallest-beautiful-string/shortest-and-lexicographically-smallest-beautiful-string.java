class Solution {
    private String findLexographicallySmaller(String a,String b)
    {
        if(a.length()>b.length())
        return b;

        if(b.length()>a.length())
        return a;

        if(a.compareTo(b)<0)
        return a;
        return b;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        String tmp="";
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            String ctmp="";
            int cnt=0;
            for(int j=i;j<n;j++)
            {
                char c=s.charAt(j);
                ctmp+=c;
                if(c=='1')
                cnt+=1;
                if(cnt>=k)
                {
                    if(tmp.equals(""))
                    tmp=ctmp;
                    else
                    tmp=findLexographicallySmaller(tmp,ctmp);
                }
            }
        }
        return tmp;
    }
}