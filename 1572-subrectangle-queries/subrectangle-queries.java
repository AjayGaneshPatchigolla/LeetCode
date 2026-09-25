class SubrectangleQueries {

    int rectangle[][];
    List<Pair> operations;
    static class Pair
    {
        int x1,y1,x2,y2,v;
        Pair(int x1,int y1,int x2,int y2,int v)
        {
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
            this.v=v;
        }
    }
    public SubrectangleQueries(int[][] rectangle) {
        operations=new ArrayList<>();
        this.rectangle=rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        operations.add(new Pair(row1,col1,row2,col2,newValue));
    }
    
    public int getValue(int row, int col) {
        for(int i=operations.size()-1;i>=0;i--)
        {
            Pair t=operations.get(i);
            if(row>=t.x1 && row<=t.x2 && col>=t.y1 && col<=t.y2)
            return t.v;
        }
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */