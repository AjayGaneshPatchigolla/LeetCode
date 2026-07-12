class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(arr.length==0)
        return arr;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int tar[]=new int[n];
        for(int i=0;i<n;i++)
        tar[i]=arr[i];
        Arrays.sort(tar);
        int r=1;
        hm.put(tar[0],r);
        for(int i=1;i<n;i++)
        {
            if(tar[i]==tar[i-1])
            {
                continue;
            }
            else
            {
                r+=1;
                hm.put(tar[i],r);
            }
        }
        for(int i=0;i<n;i++)
        arr[i]=hm.get(arr[i]);
        return arr;
    }
}