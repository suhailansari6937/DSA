class Solution {
    private int helper(int i, int []arr,int []dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=Integer.MIN_VALUE) return dp[i];
      int take1 = arr[i]- helper(i+1,arr,dp);
      int take2 = arr[i]+((i+1<arr.length)?arr[i+1] : 0)- helper(i+2,arr,dp);
    int  take3 = arr[i]+((i+1<arr.length)?arr[i+1] : 0)+((i+2<arr.length)?arr[i+2] : 0) - helper(i+3,arr,dp);
      return dp[i]=Math.max(take1,Math.max(take2, take3));
    }
    public String stoneGameIII(int[] arr) {
        int []dp = new int[arr.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int alice = helper(0,arr,dp);
        
        if(alice>0) return "Alice";
        else if(alice<0) return "Bob";
        return "Tie";
    }
}