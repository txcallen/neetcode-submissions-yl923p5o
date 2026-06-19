class Solution {

    int idx = 0;
    public String decodeString(String s) {
        
        return decode(s);

    }


    private String decode(String s){
        StringBuilder sb = new StringBuilder();
        
        while(idx < s.length() && s.charAt(idx)!=']'){

            char cur = s.charAt(idx);

            if(Character.isLetter(cur)){
                sb.append(cur);
                idx++;
            }else{
                int mul = 0;
                while(idx < s.length() && s.charAt(idx) != '['){
                    mul = mul * 10 + s.charAt(idx) - '0';
                    idx++;
                }

                idx++;

                String inner = decode(s);

                idx++;

                sb.append(inner.repeat(mul));
            }

        }

        return sb.toString();

    }
}