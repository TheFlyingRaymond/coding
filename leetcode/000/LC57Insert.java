import java.util.*;

public class LC57Insert {
    public static void main(String[] args) {
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean used = false;
        for (int[] item : intervals) {
            if (used || item[1] < newInterval[0]) {
                list.add(item);
            } else if (newInterval[1] < item[0]) {
                list.add(newInterval);
                list.add(item);
                used = true;
            } else {
                newInterval[0] = Math.min(item[0], newInterval[0]);
                newInterval[1] = Math.max(item[1], newInterval[1]);
            }
        }

        if (!used) {
            list.add(newInterval);
        }

        return list.toArray(new int[list.size()][]);
    }



    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        Stack<int[]> stack = new Stack<>();
        boolean used =false;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (!used && newInterval[0] <= cur[0]) {
                cur = newInterval;
                used = true;
                i--;
            }

            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }

            int[] pre = stack.peek();
            if (pre[1] >= cur[0]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                stack.push(cur);
            }
        }

        if(!used){
            int[] cur = newInterval;
            int[] pre = stack.peek();
            if (pre[1] >= cur[0]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                stack.push(cur);
            }
        }

        int[][] ret = new int[stack.size()][2];
        for (int i = 0; i < ret.length; i++) {
            ret[ret.length-1-i] = stack.pop();
        }

        return ret;
    }

}
