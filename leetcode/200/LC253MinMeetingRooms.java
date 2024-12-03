import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] pre = pq.poll();
            int[] cur = intervals[i];
            if (pre[1] <= cur[0]) {
                pre[1] = cur[1];
            }else {
                pq.offer(cur);
            }
            pq.offer(pre);
        }

        return pq.size();
    }


    public int minMeetingRooms2(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
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
        int max = 0;
        while (!pq.isEmpty()) {
            cnt += pq.poll()[1];
            max = Math.max(max, cnt);
        }

        return max;
    }
}
