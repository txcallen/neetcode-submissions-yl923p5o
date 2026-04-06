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
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end 
        : a.start - b.start);

        if(intervals.size() <= 1) return true;

        int preEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if(start < preEnd){
                return false;
            }else{
                preEnd = end;
            }
        }

        return true;
    }
}
