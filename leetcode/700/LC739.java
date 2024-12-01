import java.util.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int cur = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] <= cur) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ret[i] = 0;
            } else {
                ret[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return ret;
    }
}
