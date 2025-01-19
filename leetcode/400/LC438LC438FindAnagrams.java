import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438LC438FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ret = new LC438LC438FindAnagrams().findAnagrams(s, p);
        System.out.println(ret);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return ret;
        }
        Map<Character, Integer> mapp = new HashMap<>();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            char chp = p.charAt(i);
            mapp.put(chp, mapp.getOrDefault(chp, 0) + 1);
        }


        int left = 0, right = p.length() - 1;

        while (right < s.length()) {
            if (check(map, mapp)) {
                ret.add(left);
            }

            right += 1;
            if(right == s.length()) {
                break;
            }
            char cr = s.charAt(right);
            map.put(cr, map.getOrDefault(cr, 0) + 1);

            char cl = s.charAt(left);
            left += 1;
            int cntl = map.get(cl);
            cntl -= 1;
            if (cntl == 0) {
                map.remove(cl);
            } else {
                map.put(cl, cntl);
            }
        }

        return ret;
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> mapp) {
        if (map.size() != mapp.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : mapp.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (!map.containsKey(key) || map.get(key) != value) {
                return false;
            }
        }
        return true;
    }
}