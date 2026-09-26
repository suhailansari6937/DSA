class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        Map<String,String> mp = new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            mp.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        int count=0;
        int l=-1;
        int r =-1;
        for(int i=0;i<s.length();){
            char ch = s.charAt(i);
            if(ch=='(') {
                count++;
                l=i+1;
                r=l;
            while(count>0){
                if(s.charAt(r)==')') {
                    if(mp.containsKey(s.substring(l,r)))
                    sb.append(mp.get(s.substring(l,r)));
                    else sb.append('?');
                    count=0;
                    }
                   else r++;
                }
                i=r+1;
            }
            else {
                sb.append(ch);
                i++;}

        }
        return sb.toString();
    }
}