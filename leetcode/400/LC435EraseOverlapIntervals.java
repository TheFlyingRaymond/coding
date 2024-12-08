import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class LC435EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };

        int ret = new LC435EraseOverlapIntervals().eraseOverlapIntervals(intervals);
        System.out.println(ret);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if (a[1] == b[1]) {
                return a.length -b.length;
            }
            return a[1] - b[1];
        });

        Stack<int[]> stack = new Stack<>();

        for (int[] item : intervals) {
            if (stack.isEmpty() || stack.peek()[1] <= item[0]) {
                stack.push(item);
            }
        }

        return intervals.length - stack.size();
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[1]));
        int cnt = 0;
        int[] pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] < pre[1]) {
                cnt++;
                continue;
            }
            pre = cur;
        }
        return cnt;
    }
}
