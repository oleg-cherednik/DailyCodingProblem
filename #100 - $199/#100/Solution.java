import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author Oleg Cherednik
 * @since 18.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findMinSteps(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(1, 2))));
    }

    public static int findMinSteps(List<Point> points) {
        final BiFunction<Point, Point, Integer> getDistance = (cur, dest) ->
                (cur.x - dest.x) * (cur.x - dest.x) + (cur.y - dest.y) * (cur.y - dest.y);

        int res = 0;
        Point curr = null;

        for (Point dest : points) {
            if (curr == null)
                curr = dest;
            else
                while (!curr.equals(dest)) {
                    List<Point> nextMoves = Arrays.asList(
                            new Point(curr.x + 1, curr.y),
                            new Point(curr.x - 1, curr.y),
                            new Point(curr.x, curr.y + 1),
                            new Point(curr.x, curr.y - 1),
                            new Point(curr.x - 1, curr.y - 1),
                            new Point(curr.x + 1, curr.y + 1),
                            new Point(curr.x - 1, curr.y + 1),
                            new Point(curr.x + 1, curr.y - 1));

                    Point next = null;
                    long dist = 0;

                    for (Point nextMove : nextMoves) {
                        long nextMoveDist = getDistance.apply(nextMove, dest);

                        if (next == null || nextMoveDist < dist) {
                            next = nextMove;
                            dist = nextMoveDist;
                        }
                    }

                    curr = next;
                    res++;
                }
        }

        return res;
    }

    public static final class Point {

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Point))
                return false;
            return x == ((Point)obj).x && y == ((Point)obj).y;
        }
    }

}
