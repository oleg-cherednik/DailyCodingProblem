import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Oleg Cherednik
 * @since 07.02.2019
 */
public class Solution {

    public static void main(String... args) {
        List<Interval> res = mergeIntervals(new Interval[]{new Interval(1, 3), new Interval(5, 8), new Interval(4, 10), new Interval(20, 25)});
        res.forEach(interval -> System.out.format("[%d:%d]\n", interval.from, interval.to));
    }

    public static List<Interval> mergeIntervals(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (Interval interval : intervals) {
            map.put(interval.from, map.getOrDefault(interval.from, 0) + 1);
            map.put(interval.to, map.getOrDefault(interval.to, 0) - 1);
        }

        List<Interval> res = new ArrayList<>();
        int from = -1;
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();

            if (entry.getValue() > 0)
                from = from == -1 ? entry.getKey() : from;
            else if (count == 0) {
                res.add(new Interval(from, entry.getKey()));
                from = -1;
            }
        }

        return res;
    }

    private static final class Interval {
        private final int from;
        private final int to;

        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

}
