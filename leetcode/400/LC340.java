import java.util.HashMap;
import java.util.Map;

public class LC340 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();

        int max = 0;
        int left = 0, right = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (left < right && map.keySet().size() > k) {
                char del = s.charAt(left);
                int cnt = map.get(del);
                if (cnt == 1) {
                    map.remove(del);
                } else {
                    map.put(del, cnt - 1);
                }
                left++;
            }
            max =  Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
