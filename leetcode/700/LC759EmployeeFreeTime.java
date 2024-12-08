import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC759EmployeeFreeTime {

    public List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
        for (List<Interval> list : schedule) {
            pq.addAll(list);
        }

        List<Interval> ret = new ArrayList<>();

        Interval pre = null;

        while(!pq.isEmpty()) {
            if (pre == null) {
                pre = pq.poll();
                continue;
            }

            Interval cur = pq.poll();
            if (cur.start > pre.end) {
                ret.add(new Interval(pre.end, cur.start));
                pre = cur;
                continue;
            }
            pre.end = Math.max(pre.end, cur.end);
        }

        return ret;
    }


    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
        for (List<Interval> list : schedule) {
            pq.addAll(list);
        }

        List<Interval> ret = new ArrayList<>();

        Interval pre = null;

        while(!pq.isEmpty()) {
            if (pre == null) {
                pre = pq.poll();
                continue;
            }

            Interval cur = pq.poll();
            if (cur.start > pre.end) {
                ret.add(new Interval(pre.end, cur.start));
                pre = cur;
                continue;
            }
            pre.end = Math.max(pre.end, cur.end);
        }

        return ret;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
}
