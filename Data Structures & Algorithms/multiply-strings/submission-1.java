class Solution {
    public String multiply(String num1, String num2) {
        
        long n1 = convert(num1);
        long n2 = convert(num2);

        return "" + n1 * n2;
    }

    long convert(String n){
        long num = 0;

        for(int i = 0; i < n.length(); i++){
            char cur = n.charAt(i);
            num += cur - '0';
            if(i == n.length()-1){
                return num;
            }else{
                num *= 10;
            }
        }

        return num;
    }
}
