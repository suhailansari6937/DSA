class Solution {
    public int countDaysTogether(String aa, String la, String ab, String lb) {
        int []days = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int amonth = Integer.parseInt(aa.substring(0,2));
        int adate = Integer.parseInt(aa.substring(3,5));
        int aday = adate;
        while(amonth>0){
            amonth--;
            aday+=days[amonth];
        }
         int bmonth = Integer.parseInt(ab.substring(0,2));
        int bdate = Integer.parseInt(ab.substring(3,5));
        int bday = bdate;
        while(bmonth>0){
            bmonth--;
            bday+=days[bmonth];
        }
        int min = Math.max(aday,bday);

        int janemontha= Integer.parseInt(la.substring(0,2));
        int janedatea = Integer.parseInt(la.substring(3,5));
        while(janemontha>0){
            janemontha--;
            janedatea+=days[janemontha];
        }
        int janemonthb= Integer.parseInt(lb.substring(0,2));
        int janedateb = Integer.parseInt(lb.substring(3,5));
        while(janemonthb>0){
            janemonthb--;
            janedateb+=days[janemonthb];
        }
        int max = Math.min(janedatea,janedateb);
        return max-min+1<=0? 0: max-min+1;
        
    }
}