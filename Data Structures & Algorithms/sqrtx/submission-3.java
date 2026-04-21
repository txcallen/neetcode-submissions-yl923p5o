class Solution {
    public int mySqrt(int x) {
        
        int left  = 1, right = x;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long cal = (long) mid * mid;
            if(cal <= x){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return res;
    }
}