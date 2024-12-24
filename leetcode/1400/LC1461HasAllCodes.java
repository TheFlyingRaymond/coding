import java.util.HashSet;
import java.util.Set;

public class LC1461HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k){
            return false;
        }

        int left = 0, right = k;
        Set<String> set = new HashSet<>();
        set.add(s.substring(left, right));

        while(right < s.length()){
            right++;
            left++;
            set.add(s.substring(left, right));
        }

        return set.size() == Math.pow(2, k);
    }
}
