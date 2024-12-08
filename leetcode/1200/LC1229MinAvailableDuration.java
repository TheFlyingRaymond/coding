import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC1229MinAvailableDuration {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));

        int i1 = 0, i2 = 0;
        while(i1 < slots1.length && i1 < slots2.length) {
            while(i1 < slots1.length && slots1[i1][1] -  slots1[i1][0] < duration) {
                i1++;
            }

            while(i2< slots2.length && slots2[i2][1] -  slots2[i2][0] < duration) {
                i2++;
            }

            if (i1 >= slots1.length || i2 >= slots2.length) {
                return new ArrayList<>();
            }

            int start = Math.max(slots1[i1][0], slots2[i2][0]);
            int end =Math.min(slots1[i1][1], slots2[i2][1]);

            if(end-start >= duration) {
                return new ArrayList<>(Arrays.asList(start, start + duration));
            }

            if (slots1[i1][0] <= slots2[i2][0]) {
                i1++;
            } else {
                i2++;
            }
        }

        return new ArrayList<>();

    }
}
