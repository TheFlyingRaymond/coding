public class LC1140StoreGameII {
    public static void main(String[] args) {
        LC1140StoreGameII game = new LC1140StoreGameII();
        int[] piles = {2,7,9,4,4};
        System.out.println(game.stoneGameII(piles)); // Output should be 104
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][2 * n];

        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }

        int win = dfs(0, 1, piles, memo);

        return (sum + win) / 2;
    }

    private int dfs(int start, int m, int[] piles, int[][] memo) {
        if (start >= piles.length) {
            return 0;
        }
        if (memo[start][m] != 0) {
            return memo[start][m];
        }

        int sum = piles[start];
        int win = sum - dfs(start + 1, Math.max(1, m), piles, memo);
        for (int i = 2; i <= 2 * m && start + i - 1 < piles.length; i++) {
            sum += piles[start + i - 1];
            win = Math.max(win, sum - dfs(start + i, Math.max(i, m), piles, memo));
        }
        memo[start][m] = win;
        return win;
    }
}
