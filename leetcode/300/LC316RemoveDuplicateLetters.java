import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class LC316RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(new LC316RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
    }
    public String removeDuplicateLetters(String s) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        Set<Character> used = new HashSet<>();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(used.contains(ch)) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > ch && lastIdx[stack.peek() - 'a'] > i) {
                used.remove(stack.pop());
            }
            stack.push(ch);
            used.add(ch);
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
