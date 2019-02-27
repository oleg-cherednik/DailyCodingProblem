import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 27.02.2019
 */
public class Solution {

    public static void main(String... args) {
        Set<Integer> nums = getCoversIntervals(Arrays.asList(
                new Interval(0, 3),
                new Interval(2, 6),
                new Interval(3, 4),
                new Interval(6, 9)));
        System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));    // 3 9
    }

    public static Set<Integer> getCoversIntervals(List<Interval> intervals) {
        final Comparator<Interval> sortByStartAndLengthDesc = (one, two) ->
                one.start != two.start ? Integer.compare(one.start, two.start) : Integer.compare(two.start, one.start);

        Set<Interval> uniqueIntervals = new TreeSet<>(sortByStartAndLengthDesc);
        uniqueIntervals.addAll(intervals);

        int end = -1;
        Set<Integer> res = new TreeSet<>();

        for (Interval interval : intervals)
            if (end == -1 || interval.start > end)
                res.add(end = interval.end);

        return res;
    }

    public static final class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
