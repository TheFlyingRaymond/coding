package biweekly146;

import java.util.HashMap;
import java.util.Map;

public class W146P2 {
    private int MOD = 1000000007;
    private int[][] grid;
    Map<String, Integer> map = new HashMap<>();
    public int countPathsWithXorValue(int[][] grid, int k) {
        this.grid = grid;
        this.map = new HashMap<>();
        return dfs(0, 0,0, k);
    }

    private int dfs(int x, int y, int xor, int k) {
        xor ^= grid[x][y];
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return xor == k ? 1 : 0;
        }

        String key = x + "-" + y + "-"+xor;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int cnt = 0;

        if (x + 1 < grid.length) {
            cnt += dfs(x + 1, y, xor, k);
            cnt %= MOD;
        }

        if (y + 1 < grid[0].length) {
            cnt += dfs(x, y + 1, xor, k);
            cnt %= MOD;
        }

        map.put(key, cnt);
        return cnt;
    }
}
