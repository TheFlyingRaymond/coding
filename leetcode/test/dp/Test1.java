package dp;

import java.util.Arrays;

import org.junit.Assert;

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4,0};
        int ret = maxSubSum(nums);
        int ret2 = Arrays.stream(nums).filter(x -> x > 0).sum();
        Assert.assertTrue(ret == ret2);
    }

    public static int maxSubSum(int[] nums){
        int n = nums.length;
        int funcPre = 0, funcCur = 0;
        for (int i = 1; i <= n ; i++) {
            funcCur = combine(funcPre, nums[i - 1]);
            funcPre = funcCur;
        }
        return funcCur;
    }

    public static int combine(int funcPre, int infoN){
        return Math.max(funcPre, funcPre + infoN);
    }
}
