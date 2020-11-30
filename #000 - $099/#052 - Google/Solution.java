import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 03.02.2019
 */
public class Solution {

    public static void main(String... args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.set("one", "one1");
        cache.set("two", "two1");
        cache.set("three", "three1");
        cache.set("four", "four1");
        System.out.println(cache.get("two"));   // two1
        System.out.println(cache.get("one"));   // null

        cache.set("five", "five1");
        System.out.println(cache.get("two"));   // two1
        System.out.println(cache.get("three"));   // null

        cache.set("four", "four2");
        System.out.println(cache.get("four"));   // four2
    }

    public static final class LRUCache<K, V> {
        private final Map<K, V> map = new LinkedHashMap<>();
        private final int maxSize;

        public LRUCache(int maxSize) {
            this.maxSize = maxSize;
        }

        public void set(K key, V value) {
            if (map.containsKey(key))
                map.remove(key);
            else if (map.size() == maxSize)
                map.remove(map.keySet().iterator().next());

            map.put(key, value);
        }

        public V get(K key) {
            if (!map.containsKey(key))
                return null;

            V value = map.remove(key);
            map.put(key, value);
            return value;
        }
    }

}
