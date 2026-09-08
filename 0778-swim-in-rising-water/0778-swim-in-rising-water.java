class Solution {
    int []dr ={-1,0,1,0};
    int []dc={0,1,0,-1};
    static class pair{
        int i;
        int j;
        int t;
        pair(int i, int j, int t){
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.t,b.t));
        int r = grid.length;
        int c = grid[0].length;
        boolean[][]visited = new boolean[r][c];
        visited[0][0]=true;
        pq.add(new pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            pair top = pq.remove();
            if(top.i==r-1 && top.j==c-1) return top.t;
            for(int k=0;k<4;k++){
                int nr = top.i+dr[k];
                int nc = top.j+dc[k];
                if(nr<0 || nc<0 || nr>=r || nc>=c) continue;
                if(!visited[nr][nc]){
                    visited[nr][nc]=true;
                    pq.add(new pair(nr,nc,Math.max(grid[nr][nc],top.t)));
                }
            }
        }
        return -1;

        
    }
}