import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

/**
 * @author Oleg Cherednik
 * @since 17.01.2019
 */
public class Solution {

    public static void main(String... args) {
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(5, 4), new Point(3, 1));
        getClosest(points, new Point(1, 2), 2).forEach(point -> System.out.println(point.x + ":" + point.y));
    }

    public static List<Point> getClosest(List<Point> points, Point centralPoint, int k) {
        final Function<Point, Integer> getDistance = point -> (point.x - centralPoint.x) * (point.x - centralPoint.x)
                + (point.y - centralPoint.y) * (point.y - centralPoint.y);
        final Comparator<Point> sortByDistanceDesc = (one, two) -> Integer.compare(getDistance.apply(two), getDistance.apply(one));

        Queue<Point> queue = new PriorityQueue<>(sortByDistanceDesc);

        points.forEach(point -> {
            if (queue.size() < k)
                queue.add(point);
            else if (sortByDistanceDesc.compare(queue.element(), point) < 0) {
                queue.remove();
                queue.add(point);
            }
        });

        return new ArrayList<>(queue);
    }

    private static final class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
