public class LC643FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, max = 0;
        int left = 0, right = k;
        for (int i = 0; i < right; i++) {
            sum += nums[i];
        }
        max = sum;

        while (right < nums.length) {
            sum += nums[right++];
            sum -= nums[left++];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}
