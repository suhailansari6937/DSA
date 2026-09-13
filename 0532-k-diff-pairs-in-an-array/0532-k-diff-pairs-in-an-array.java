class Solution {
    private boolean find(int []nums,int l, int h, int val){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]==val) return true;
            if(nums[mid]<val) l = mid+1;
            else h = mid-1;
        }
        return false;
    }
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<String> st = new HashSet<>();
        int n = nums.length;
        int ans =0;
        for(int i=0;i<n;i++){
            if(!st.contains(nums[i]+"#"+k+nums[i]) && find(nums,i+1,n-1,k+nums[i])){
                ans++;
                st.add(nums[i]+"#"+k+nums[i]);
            }
        }
        return ans;
        
    }
}