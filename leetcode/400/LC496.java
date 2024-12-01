import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(new LC496().nextGreaterElement(nums1, nums2)));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int cur = nums2[i];
            while (!stack.isEmpty() && nums2[stack.peek()] < cur) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(cur, -1);
            } else {
                map.put(cur, nums2[stack.peek()]);
            }
            stack.push(i);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }

        return ret;
    }
}
