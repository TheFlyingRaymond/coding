import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC218GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();

        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->{
            if (a.pos == b.pos) {
                return a.in ? 1 : -1;
            }
            return a.pos - b.pos;
        });

        PriorityQueue<Building> pqBuilding = new PriorityQueue<>(Comparator.comparing(a -> -a.height));

        for (int[] item : buildings) {
            Building building = new Building(item[2]);
            pq.add(new Point(item[0], item[2], true,building));
            pq.add(new Point(item[1], item[2], false,building));
        }

        while(!pq.isEmpty()) {
            int preHeight = pqBuilding.isEmpty() ? 0 : pqBuilding.peek().height;

            Point point = pq.peek();

            while (!pq.isEmpty() && pq.peek().pos == point.pos) {
                point = pq.poll();
                if (point.in) {
                    pqBuilding.add(point.building);
                }else {
                    pqBuilding.remove(point.building);
                }
            }

            int nowHeight =  pqBuilding.isEmpty() ? 0 : pqBuilding.peek().height;

            if (preHeight != nowHeight) {
                List<Integer> list = new ArrayList<>();
                list.add(point.pos);
                list.add(nowHeight);
                ret.add(list);
            }
        }

        return ret;
    }

    class Building{
        public int height;
        public Building(int height){
            this.height = height;
        }
    }

    class Point{
        public int pos, height;
        public boolean in;
        public Building building;

        public Point(int x, int y, boolean in, Building building) {
            this.pos = x;
            this.height = y;
            this.in = in;
            this.building = building;
        }
    }



}
