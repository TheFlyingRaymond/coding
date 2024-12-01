public class LC490 {
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{3, 2};
        System.out.println(new LC490().hasPath(map, start, destination));
    }


    private int[][] moves = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    };

    boolean ret = false;
    boolean[][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        ret = false;
        visited = new boolean[maze.length][maze[0].length];

        for (int[] move : moves) {
            dfs(maze, start[0], start[1], destination[0], destination[1], move);
        }
        return ret;
    }

    private void dfs(int[][] maze, int x1, int y1, int x2, int y2, int[] preMove) {
        if (ret || visited[x1][y1]) {
            return;
        }
        visited[x1][y1] = true;
        if (x1 == x2 && y1 == y2) {
            ret = true;
            return;
        }

        for (int[] move : moves) {
            int nx = x1 + move[0], ny = y1 + move[1];
            if (!valid(maze, nx, ny)) {
                continue;
            }
            while (valid(maze, nx + move[0], ny + move[1])) {
                nx += move[0];
                ny += move[1];
            }
            dfs(maze, nx, ny, x2, y2, move);
        }
    }

    private boolean valid(int[][] map, int x, int y) {
        int xLimit = map.length, yLimit = map[0].length;
        if (x < 0 || x >= xLimit || y < 0 || y >= yLimit) {
            return false;
        }
        return map[x][y] == 0;
    }
}
