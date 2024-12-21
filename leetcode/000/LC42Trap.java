import java.util.Stack;

public class LC42Trap {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            int curHeight = height[i];
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int midHeight = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }

                int leftIdx = stack.peek();
                int leftHeight = height[leftIdx];
                ret += (Math.min(curHeight, leftHeight)-midHeight) * (i - leftIdx - 1);
            }
            stack.push(i);
        }

        return ret;
    }
}
