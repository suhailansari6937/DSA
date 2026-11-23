class ProductOfNumbers {
    List<Integer> li;
    List<Integer> pro;
    public ProductOfNumbers() {
        li = new ArrayList<>();
        
    }
    
    public void add(int num) {
        li.add(num);
    }
    
    public int getProduct(int k) {
        int n = li.size();
        int ans =1;
        for(int i=n-1;i>=n-k;i--) ans*=li.get(i);
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */