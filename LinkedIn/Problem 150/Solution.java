import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 17.01.2019
 */
public class Solution {

    public static void main(String... args) {
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(5, 4), new Point(3, 1));
        getClosest(points, new Point(1, 2), 2).forEach(point -> System.out.println(point.x + ":" + point.y));
    }

    private static final class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> getClosest(List<Point> points, Point centralPoint, int k) {
        final Function<Point, Integer> getDistance = point -> (point.x - centralPoint.x) * (point.x - centralPoint.x)
                + (point.y - centralPoint.y) * (point.y - centralPoint.y);
        return points.stream()
                .sorted(Comparator.comparingInt(getDistance::apply))
                .limit(k)
                .collect(Collectors.toList());
    }

}
