class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int l1 = str1.length(); 
        int l2 = str2.length();

        for(int i = Math.min(l2, l1); i >= 1; i--){
            String curString = str1.substring(0, i);
            if(canSplit(str1, str2, curString)){
                return curString;
            }
        }

        return "";
    }

    boolean canSplit(String s1, String s2, String cur){
        int l1 = s1.length(), l2 = s2.length(), lc = cur.length();

        if(l1 % lc != 0 || l2 % lc != 0){
            return false;
        }

        

        int c1 = l1 / lc;
        int c2 = l2 / lc;

        return cur.repeat(c1).equals(s1) && cur.repeat(c2).equals(s2);
    }
}