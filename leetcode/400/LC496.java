import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(new LC496().nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(new LC496().nextGreaterElement2(nums1, nums2)));
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

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = getNext(nums1[i], nums2, map);
        }
        return ret;
    }

    private int getNext(int num, int[] nums2, Map<Integer, Integer> map) {
        int idx = map.get(num);

        for(int i = idx + 1; i < nums2.length; i++) {
            if (nums2[i] > num) {
                return nums2[i];
            }
        }

        return -1;
    }
}
