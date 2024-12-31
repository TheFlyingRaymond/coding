import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC377CombinationSum4 {
    int ret = 0;
    private Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new LC377CombinationSum4().combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        ret = 0;
        memo.clear();
        return backtrack(nums, target, 0);
    }

    private int backtrack(int[] nums, int target, int currentSum) {
        if (currentSum == target) {
            return 1;
        }
        if (currentSum > target) {
            return 0;
        }

        if (memo.containsKey(currentSum)) {
            return memo.get(currentSum);
        }

        int count = 0;
        for (int num : nums) {
            count += backtrack(nums, target, currentSum + num);
        }
        memo.put(currentSum, count);
        return count;
    }
}
