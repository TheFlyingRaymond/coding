import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC239MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new LC239MaxSlidingWindow().maxSlidingWindow(nums,3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }
            while (!dq.isEmpty() && (i - dq.getFirst()) >= k) {
                dq.removeFirst();
            }

            dq.addLast(i);
            if (i+1 >= k) {
                ret[i+1-k] = nums[dq.peekFirst()];
            }
        }

        return ret;
    }
}
