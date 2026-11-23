class ProductOfNumbers {
    ArrayList<Integer> ar;
    int prod;
    public ProductOfNumbers() {
        ar=new ArrayList<>();
        prod=1;
    }
    
    public void add(int num) {
        if(num==0){
            prod=1;
            ar=new ArrayList<>();
            return;
        }
        prod*=num;
        ar.add(prod);
    }
    
    public int getProduct(int k) {
        if(ar.size()<k)return 0;
        if(k==ar.size())return prod;
        int val=ar.get(ar.size()-k-1);
        return prod/val;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */