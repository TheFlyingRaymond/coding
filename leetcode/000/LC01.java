import java.util.HashMap;
import java.util.Map;

public class LC01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                return new int[]{i, map.get(a)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
