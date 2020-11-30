import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String... args) {
    }

    public static class HitCounter {
        private final Map<Long, Integer> map = new HashMap<>();
        private int total;

        public void record(long timestamp) {
            map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
            total++;
        }

        public int total() {
            return total;
        }

        public int range(long lower, long upper) {
            int res = 0;

            for (Map.Entry<Long, Integer> entry : map.entrySet())
                if (lower <= entry.getKey() && entry.getKey() <= upper)
                    res += entry.getValue();

            return res;
        }
    }

}
