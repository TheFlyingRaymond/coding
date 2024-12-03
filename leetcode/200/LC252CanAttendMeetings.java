import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC252CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int[] meet : intervals) {
            pq.add(new int[]{meet[0], 1});
            pq.add(new int[]{meet[1], -1});
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            cnt += pq.poll()[1];
            if (cnt > 1) {
                return false;
            }
        }

        return true;
    }

    public boolean canAttendMeetings2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
