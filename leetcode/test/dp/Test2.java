package dp;

public class Test2 {
    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {6, 10, 12};
        int capacity = 5;
        System.out.println(maxProfit(weight, value, capacity));
    }

    public static int maxProfit(int[] weight, int[] value, int capacity) {
        int[] funcPre = new int[capacity + 1], funcCur = new int[capacity + 1];
        int n = weight.length;
        for (int i = 1; i <= n; i++) {
            funcCur = combine(funcPre, i, weight, value);
            funcPre = funcCur;
        }
        return funcCur[capacity];
    }

    private static int[] combine(int[] funcPre, int idx, int[] weight, int[] value) {
        int[] funcCur = new int[funcPre.length];
        int w = weight[idx - 1], v = value[idx - 1];

        for (int i = 1; i < funcPre.length; i++) {
            if (i - w >= 0) {
                funcCur[i] = Math.max(funcPre[i], funcPre[i - w] + v);
            } else {
                funcCur[i] = funcPre[i];
            }
        }
        return funcCur;
    }
}
