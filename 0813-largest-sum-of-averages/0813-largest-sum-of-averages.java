class Solution {
    private double helper(int i, int []nums,int k,double [][]dp){
        if(i>=nums.length || k<0) return 0;
        if(k==0) {
            if(i==nums.length) return 0;
            return Integer.MIN_VALUE;
            }
            if(dp[i][k]!=-1) return dp[i][k];
        double sum=0;
        double ans=Integer.MIN_VALUE;
        for(int x=i;x<nums.length;x++){
            sum+=nums[x];
            ans = Math.max(ans,sum/(x-i+1)+ helper(x+1,nums,k-1,dp));
        }
        return dp[i][k]=ans;

    }
    public double largestSumOfAverages(int[] nums, int k) {
        // int n =nums.length;
        double [][]dp = new double[nums.length][k+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
       return helper(0,nums,k,dp);

        
    }
}