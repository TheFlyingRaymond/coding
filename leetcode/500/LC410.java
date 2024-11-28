public class LC410{
    public int splitArray(int[] nums, int k) {
        int sum = 0, max = 0;
        for(int item : nums){
            sum += item;
            max = Math.max(max,item);
        }

        int left = max, right = sum;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(mid,k, nums)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 校验是否可以把nums分成k组，每组和不超过sum
     */
    private boolean check(int sum, int k, int[] nums){
        int tempSum = 0, count = 1;
        for(int item : nums){
            tempSum += item;
            //需要新开一组
            if(tempSum > sum){
                tempSum = item;
                count++;
            }
            if(count > k){
                return false;
            }
        }
        return true;
    }
}