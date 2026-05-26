class Solution {
    public String convertToTitle(int columnNumber) {
        
        String res = "";
        while(columnNumber > 0){
            columnNumber--;
            int c = columnNumber % 26;
            res += (char)('A'+c);
            columnNumber /= 26;
        }

        return new StringBuilder(res).reverse().toString();
    }
}