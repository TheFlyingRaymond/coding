import java.util.Arrays;

public class LC1482 {
    public static void main(String[] args) {
        int[] bloomDay = new int[]{7,7,7,7,12,7,7};
        int ret = new LC1482().minDays(bloomDay, 2, 3);
        System.out.println(ret);
    }


    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length){
            return -1;
        }

        int max = Arrays.stream(bloomDay).max().getAsInt();
        int left = 1, right = max;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(bloomDay,m,k,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }


        return left == 0|| left > max ? -1 : left;
    }

    private boolean check(int[] bloomDay, int m, int k, int days) {
        int cnt = 0;
        for(int i = 0; i < bloomDay.length; i++){
            boolean flag = true;
            for(int j = 0; j < k; j++){
                if(i+j >= bloomDay.length || bloomDay[i + j ] > days){
                    flag = false;
                    i+=j;
                    break;
                }
            }
            if(flag){
                cnt++;
                i+=k-1;
            }
            if(cnt == m){
                return true;
            }
        }
        return false;
    }
}