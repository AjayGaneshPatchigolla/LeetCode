class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int pc=0,mc=0,gc=0;
        for(int i=0;i<garbage.length;i++)
        {
            String tmp=garbage[i];
            for(int j=0;j<tmp.length();j++)
            {
                char c=tmp.charAt(j);
                if(c=='M')
                mc+=1;
                else if(c=='G')
                gc+=1;
                else
                pc+=1;
            }
        }
        int ans=0;
        if(mc>0)
        {
            ans+=mc;
            for(int i=0;i<garbage.length;i++)
            {
                String tmp=garbage[i];
                for(int j=0;j<tmp.length();j++)
                {
                    char c=tmp.charAt(j);
                    if(c=='M')
                    mc-=1;
                }
                if(i>0)ans+=travel[i-1];
                if(mc==0)
                break;
            }
        }
        if(gc>0)
        {
            ans+=gc;
            for(int i=0;i<garbage.length;i++)
            {
                String tmp=garbage[i];
                for(int j=0;j<tmp.length();j++)
                {
                    char c=tmp.charAt(j);
                    if(c=='G')
                    gc-=1;
                }
                if(i>0)ans+=travel[i-1];
                if(gc==0)
                break;
            }
        }
        if(pc>0)
        {
            ans+=pc;
            for(int i=0;i<garbage.length;i++)
            {
                String tmp=garbage[i];
                for(int j=0;j<tmp.length();j++)
                {
                    char c=tmp.charAt(j);
                    if(c=='P')
                    pc-=1;
                }
                if(i>0)ans+=travel[i-1];
                if(pc==0)
                break;
            }
        }
        return ans;
    }
}