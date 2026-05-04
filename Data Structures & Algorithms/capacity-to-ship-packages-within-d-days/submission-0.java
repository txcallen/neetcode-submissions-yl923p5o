class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int min = 0;

        for(int w : weights){
            if(w > min){
                min = w;
            }
        }
        int l = min, r = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while(l <= r){

            int m = l + (r-l) / 2;
            if(canShip(m, weights, days)){
                res = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return res;
    }


    boolean canShip(int weight, int[] wights, int days){

        int cur = 0;
        int d = 0;
        for(int w : wights){
            
            if(cur > weight){
                return false;
            }else if(cur + w > weight){
                d++;
                cur = w;
            }else{
                cur += w;
            }
        }

        if(cur > 0){
            d++;
        }

        return d <= days;

    }
}