package biweekly146;

import java.util.HashMap;
import java.util.Map;

public class W146P1 {
    public static void main(String[] args) {
        W146P1 w146P1 = new W146P1();
        System.out.println(w146P1.countSubarrays(new int[]{1,2,1,4,1}));
        System.out.println(w146P1.countSubarrays(new int[]{1,1,1}));
        System.out.println(w146P1.countSubarrays(new int[]{1,3,1}));
        System.out.println(w146P1.countSubarrays(new int[]{1,4,1,3,14,4}));
    }
    public int countSubarrays(int[] nums) {
        int cnt = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int left = nums[i - 1];
            int mid = nums[i];
            int right = nums[i + 1];
            if (mid % 2 != 0) {
                continue;
            }
            if(mid / 2 == left + right) {
                cnt++;
            }
        }

        return cnt;
    }
}
