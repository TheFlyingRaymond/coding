import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class LC1696MaxResult {
    public static void main(String[] args) {
        System.out.println();
    }

    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, (a, b) -> b[1] - a[1]);
        int[] ret = new int[nums.length];
        ret[0] = nums[0];
        pq.add(new int[]{0, nums[0]});

        for (int i = 0; i < nums.length-1; i++) {
            while(!pq.isEmpty() && i - pq.peek()[0] >= k){
                pq.poll();
            }
            while (!pq.isEmpty() && pq.peek()[1] < ret[i]) {
                pq.poll();
            }

            pq.add(new int[]{i, ret[i]});

            ret[i+1] = pq.peek()[1] + nums[i+1];
        }

        return ret[nums.length-1];
    }



    public int maxResult2(int[] nums, int k) {
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
