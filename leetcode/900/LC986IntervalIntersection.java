import java.util.ArrayList;
import java.util.List;

public class LC986IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i1 = 0, i2 = 0;
        List<int[]> ret = new ArrayList<>();
        while (i1 < firstList.length && i2 < secondList.length) {
            int[] cur1 = firstList[i1];
            int[] cur2 = secondList[i2];

            int end = Math.min(cur1[1], cur2[1]);
            int start = Math.max(cur1[0], cur2[0]);
            if (end >= start) {
                ret.add(new int[]{start, end});
            }

            if (i1 < firstList.length && cur1[1] <= cur2[1]) {
                i1++;
            } else {
                i2++;
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }

    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        int i1 = 0, i2 = 0;
        List<int[]> ret = new ArrayList<>();

        while (i1 < firstList.length && i2 < secondList.length) {
            int[] cur1 = firstList[i1];
            int[] cur2 = secondList[i2];

            if (cur1[1] < cur2[0]) {
                i1++;
                continue;
            }

            if (cur2[1] < cur1[0]) {
                i2++;
                continue;
            }

            int end = Math.min(cur1[1], cur2[1]);
            int start = Math.max(cur1[0], cur2[0]);
            ret.add(new int[]{start, end});

            if (cur1[1] > cur2[1]) {
                i2++;
            } else {
                i1++;
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
