import java.util.Arrays;

public class LC2090GetAverages {
    public int[] getAverages(int[] nums, int k) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);

        int windowSize = 2 * k + 1;
        if (nums.length < windowSize) {
            return ret;
        }

        long sum = 0;
        int left = 0, right = windowSize;

        for (int i = 0; i < right; i++) {
            sum += nums[i];
        }
        ret[right - k-1] = (int)(sum / windowSize);

        while(right < nums.length){
            sum -= nums[left++];
            sum += nums[right++];
            ret[right - k-1] = (int)(sum / windowSize);
        }

        return ret;
    }
}
