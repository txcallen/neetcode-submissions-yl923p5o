/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Queue<Interval> que = new PriorityQueue<>((a, b) -> a.end - b.end);

        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : 
        a.start - b.start);

        int size = 0;
        for(int i = 0; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(!que.isEmpty() && que.peek().end <= cur.start){
                que.poll();
            }
            que.offer(cur);
            size = Math.max(que.size(), size);
        }

        return size;
    }
}
