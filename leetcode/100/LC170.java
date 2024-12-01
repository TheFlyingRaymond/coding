import java.util.HashMap;
import java.util.Map;

public class LC170 {

    class TwoSum {
        private Map<Integer,Integer> map;
        public TwoSum() {
            map = new HashMap<>();
        }
        
        public void add(int number) {
            map.put(number,map.getOrDefault(number,0) + 1);
        }
        
        public boolean find(int value) {
           for (Integer k : map.keySet()) {
             int targfet = value - k;
             if(targfet == k && map.getOrDefault(targfet,0)>1){
                return true;
             }
            
             if(targfet != k && map.getOrDefault(targfet, 0)>0){
                return true;
             }
            }
            return false;
        }
    }
}
