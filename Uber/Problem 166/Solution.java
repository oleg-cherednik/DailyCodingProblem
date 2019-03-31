/**
 * @author Oleg Cherednik
 * @since 01.04.2019
 */
public class Solution {

    public static void main(String... args) {
        int[][] data = {
                { 1, 2 },
                { 3 },
                {},
                { 4, 5, 6 } };

        Iterator2D it = new Iterator2D(data);

        for (int i = 0; i < 7; i++)
            System.out.println(it.next());
    }

    public static final class Iterator2D {
        private final int[][] data;
        private int row = 0;
        private int col = -1;
        private boolean used = true;

        public Iterator2D(int[][] data) {
            this.data = data;
        }

        public int next() {
            if (!findNextElement())
                throw new RuntimeException("No more elements");

            used = true;
            return data[row][col];
        }

        public boolean has_next() {
            return findNextElement();
        }

        private boolean findNextElement() {
            if (row >= data.length)
                return false;
            if (!used)
                return true;

            used = false;

            while (row < data.length) {
                col++;

                if (col < data[row].length)
                    return true;

                col = -1;
                row++;
            }

            return false;
        }
    }

}
