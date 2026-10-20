class TopVotedCandidate {
    int ind_pv[],lsf[],times[];
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times=times;
        int n=persons.length;
        ind_pv=new int[n];
        lsf=new int[n];
        int mvc=-1,vc=0;
        for(int i=0;i<n;i++)
        {
            int person=persons[i];
            ind_pv[person]+=1;
            if(ind_pv[person]>=vc)
            {
                vc=ind_pv[person];
                mvc=person;
            }
            lsf[i]=mvc;
        }
        // System.out.println(Arrays.toString(lsf));
    }
    
    public int q(int t) {
        int ind=Arrays.binarySearch(times,t);
        if(ind<0)
        ind=-(ind+2);
        // System.out.println(t+" "+ind);
        return lsf[ind];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */