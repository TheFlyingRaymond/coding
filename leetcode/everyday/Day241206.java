public class Day241206 {
    public static void main(String[] args) {

    }

    private int[][] directs = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int numRookCaptures(char[][] board) {
        int[] pos = findR(board);
        int ret = 0;
        for (int[] direct : directs) {
            ret += findDirect(pos, direct, board);
        }

        return ret;
    }

    private int findDirect(final int[] pos, int[] direct, char[][] board) {
        int[] nextPos = new int[]{pos[0] + direct[0], pos[1] + direct[1]};
        while (valid(nextPos, board)) {
            if(board[nextPos[0]][nextPos[1]] == 'p') {
                return 1;
            }
            if(board[nextPos[0]][nextPos[1]] == 'B') {
                return 0;
            }
            nextPos[0] += direct[0];
            nextPos[1] += direct[1];
        }
        return 0;
    }

    private boolean valid(int[] pos, char[][] board) {
        int x = pos[0], y = pos[1];
        int lmax = board.length;
        int ymax = board[0].length;
        return x >= 0 && x < lmax && y >= 0 && y < ymax;
    }

    private int[] findR(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
