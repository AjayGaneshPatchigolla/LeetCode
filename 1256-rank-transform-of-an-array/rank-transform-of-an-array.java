class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            if(!tm.containsKey(arr[i]))
            tm.put(arr[i],new ArrayList<>());
            tm.get(arr[i]).add(i);
        }
        int r=1;
        for(int i: tm.keySet())
        {
            for(int j: tm.get(i))
            arr[j]=r;
            r+=1;
        }
        return arr;
    }
}