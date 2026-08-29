class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Map<Integer, Integer> gp = new HashMap<>();
        Map<Integer,PriorityQueue<Integer>> dsu = new HashMap<>();
        int group=0;
        int []arr = nums.clone();
        Arrays.sort(arr);
        gp.put(arr[0],0);
        dsu.put(0,new PriorityQueue<>());
        dsu.get(0).add(arr[0]);
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<=limit){
                gp.put(arr[i],group);
            }
            else{
                group++;
                gp.put(arr[i],group);

            }
            dsu.putIfAbsent(group,new PriorityQueue<>());
            dsu.get(group).add(arr[i]);
        }
        int []ans = new int[n];
        for(int i=0;i<n;i++){
            int belongingGroup = gp.get(nums[i]);
            ans[i] = dsu.get(belongingGroup).remove();
        }
        return ans;

        
    }
}