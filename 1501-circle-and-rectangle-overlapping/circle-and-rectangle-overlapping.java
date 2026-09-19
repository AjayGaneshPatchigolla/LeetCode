class Solution {
    public double distance(int x1,int y1,int x2,int y2)
    {
        return Math.sqrt(Math.pow(y2-y1,2)+Math.pow(x2-x1,2));
    }
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closeX=xCenter,closeY=yCenter;
        if(xCenter<x1)
        closeX=x1;
        else if(xCenter>x2)
        closeX=x2;
        if(yCenter<y1)
        closeY=y1;
        else if(yCenter>y2)
        closeY=y2;
        double dist=distance(closeX,closeY,xCenter,yCenter);
        if(dist<=radius)
        return true;
        return false;
    }
}