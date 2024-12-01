import java.util.Arrays;

public class LC1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 1, right = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(nums,threshold,mid)){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int threshold, int div) {
        int sum = 0;
        for(int item : nums){
            sum += (item + div-1)/div;
            if(sum > threshold){
                return false;
            }
        }

        return true;
    }
}
