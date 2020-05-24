import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 01.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMinRemoveInterval(createIntervals(0, 1, 1, 2)));    // 0
        System.out.println(findMinRemoveInterval(createIntervals(7, 9, 2, 4, 5, 8)));    // 1
    }

    private static List<Interval> createIntervals(int... arr) {
        int total = arr.length / 2;
        List<Interval> intervals = new ArrayList<>(total);

        for (int i = 0; i < total; i++)
            intervals.add(new Interval(arr[2 * i], arr[2 * i + 1]));

        return intervals;
    }

    public static int findMinRemoveInterval(List<Interval> intervals) {
        Collection<Integer> deltas = getDeltas(intervals);

        int res = 0;
        int cur = 0;
        int max = 0;

        for (int delta : deltas) {
            max = Math.max(max, cur += delta);

            if (cur == 0) {
                res += max - 1;
                max = 0;
            }
        }

        return res;
    }

    private static Collection<Integer> getDeltas(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();

        intervals.forEach(interval -> {
            map.put(interval.x, map.getOrDefault(interval.x, 0) + 1);
            map.put(interval.y, map.getOrDefault(interval.y, 0) - 1);
        });

        return map.values();
    }

    public static final class Interval {

        public final int x;
        public final int y;

        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
