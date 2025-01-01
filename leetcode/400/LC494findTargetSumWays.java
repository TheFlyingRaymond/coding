import java.util.Arrays;

public class LC494findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || target + sum < 0 || (sum + target) % 2 == 1) {
            return 0;
        }
        return process(nums, (sum + target) / 2);
    }

    private int process(int[] nums, int target) {
        int[] pre = new int[target + 1];
        int[] cur = new int[target + 1];
        pre[0] = 1;
        for (int item : nums) {
            pre = cur = combine(pre, item);
        }
        return cur[target];
    }

    private int[] combine(int[] pre, int item) {
        int[] cur = new int[pre.length];
        cur[0] = 1;
        for (int i = 0; i < cur.length; i++) {
            cur[i] = pre[i];
            if (i - item >= 0) {
                cur[i] += pre[i - item];
            }
        }
        return cur;
    }
}
