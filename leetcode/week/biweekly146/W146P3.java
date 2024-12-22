package biweekly146;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class W146P3 {
    public static void main(String[] args) {
        System.out.println(checkValidCuts(5, new int[][]{
                //[1,0,5,2],[0,2,2,4],],[0,4,4,5]©leetcode
                //[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]©leetcode
                {0, 0, 1, 1},
                {2, 0, 3, 4},
                {0, 2, 2, 3},
                {3, 0, 4, 3}}));

        System.out.println(checkValidCuts(5, new int[][]{
                {0, 2, 2, 4},
                {1, 0, 3, 2},
                {2, 2, 3, 4},
                {3, 0, 4, 2},
                {3, 2, 4, 4}}));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, x -> new int[]{x[0], x[2]})
                || check(rectangles, x -> new int[]{x[1], x[3]});
    }

    private static boolean check(int[][] rectangles, Function<int[], int[]> f) {
        List<int[]> list = new ArrayList<>();
        for (int[] item : rectangles) {
            int[] tmp = f.apply(item);
            list.add(tmp);
        }
        list.sort(Comparator.comparingInt(a -> a[0]));

        Stack<int[]> pq = new Stack<>();
        for (int[] item : list) {
            if (pq.isEmpty() || pq.peek()[1] <= item[0]) {
                pq.push(new int[]{item[0], item[1]});
            } else {
                pq.peek()[1] = Math.max(pq.peek()[1], item[1]);
            }
            if (pq.size() > 2) {
                return true;
            }
        }

        return pq.size() >= 3;
    }


}
