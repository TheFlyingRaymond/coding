import java.util.Arrays;

public class LC1552{

    public static void main(String[] args) {
        int[] position = new int[]{1, 2, 3, 4, 7};
        int ret = new LC1552().maxDistance(position, 3);
        System.out.println(ret);
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int maxPos = 0;
        for(int item : position){
            maxPos = Math.max(maxPos,item);
        }
        int right = maxPos;
        int left = 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(position, m, mid)){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return right;
    }

    private boolean check(int[] position, int m, int distance) {
        int prePos = position[0];
        int curIndex = 1;
        for(int i = 1; i < m; i ++){
            if(curIndex >= position.length){
                return false;
            }
            while(position[curIndex] - prePos < distance){
                curIndex++;
                if(curIndex == position.length){
                    return false;
                }
            }
            prePos = position[curIndex];
            curIndex++;
        }

        return true;
    }
}