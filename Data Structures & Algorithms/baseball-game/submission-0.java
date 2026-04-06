class Solution {
    public int calPoints(String[] operations) {
        
        List<Integer> list = new ArrayList<>();

        for(String s : operations){
            if("+".equals(s)){
                int numA = list.get(list.size()-1);
                int numB = list.get(list.size()-2);
                int plus = numA + numB;
                list.add(plus);
            }else if("C".equals(s)){
                list.remove(list.size()-1);
            }else if("D".equals(s)){
                list.add(list.get(list.size()-1) * 2);
            }else{
                list.add(Integer.valueOf(s));
            }
        }

        int sum = 0;

        for(int n : list){
            sum += n;
        }

        return sum;
    }
}