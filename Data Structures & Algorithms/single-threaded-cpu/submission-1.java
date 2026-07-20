class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int[][] newTasks = new int[tasks.length][3];

        for(int i = 0; i < tasks.length; i++){
            newTasks[i] = new int[]{i, tasks[i][0], tasks[i][1]};
        }

        Queue<int[]> waiting = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        Queue<int[]> processing = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);


        for(int[] task : newTasks){
            waiting.offer(task);
        }

        List<Integer> res = new ArrayList<>();

        int[] cur = waiting.poll();
        res.add(cur[0]);
        int curTime = cur[1] + cur[2];

        while(!waiting.isEmpty()){

            while(!waiting.isEmpty() && curTime >= waiting.peek()[1]){
                processing.offer(waiting.poll());
            }

            if(!processing.isEmpty()){
                int[] next = processing.poll();
                res.add(next[0]);
                curTime = curTime + next[2];
            }else{
                curTime++;
            }
        }

        while(!processing.isEmpty()){
            int[] next = processing.poll();
            res.add(next[0]);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}