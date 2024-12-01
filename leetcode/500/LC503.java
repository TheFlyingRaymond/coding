import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC503 {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(new LC503().nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int cur = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ret[i % n] = -1;
            } else {
                ret[i % n] = stack.peek();
            }
            stack.push(nums[i % n]);
        }

        return ret;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int cur = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] <= cur) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                map.put(i % n, stack.peek() );
            }
            stack.push(i % n);
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = -1;
            if (map.containsKey(i)) {
                ret[i] = nums[map.get(i)];
            }
        }
        return ret;
    }
}
