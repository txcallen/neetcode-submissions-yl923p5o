class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();

        int idx1 = 0;
        int idx2 = 0;
        boolean w1 = true;
        while(idx1 < word1.length() && idx2 < word2.length()){
            if(w1){
                sb.append(word1.charAt(idx1++));
            }else{
                sb.append(word2.charAt(idx2++));
            }
            w1 = !w1;
        }


        if(idx1 < word1.length()){
            sb.append(word1.substring(idx1, word1.length()));
        }

        if(idx2 < word2.length()){
            sb.append(word2.substring(idx2, word2.length()));
        }

        return sb.toString();
    }
}