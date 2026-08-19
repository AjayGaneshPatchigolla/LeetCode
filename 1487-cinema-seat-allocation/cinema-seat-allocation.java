class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        Arrays.sort(arr, (a,b) -> {
            if(a[0]==b[0])
            return a[1]-b[1];
            return a[0]-b[0];
        });
        int l=arr.length,ans=0,pv=0,i=0;
        for(i=0;i<l-1;i++)
        {
            // System.out.println(i);
            if(pv!=arr[i][0])
            {
                // System.out.println((arr[i][0]-pv-1)+"#");
                ans+=(arr[i][0]-pv-1)*2;
            }
            int tmp[]=new int[10];
            if(arr[i][0]==arr[i+1][0])
            {
                tmp[arr[i][1]-1]=1;
                int j=i+1;
                // System.out.println(arr[j][1]+"&"+j);
                // System.out.println(arr[j][0]+" "+arr[i][0]);
                while(j<l && arr[j][0]==arr[i][0])
                {
                    tmp[arr[j][1]-1]=1;
                    // System.out.println(arr[j][1]+"&");
                    j+=1;
                }
                // System.out.println(Arrays.toString(tmp));
                if(tmp[1]==0 && tmp[2]==0 && tmp[3]==0 && tmp[4]==0)
                {
                    ans+=1;
                    tmp[1]=1;
                    tmp[2]=1;
                    tmp[3]=1;
                    tmp[4]=1;
                }
                if(tmp[5]==0 && tmp[6]==0 && tmp[7]==0 && tmp[8]==0)
                {
                    ans+=1;
                    tmp[6]=1;
                    tmp[7]=1;
                    tmp[8]=1;
                    tmp[5]=1;
                }
                if(tmp[5]==0 && tmp[6]==0 && tmp[3]==0 && tmp[4]==0)
                {
                    ans+=1;
                    tmp[5]=1;
                    tmp[6]=1;
                    tmp[3]=1;
                    tmp[4]=1;
                }
                i=j-1;
                pv=arr[i][0];
            }
            else
            {
                tmp[arr[i][1]-1]=1;
                if(tmp[1]==0 && tmp[2]==0 && tmp[3]==0 && tmp[4]==0)
                {
                    ans+=1;
                    tmp[1]=1;
                    tmp[2]=1;
                    tmp[3]=1;
                    tmp[4]=1;
                }
                if(tmp[5]==0 && tmp[6]==0 && tmp[8]==0 && tmp[7]==0)
                {
                    ans+=1;
                    tmp[6]=1;
                    tmp[7]=1;
                    tmp[8]=1;
                    tmp[5]=1;
                }
                if(tmp[5]==0 && tmp[6]==0 && tmp[3]==0 && tmp[4]==0)
                {
                    ans+=1;
                    tmp[5]=1;
                    tmp[6]=1;
                    tmp[3]=1;
                    tmp[4]=1;
                }
                pv=arr[i][0];
            }
            // System.out.println(ans+"*");
        }
        if(i!=l)
        {
            int tmp[]=new int[10];
            if(pv!=arr[i][0])
            {
                ans+=(arr[i][0]-pv-1)*2;
            }
            tmp[arr[i][1]-1]=1;
            if(tmp[1]==0 && tmp[2]==0 && tmp[3]==0 && tmp[4]==0)
            {
                ans+=1;
                tmp[1]=1;
                tmp[2]=1;
                tmp[3]=1;
                tmp[4]=1;
            }
            if(tmp[5]==0 && tmp[6]==0 && tmp[8]==0 && tmp[7]==0)
            {
                ans+=1;
                tmp[6]=1;
                tmp[7]=1;
                tmp[8]=1;
                tmp[5]=1;
            }
            if(tmp[5]==0 && tmp[6]==0 && tmp[3]==0 && tmp[4]==0)
            {
                ans+=1;
                tmp[5]=1;
                tmp[6]=1;
                tmp[3]=1;
                tmp[4]=1;
            }
            pv=arr[i][0];
            // System.out.println(ans+"*");
        }
        if(n!=arr[l-1][0])
        ans+=(n-arr[l-1][0])*2;
        return ans;
    }
}