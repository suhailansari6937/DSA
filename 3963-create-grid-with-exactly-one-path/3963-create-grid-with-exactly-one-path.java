class Solution {
    public String[] createGrid(int m, int n) {
        String[]ans = new String[m];
        StringBuilder  temp = new StringBuilder();
        for(int i=0;i<n;i++){
            temp.append('.');
        }
        ans[0]=temp.toString();
        for(int i=1;i<m;i++){
            temp=new StringBuilder();
            for(int j=0;j<n;j++){
                if(j<n-1) temp.append('#');
                else temp.append('.');
            }
            ans[i]=temp.toString();
        }
        return ans;
    }
}