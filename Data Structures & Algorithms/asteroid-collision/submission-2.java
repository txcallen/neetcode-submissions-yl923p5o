class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        LinkedList<Integer> res = new LinkedList<>();

        Deque<Integer> dq = new ArrayDeque<>();


        for(int a : asteroids){
            while(!dq.isEmpty() && dq.peek() > 0 && a < 0){
                int diff = dq.peek() - Math.abs(a);
                if(diff > 0){
                    a = 0;
                }else if(diff < 0){
                    dq.pop();
                }else{
                    dq.pop();
                    a = 0;
                }
            }

            if(a != 0){
                dq.push(a);
            }
        }

        for(int n : dq){
            res.addFirst(n);
        }

        return res.stream().mapToInt(n -> n).toArray();


    }
}