class Solution {
    private boolean helper(int[]piles,int mid,int h){
        int n =piles.length;
        long temp =0;
        for(int i=0;i<n;i++){
            temp+=(piles[i]+mid-1)/mid;
        }
        return temp<=h;
    }
    public int minEatingSpeed(int[] piles, int hour) {
        int l = 1;
        int h = (int)1e9;
        int ans =-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(helper(piles,mid,hour)){
                ans =mid;
                h = mid-1;
            }
            else l = mid+1;
        }
        return ans;
        
    }
}