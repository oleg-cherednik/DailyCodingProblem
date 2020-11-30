import java.util.Map;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 30.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getRequiredRoomsAmount(new Interval[]{
                new Interval(30, 75),
                new Interval(0, 50),
                new Interval(60, 150)}));
    }

    private static final class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int getRequiredRoomsAmount(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }

        int res = 0;
        int count = 0;

        for (int delta : map.values())
            res = Math.max(res, count += delta);

        return res;
    }

}
