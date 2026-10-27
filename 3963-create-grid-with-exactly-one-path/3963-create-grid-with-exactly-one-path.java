class Solution {
    public String[] createGrid(int m, int n) {
        String[]ans = new String[m];
        String temp = "";
        for(int i=0;i<n;i++){
            temp+='.';
        }
        ans[0]=temp;
        for(int i=1;i<m;i++){
            temp="";
            for(int j=0;j<n;j++){
                if(j<n-1) temp+='#';
                else temp+='.';
            }
            ans[i]=temp;
        }
        return ans;
    }
}