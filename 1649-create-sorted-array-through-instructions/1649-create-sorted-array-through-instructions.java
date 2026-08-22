class Solution {
    int mod = (int) 1e9 + 7;
    int rangeSum(int i, int []seg, int l, int r,int st, int end){
        if(end<l || st>r) return 0;
        if(l>=st && r<=end) return seg[i];
        int mid = l+(r-l)/2;
         return rangeSum(2*i+1,seg,l,mid,st,end) + rangeSum(2*i+2,seg,mid+1,r,st,end);
    }
    void update(int i,int seg[], int l, int r,int idx){
        if(l==r){
            seg[i]+=1;
            return;
        }
        int mid = l+(r-l)/2;
        if(idx<=mid){ // move left
            update(2*i+1,seg,l,mid,idx);
        }
        else{
            update(2*i+2,seg,mid+1,r,idx);
        }
        seg[i] = seg[2*i+1] + seg[2*i+2];

    }
    public int createSortedArray(int[] instructions) {
        int n = instructions.length;
        int max = Integer.MIN_VALUE;
        for(int val : instructions) max = Math.max(max,val);
        int []seg = new int[4*(max)+1];
        int ans =0;
        for(int i=0;i<n;i++){
            int idx = instructions[i];
           
            int minEle = rangeSum(0,seg,0,max,0,idx-1);
            int maxEle = rangeSum(0,seg,0,max,idx+1,max);
            update(0,seg,0,max,idx);
            ans+=Math.min(minEle, maxEle);
            ans%=mod;
            
        }
        return ans;
        
    }
}