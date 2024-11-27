public class LC278{

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            boolean bad = isBadVersion(mid);
            if(bad){
                right = mid - 1;
            }else{
                left =mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int version){
        //mock
        return true;
    }
}