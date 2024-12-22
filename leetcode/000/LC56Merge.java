import java.util.*;

public class LC56Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        Stack<int[]> stack = new Stack<>();
        for (int[] item : intervals) {
            if (stack.isEmpty() || stack.peek()[1] < item[0]) {
                stack.push(item);
            } else {
                stack.peek()[1] = Math.max(stack.peek()[1], item[1]);

            }
        }

        int[][] ret = new int[stack.size()][2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.pop();
        }

        return ret;
    }
}
