class SummaryRanges {
    public TreeSet<Integer> ts;
    public SummaryRanges() {
        ts=new TreeSet<>();
    }
    
    public void addNum(int value) {
        ts.add(value);
    }
    
    public int[][] getIntervals() {
        // System.out.println(ts);
        ArrayList<ArrayList<Integer>> intervals=new ArrayList<>();
        int a=-1,b=-1;
        ArrayList<Integer> tmp=new ArrayList<>();
        for(int i: ts)
        {
            // System.out.print(i+" ");
            if(a==-1)
            {
                a=i;
                b=i;
            }
            else
            {
                if(i-b==1)
                {
                    b=i;
                }
                else
                {
                    tmp.add(a);
                    tmp.add(b);
                    a=i;
                    b=i;
                    intervals.add(tmp);
                    tmp=new ArrayList<>();
                }
            }
        }
        if(a!=-1 && b!=-1)
        {
            tmp=new ArrayList<>();
            tmp.add(a);
            tmp.add(b);
            intervals.add(tmp);
        }
        int res[][]=new int[intervals.size()][2];
        int ind=0;
        for(ArrayList<Integer> i: intervals)
        {
            res[ind][0]=i.get(0);
            res[ind++][1]=i.get(1);
        }
        // System.out.println(intervals);
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */