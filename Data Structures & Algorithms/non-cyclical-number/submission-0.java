class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int number = n;
        while(!seen.contains(number)){
            seen.add(number);
            number = sumOfSq(number);
            if(number == 1){
                return true;
            }
        }


        return false;
    }

    private int sumOfSq(int n){
        int num = 0;

        while(n > 0){
            int digit = n % 10;
            num += digit * digit;
            n /= 10;
        }

        return num;
    }
}
