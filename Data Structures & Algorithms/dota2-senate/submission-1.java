class Solution {
    public String predictPartyVictory(String senate) {
        
        Queue<Integer> queR = new LinkedList<>();
        Queue<Integer> queD = new LinkedList<>();
        int n = senate.length();
        for(int i = 0; i < senate.length(); i++){
            char cur = senate.charAt(i);
            if('R' == cur){
                queR.offer(i);
            }else{
                queD.offer(i);
            }
        }


        while(!queR.isEmpty() && !queD.isEmpty()){
            int idxR = queR.poll();
            int idxD = queD.poll();

            if(idxR < idxD){
                queR.offer(idxR+n);
            }else{
                queD.offer(idxD+n);
            }
        }


        if(queR.isEmpty()){
            return "Dire";
        }

        if(queD.isEmpty()){
            return "Radiant";
        }

        return "";
    }
}