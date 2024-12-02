import java.util.ArrayDeque;
import java.util.Deque;

public class LC1696MaxResult {
    public static void main(String[] args) {
        System.out.println();
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] ret = new int[n];
        ret[0] = nums[0];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n-1; i++) {
            while(!dq.isEmpty() &&  i - dq.peekFirst() >= k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && ret[dq.peekLast()] <= ret[i]) {
                dq.removeLast();
            }

            dq.addLast(i);
            ret[i + 1] = ret[dq.peekFirst()] + nums[i + 1];
        }

        return ret[n - 1];
    }
}
