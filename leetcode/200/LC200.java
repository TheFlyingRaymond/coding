public class LC200 {

    private int[][] moves = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, -1}
    };

    public int numIslands(char[][] grid) {
        int ret = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j, visited);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
       if (valid(grid,i,j,visited)) {
            visited[i][j] = true;
           for (int[] move : moves) {
               dfs(grid, i + move[0], j + move[1], visited);
           }
        }
    }

    private boolean valid(char[][] grid, int i, int j, boolean[][] visited) {
        int row = grid.length;
        int col = grid[0].length;
        if(i < 0 || i >=row || j < 0 || j >= col) {
            return false;
        }
        if(visited[i][j] || grid[i][j] == '0') {
            return false;
        }
        return true;
    }
}
