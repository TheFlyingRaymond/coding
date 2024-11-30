import java.util.Arrays;

public class LC16 {
    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(new LC16().threeSumClosest(nums, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int curSum = twoSumClosest(nums, i + 1, nums.length - 1, target - nums[i]) + nums[i];
            if(curSum == target){
                return target;
            }
            int diff = Math.abs(curSum - target);
            if (diff < minDiff) {
                ret = curSum;
                minDiff = diff;
            }
        }
        return ret;
    }

    public int twoSumClosest(int[] nums, int left, int right, int target) {
        int ret = 0;
        int minDiff = Integer.MAX_VALUE;
        while (left < right) {
            int tmp = nums[left] + nums[right];
            if (tmp == target) {
                return target;
            }
            int diff = Math.abs(tmp - target);
            if(diff < minDiff){
                ret = tmp;
                minDiff = diff;
            }

            if (tmp <= target) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }
}
