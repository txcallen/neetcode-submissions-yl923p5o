class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = digits.length-1; i >= 0; i--){
            int cur = digits[i];
            if(i == digits.length-1){
                cur = ++cur + carry;
            }else{
                cur += carry;
            }
            carry = cur == 10 ? 1 : 0;
            cur %= 10;
            list.add(cur);
            System.out.println(cur);
        }

        if(carry != 0){
            list.add(carry);
        }


        int[] res = new int[list.size()];
        int idx = res.length-1;
        for(int i = 0; i < list.size(); i++){
            res[idx--] = list.get(i);
        }

        return res;
    }
}
