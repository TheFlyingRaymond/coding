import java.util.Arrays;

public class LC1052MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, max = 0;
        int left = 0, right = minutes;
        for (int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }

        for(int i = 0; i < right; i ++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
        }
        max = Math.max(max,sum);

        while(right < customers.length){
            if(grumpy[right] == 1){
                sum += customers[right];
            }
            right++;

            if(grumpy[left] == 1){
                sum -= customers[left];
            }
            left++;

            max = Math.max(max, sum);
        }

        return max;
    }
}
