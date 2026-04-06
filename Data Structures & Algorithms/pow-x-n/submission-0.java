class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        
        double res = cal(x, Math.abs((long) n));
        if(n < 0){
            return 1 / res;
        }else{
            return res;
        }
    }

    double cal(double x, long n){
        if(n == 0){
            return 1;
        }
        double half = cal(x, n/2);
        if(n % 2 == 0){
            return half * half;
        }else{
            return x * half * half;
        }
        
    }
}
