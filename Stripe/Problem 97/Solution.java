import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Oleg Cherednik
 * @since 11.02.2019
 */
public class Solution {

    public static void main(String... args) {
        TimeMap<Integer, Integer> d = new TimeMap<>();
        d.set(1, 1, 0);
        d.set(1, 2, 2);
        System.out.println(d.get(1, 1));    // 1
        System.out.println(d.get(1, 3));    // 2

        d.set(1, 1, 5);
        System.out.println(d.get(1, 0));    // 1
        System.out.println(d.get(1, 10));   // 1

        d.set(1, 1, 0);
        d.set(1, 2, 0);
        System.out.println(d.get(1, 0));    // 1
    }

    public static final class TimeMap<K, V> {
        private final Map<K, Set<TimeEntry<V>>> map = new HashMap<>();

        public void set(K key, V value, int time) {
            if (!map.containsKey(key))
                map.put(key, new TreeSet<>());
            map.get(key).add(new TimeEntry<>(time, value));
        }

        public V get(K key, int time) {
            Set<TimeEntry<V>> entries = map.getOrDefault(key, Collections.emptySet());

            if (entries.isEmpty())
                return null;

            V value = null;

            for (TimeEntry<V> entry : entries) {
                if (entry.time > time)
                    break;

                value = entry.value;
            }

            return value;
        }

        private static final class TimeEntry<V> implements Comparable<TimeEntry<V>> {
            private final int time;
            private final V value;

            public TimeEntry(int time, V value) {
                this.time = time;
                this.value = value;
            }

            @Override
            public int compareTo(TimeEntry<V> entry) {
                return Integer.compare(time, entry.time);
            }
        }
    }

}
