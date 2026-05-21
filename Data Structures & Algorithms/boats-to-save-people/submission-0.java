class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int l = 0, r = people.length-1;
        int n = people.length;

        Arrays.sort(people);
        int total = 0;
        while(l <= r){
            if(people[l] + people[r] <= limit){
                l++;
                r--;
            }else{
                r--;
            }
            total++;
        }


        return total;
    }
}