import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2841MaxSum {
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum  = 0, max = 0;
        int left = 0, right = k;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < right; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        if (map.size() >= m) {
            max = Math.max(sum, max);
        }

        while (right < nums.size()) {
            sum += nums.get(right);
            map.put(nums.get(right), map.getOrDefault(nums.get(right), 0) + 1);
            right++;

            sum -= nums.get(left);
            map.put(nums.get(left), map.get(nums.get(left)) - 1);
            if (map.get(nums.get(left)) == 0) {
                map.remove(nums.get(left));
            }
            left++;

            if (map.size() >= m) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
