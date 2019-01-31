import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Oleg Cherednik
 * @since 31.01.2019
 */
public class Solution {

    public static void main(String... args) {
        boolean[][] board = {
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}};
        System.out.println(findMinimumPathLength(board, new Point(0, 3), new Point(0, 0)));
    }

    public static Integer findMinimumPathLength(boolean[][] board, Point from, Point to) {
        int[][] steps = new int[board.length][board[0].length];
        Arrays.stream(steps).forEach(row -> Arrays.fill(row, -1));

        Deque<Point> queue = new LinkedList<>();
        queue.add(from);
        steps[from.y][from.x] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.remove();

            if (point.isEqual(to))
                continue;

            for (Point nextPoint : Arrays.asList(new Point(point.x + 1, point.y), new Point(point.x, point.y - 1),
                                                 new Point(point.x - 1, point.y), new Point(point.x, point.y + 1))) {
                if (!isStepAvailable(board, nextPoint))
                    continue;
                if (steps[nextPoint.y][nextPoint.x] >= 0 && steps[point.y][point.x] + 1 >= steps[nextPoint.y][nextPoint.x])
                    continue;

                steps[nextPoint.y][nextPoint.x] = steps[point.y][point.x] + 1;
                queue.add(nextPoint);
            }
        }

        return steps[to.y][to.x] == Integer.MAX_VALUE ? null : steps[to.y][to.x];
    }

    private static boolean isStepAvailable(boolean[][] board, Point point) {
        return point.y >= 0 && point.y < board.length && point.x >= 0 && point.x < board[point.y].length && !board[point.y][point.x];
    }

    private static final class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isEqual(Point point) {
            return x == point.x && y == point.y;
        }

        @Override
        public String toString() {
            return "[" + x + ';' + y + ']';
        }
    }

}
