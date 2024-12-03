import java.util.ArrayDeque;
import java.util.Deque;

public class LC862ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        long [] presum = new long[nums.length + 1];
        int  ret = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        for (int i = 1; i < presum.length; i++) {
            while(!dq.isEmpty() && presum[dq.peekLast()] >= presum[i]) {
                dq.removeLast();
            }

            while (!dq.isEmpty() && presum[i] - presum[dq.peekFirst()] >= k) {
                ret = Math.min(ret, i - dq.removeFirst());
            }

            dq.addLast(i);
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
