class pair{
    int i;
    int j;
    int val;
    int k;
    pair(int i, int j, int val, int k){
        this.i=i;
        this.j =j;
        this.val = val;
        this.k=k;
    }
}
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
       pq.add(new pair(0,0,0,k));
boolean[][][] visited = new boolean[r][c][k+1];
visited[0][0][k] = true;
        while(!pq.isEmpty()){
            pair top = pq.remove();
           
            if(top.i==r-1 && top.j==c-1) return top.val;
            for(int x=0;x<4;x++){
                int nr = top.i + dr[x];
                int nc =top.j + dc[x];
                if(nr<0 || nc<0 || nr>=r || nc>=c) continue;
                if(!visited[nr][nc][top.k] && grid[nr][nc]==0){ 
                    pq.add(new pair(nr,nc,top.val+1,top.k));
                     visited[nr][nc][top.k] = true;
                     }
                else if(grid[nr][nc]==1 && top.k>0 && !visited[nr][nc][top.k-1] ) {
                    pq.add(new pair(nr,nc,top.val+1,top.k-1));
                     visited[nr][nc][top.k-1] = true;
                     }
            }
        }
        return -1;
        
    }
}