import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String... args) {
    }

    public static class SparseArray {
        private final Map<Integer, Integer> map = new HashMap<>();
        private int size;

        public void init(int[] arr, int size) {
            map.clear();
            this.size = size;

            for (int i = 0; i < arr.length; i++)
                set(i, arr[i]);
        }

        public void set(int i, int val) {
            if (i < 0 || i >= size)
                throw new ArrayIndexOutOfBoundsException();

            if (val != 0)
                map.put(i, val);
        }

        public int get(int i) {
            if (i < 0 || i >= size)
                throw new ArrayIndexOutOfBoundsException();
            return map.getOrDefault(i, 0);
        }
    }
}
