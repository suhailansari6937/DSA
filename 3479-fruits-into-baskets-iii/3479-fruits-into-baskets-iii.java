class Solution {
    private void buildSegMentTree(int i, int l, int r, int []seg,int []arr){
        if(l==r){
            seg[i] = l;
            return;
        }
        int mid = l+(r-l)/2;
        buildSegMentTree(2*i+1,l,mid,seg,arr);
        buildSegMentTree(2*i+2,mid+1,r,seg,arr);
        if(arr[seg[2*i+1]]>arr[seg[2*i+2]]) seg[i] = seg[2*i+1];
        else seg[i]=seg[2*i+2];
    }
    private void update(int i, int idx,int val,int l, int r, int []seg, int arr[]){
        if(l==r){
            seg[i] =l;
            arr[l]=-1;
            return; 
        }
        int mid = l+(r-l)/2;
        if(idx<=mid)update(2*i+1,idx,val,l,mid,seg,arr);
        else update(2*i+2,idx,val,mid+1,r,seg,arr);
        if(arr[seg[2*i+1]]>arr[seg[2*i+2]]) seg[i] = seg[2*i+1];
        else seg[i]=seg[2*i+2];
        
    }
    private int find(int i,int l, int r,int val,int []seg,int n,int []arr){
        if(arr[seg[i]]<val) return -1;
        if(l==r) return l;
        int mid = l+(r-l)/2;
        int left = find(2*i+1,l,mid,val,seg,n,arr);
        if(left!=-1) return left;
        return find(2*i+2,mid+1,r,val,seg,n,arr);

    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int []seg = new int[4*n];
        int ans=0;
        buildSegMentTree(0,0,n-1,seg,baskets);
        for(int i=0;i<n;i++){
            int val = fruits[i];
            int idx = find(0,0,n-1,val,seg,n,baskets);
            if(idx>=0){
                update(0,idx,-1,0,n-1,seg,baskets);
            }
            else ans++;
        }
        return ans;
        
    }
}