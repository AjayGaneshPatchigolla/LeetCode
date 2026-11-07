class Solution {
    static class Pair
    {
        int server,weight,task=-1;
        long time=-1;
        Pair(int server,int weight)
        {
            this.server=server;
            this.weight=weight;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length;
        int taskCount=tasks.length;
        int ans[]=new int[taskCount];
        PriorityQueue<Pair> cluster=new PriorityQueue<>((a,b) -> {
            if(a.weight==b.weight)
            return a.server-b.server;
            return a.weight-b.weight;
        });

        for(int i=0;i<n;i++)
        cluster.add(new Pair(i,servers[i]));
        PriorityQueue<Pair> current=new PriorityQueue<>((a,b) -> {
            return Long.compare(a.time,b.time);
        });
        long cts=0;
        for(int i=0;i<taskCount;i++)
        {
            cts=Math.max(cts,i);
            while(!current.isEmpty() && current.peek().time<=cts)
            {
                Pair tmp=current.poll();
                ans[tmp.task]=tmp.server;
                cluster.add(tmp);
            }

            if(cluster.isEmpty())
            {
                cts=current.peek().time;
                while(!current.isEmpty() && current.peek().time<=cts)
                {
                    Pair tmp=current.poll();
                    ans[tmp.task]=tmp.server;
                    cluster.add(tmp);
                }
            }

            Pair tmp=cluster.poll();
            tmp.time=cts+tasks[i];
            tmp.task=i;
            current.add(tmp);
        }
        
        while(!current.isEmpty())
        {
            Pair tmp=current.poll();
            ans[tmp.task]=tmp.server;
            cluster.add(tmp);
        }

        return ans;
    }
}