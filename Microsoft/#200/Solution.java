import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 04.06.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(findSmallestStubPoints(createIntervals(1, 4, 4, 5, 7, 9, 9, 12)).toArray(new Integer[0])));   // { 4, 9 }
        System.out.println(Arrays.toString(findSmallestStubPoints(createIntervals(1, 4, 4, 4, 3, 9)).toArray(new Integer[0])));   // { 4 }
    }

    private static List<Interval> createIntervals(int... points) {
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < points.length; i += 2)
            intervals.add(new Interval(points[i], points[i + 1]));

        return intervals;
    }

    public static List<Integer> findSmallestStubPoints(List<Interval> intervals) {
        intervals.sort(Interval.SORT_BY_X2_ASC);

        int prv = Integer.MIN_VALUE;
        List<Integer> points = new ArrayList<>();

        for (Interval interval : intervals) {
            if (prv != Integer.MIN_VALUE && interval.start <= prv)
                continue;

            points.add(interval.end);
            prv = interval.end;
        }

        return points;
    }

    public static final class Interval {

        public static final Comparator<Interval> SORT_BY_X2_ASC = (one, two) -> {
            if (one.end != two.end)
                return Integer.compare(one.end, two.end);
            return Integer.compare(one.start, two.start);
        };

        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "->" + end;
        }
    }

}
