class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> change = new HashMap<>();
        change.put(5, 0);
        change.put(10, 0);
        change.put(20, 0);

        for(int bill : bills){
            if(bill == 5){
                change.put(5, change.get(5) + 1);
                continue;
            }else if(bill == 10){
                change.put(10, change.get(10) + 1);
                if(change.get(5) < 1){
                    return false;
                }
                change.put(5, change.get(5)-1);
            }else if(bill == 20){
                if(change.get(10) >= 1){
                    change.put(10, change.get(10)-1);
                    if(change.get(5) < 1){
                        return false;
                    }
                    change.put(5, change.get(5)-1);
                }else{
                    if(change.get(5) < 3){
                        return false;
                    }
                    change.put(5, change.get(5)-3);
                }
            }
        }

        return true;
    }
}