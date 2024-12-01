import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1019 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        return nextLargerNum(list);
    }

    private int[] nextLargerNum(List<Integer> list) {
        int n = list.size();

        Stack<Integer> stack = new Stack<>();

        int[] ret = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int cur = list.get(i);
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ret[i] = 0;
            } else {
                ret[i] = stack.peek();
            }

            stack.push(cur);
        }

        return ret;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
