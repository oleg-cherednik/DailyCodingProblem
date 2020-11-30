import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 08.03.2020
 */
public class Solution {

    public static void main(String... args) {
        PrefixMapSum mapsum = new PrefixMapSum();

        mapsum.insert("columnar", 3);
        System.out.println(mapsum.sum("col"));  // 3

        mapsum.insert("column", 2);
        System.out.println(mapsum.sum("col"));  // 5
    }

    private static final class PrefixMapSum {

        private final Map<String, Integer> map = new HashMap<>();

        public void insert(String key, int value) {
            map.put(key, value);
        }

        public int sum(String prefix) {
            int sum = 0;

            for (Map.Entry<String, Integer> entry : map.entrySet())
                if (entry.getKey().startsWith(prefix))
                    sum += entry.getValue();

            return sum;
        }
    }

}
