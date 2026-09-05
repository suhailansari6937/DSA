class Solution {
    public int balancedString(String s) {
        int[]freq = new int[128];
        for(char ch : s.toCharArray()) freq[ch]++;
        int res = s.length();
        int j=0;
        int k = s.length()/4;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]--;
            while(j<s.length() && freq['Q']<=k && freq['W']<=k && freq['E']<=k && freq['R']<=k){
                res = Math.min(res,i-j+1);
                freq[s.charAt(j)]++;
                j++;
            }
        }
        return res;
    }
}