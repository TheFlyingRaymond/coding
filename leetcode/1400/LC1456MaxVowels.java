public class LC1456MaxVowels {
    public static void main(String[] args) {
        String s = "aeiou";
        int k = 2;
        System.out.println(new LC1456MaxVowels().maxVowels(s, k));
    }

    public int maxVowels(String s, int k) {
        //入参判断
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0, max = 0;
        //初始化滑窗
        int left = 0, right = Math.min(k - 1, s.length() - 1);
        for (int i = left; i <= right; i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
                max = Math.max(max, cnt);
            }
        }
        //滑窗
        while (right +1  < s.length()) {
            right+=1;
            if(isVowel(s.charAt(right))){
                cnt++;
            }
            if (isVowel(s.charAt(left))) {
                cnt--;
            }
            left++;
            max = Math.max(max, cnt);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
