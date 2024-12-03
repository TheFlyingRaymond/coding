import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LC1438LongestSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{8,7,4,2,8,1,7,7};
        System.out.println(new LC1438LongestSubarray().longestSubarray(nums,8));
    }

    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        Deque<Integer> decrease = new ArrayDeque<>();
        Deque<Integer> increase = new ArrayDeque<>();

        int ret = 0, left = 0;

        for(int i = 0; i < n; i++) {
            while (!increase.isEmpty() && increase.peekLast() < nums[i]) {
                increase.removeLast();
            }
            while (!decrease.isEmpty() && decrease.peekLast() > nums[i]) {
                decrease.removeLast();
            }

            increase.addLast(nums[i]);
            decrease.addLast(nums[i]);

            if (Math.abs(increase.peekFirst() - decrease.peekFirst())>limit) {
                if (increase.peekFirst() == nums[left]) {
                    increase.removeFirst();
                }
                if (decrease.peekFirst() == nums[left]) {
                    decrease.removeFirst();
                }
                left ++;
            }

            ret = Math.max(ret, i - left + 1);
        }


        return ret;
    }
}
