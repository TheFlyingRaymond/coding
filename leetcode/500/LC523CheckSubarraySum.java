import java.util.HashMap;
import java.util.Map;

public class LC523CheckSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,6};
        int k = 7;

        System.out.println(new LC523CheckSubarraySum().checkSubarraySum(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> modAndIndex = new HashMap<>();
        modAndIndex.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (sum % k -k) %k;
            if(modAndIndex.containsKey(mod) && i+1 - modAndIndex.get(mod) >= 2){
                return true;
            }
            modAndIndex.putIfAbsent(mod, i+1);
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < prefixSum.length - 2; i++) {
            for (int j = i + 2; j < prefixSum.length; j++) {
                if ((prefixSum[j] - prefixSum[i]) % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
