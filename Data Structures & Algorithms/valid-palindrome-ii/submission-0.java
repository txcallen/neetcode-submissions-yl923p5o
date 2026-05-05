class Solution {
    public boolean validPalindrome(String s) {
        
        int cnt = 0;

        int l = 0, r = s.length()-1;

        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return isValid(s, l, r-1) || isValid(s, l+1, r);
            }
        }

        return true;
    }

    boolean isValid(String s, int l, int r){

        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++; 
                r--;
            }else{
                return false;
            }
        }

        return true;
    }
}