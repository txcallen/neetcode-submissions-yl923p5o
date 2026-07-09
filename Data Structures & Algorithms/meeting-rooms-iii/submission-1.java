class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Queue<Integer> available = new PriorityQueue<>();
        Queue<int[]> ongoingMeetings = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] 
        : a[0] - b[0]); 

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            available.offer(i);
        }


        Arrays.sort(meetings, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for(int[] m : meetings){
            int start = m[0];
            int end = m[1];
            int dur = end - start;

            while(!ongoingMeetings.isEmpty() && ongoingMeetings.peek()[0] <= start){
                available.offer(ongoingMeetings.poll()[1]);
            }

            if(available.isEmpty()){
                int[] cur = ongoingMeetings.poll();
                end = cur[0] + dur;
                int room = cur[1];
                available.offer(room);
            }
            int curRoom = available.poll();
            ongoingMeetings.offer(new int[]{end, curRoom});
            res[curRoom]++;
        }

        while(!ongoingMeetings.isEmpty()){
            int[] cur = ongoingMeetings.poll();
            int room = cur[1];
            res[room]++;
        }

        // System.out.println(Arrays.toString(res));

        int max = 0;
        int resRoom = 0;
        for(int i = 0; i < n; i++){
            if(res[i] > max){
                max = res[i];
                resRoom = i;
            }
        }

        return resRoom;
    }
}