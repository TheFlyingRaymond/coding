import java.util.HashMap;
import java.util.Map;

public class LC525FindMaxLength {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ret = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int pos = i+1;
            int len = 0;
            //定义为：1的个数-0的个数
            int oneCount = sum;
            int zeroCount = pos - sum;

            if (oneCount == zeroCount) {
                ret = Math.max(ret, pos);
            }

            int diff = oneCount - zeroCount;
            if (map.containsKey(diff)) {
                Integer pos2 = map.get(diff);
                len = Math.max(len, pos - pos2);
            }
            ret = Math.max(ret, len);
            map.putIfAbsent(diff, pos);
        }

        return ret;
    }

    public int findMaxLength2(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int ret = 0;

        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i+1; j < prefixSum.length; j++) {
                int len = j-i;
                int sum = prefixSum[j] - prefixSum[i];
                if (sum * 2 == len) {
                    ret = Math.max(ret, len);
                }
            }
        }

        return ret;
    }
}
