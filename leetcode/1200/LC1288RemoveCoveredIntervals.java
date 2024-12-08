import java.util.Arrays;

public class LC1288RemoveCoveredIntervals {


    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });


        int removeCnt = 0;

        int[] pre = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (pre[0] <= cur[0] && pre[1] >= cur[1]) {
                removeCnt++;
            }else {
                pre = cur;
            }
        }

        return intervals.length - removeCnt;
    }
}
