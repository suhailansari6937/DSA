class Solution {
    void update(int i, int l, int r, int []seg,int idx){
        if(l==r){
            seg[i]+=1;
            return;
        }
        int mid = l+(r-l)/2;
        if(idx<=mid)
        update(2*i+1,l,mid,seg,idx);
        else update(2*i+2,mid+1,r,seg,idx);
        seg[i]=seg[2*i+1] + seg[2*i+2];
    }
    int rangeSum(int i, int l, int r, int []seg,int st, int end){
        if(r<st || end<st) return 0;
        if(l>=st && r<=end) return seg[i];
        int mid = l+(r-l)/2;
        return rangeSum(2*i+1,l,mid,seg,st,end) + rangeSum(2*i+2,mid+1,r,seg,st,end);
    }
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int temp=0;
        Map<Integer, Integer> mp = new HashMap<>();
        int []temparr = nums.clone();
        Arrays.sort(temparr);
        for(int i=0;i<n;i++){
            if(mp.containsKey(temparr[i])) continue;
            mp.put(temparr[i],temp);
            temp++;
        }
        int size = mp.size();
        int []seg1 = new int[4*size];
        int []seg2 = new int[4*size];
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        li1.add(nums[0]);
        li2.add(nums[1]);
        update(0,0,size-1,seg1,mp.get(nums[0]));
        update(0,0,size-1,seg2,mp.get(nums[1]));
        for(int i=2;i<n;i++){
            int idx = mp.get(nums[i]);
            int gc1=rangeSum(0,0,size-1,seg1,idx+1,size-1);
            int gc2 = rangeSum(0,0,size-1,seg2,idx+1,size-1);
            if(gc1>gc2){
                li1.add(nums[i]);
                update(0,0,size-1,seg1,idx);
            }
            else if(gc1<gc2){
                li2.add(nums[i]);
                update(0,0,size-1,seg2,idx);

            }
            else{
                if(li1.size()<li2.size()){
                    li1.add(nums[i]);
                update(0,0,size-1,seg1,idx);
                }
                else if(li1.size()>li2.size()){
                    li2.add(nums[i]);
                update(0,0,size-1,seg2,idx);
                }
                else{ // size is same
                    li1.add(nums[i]);
                update(0,0,size-1,seg1,idx);
                }
            }
        }
        int ans[] = new int[n];
        int x =0;
        for(int i=0;i<li1.size();i++) ans[x++] = li1.get(i);
        for(int i=0;i<li2.size();i++) ans[x++] = li2.get(i);
        return ans;

        
    }
}