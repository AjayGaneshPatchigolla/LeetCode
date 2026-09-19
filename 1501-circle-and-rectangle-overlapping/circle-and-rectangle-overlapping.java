class Solution {
    public double distance(int x1,int y1,int x2,int y2)
    {
        return Math.sqrt(Math.pow(y2-y1,2)+Math.pow(x2-x1,2));
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for(int i=x1;i<=x2;i++)
        {
            double dist=distance(i,y1,xCenter,yCenter); 
            if(dist<=radius)
            return true;
        }
        for(int i=x1;i<=x2;i++)
        {
            double dist=distance(i,y2,xCenter,yCenter); 
            if(dist<=radius)
            return true;
        }
        for(int i=y1;i<=y2;i++)
        {
            double dist=distance(x1,i,xCenter,yCenter); 
            if(dist<=radius)
            return true;
        }
        for(int i=y1;i<=y2;i++)
        {
            double dist=distance(x2,i,xCenter,yCenter); 
            if(dist<=radius)
            return true;
        }
        while(true)
        {
            x1+=1;
            y1+=1;
            if(x1>x2  || y1>y2)
            break;
            double dist=distance(x1,y1,xCenter,yCenter);
            if(dist<=radius)
            return true;
        }
        return false;
    }
}