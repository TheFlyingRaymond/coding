import java.util.Arrays;

public class LC1049lastStoneWeightII {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(new LC1049lastStoneWeightII().lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int max = Arrays.stream(stones).max().getAsInt();
        return process(stones, max);
    }

    private int process(int[] stones, int max) {
        boolean[] pre = new boolean[max + 1];
        boolean[] cur = new boolean[max + 1];
        pre[0] = true;

        for (int stone : stones) {
            pre = cur = combine(stone, pre);
            System.out.println(Arrays.toString(cur));
        }

        for (int i = 1; i < cur.length; i++) {
            if (cur[i]) {
                return i;
            }
        }
        return 0;
    }

    private boolean[] combine(int stone, boolean[] pre) {
        boolean[] cur = new boolean[pre.length];
        for (int i = 0; i < cur.length; i++) {
            if (pre[i]) {
                cur[Math.abs(i - stone)] = true;
            }
        }
        return cur;
    }
}
