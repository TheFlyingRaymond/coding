import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC4353MaxEvents {
    public static void main(String[] args) {
        int[][] events = {
                {1, 5},
                {1, 5},
                {1, 5},
                {2, 3},
                {2, 3}};
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {
        //开始时间排序
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int ret = 0;
        int day = 1;
        int i = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        while (i < events.length || !pq.isEmpty()) {
            //当天新加的会议全部入队
            while (i < events.length && events[i][0] == day) {
                pq.offer(events[i]);
                i++;
            }

            //清除那些已经失去机会的
            while (!pq.isEmpty() && pq.peek()[1] < day) {
                pq.poll();
            }

            //选一个
            if (!pq.isEmpty()) {
                pq.poll();
                ret++;
            }
            day++;
        }

        return ret;
    }
}
