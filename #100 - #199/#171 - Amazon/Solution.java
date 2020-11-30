import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 28.05.2019
 */
public class Solution {

    public static void main(String... args) {
        List<Entry> entries = Arrays.asList(new Entry(1526579928, 3, "enter"), new Entry(1526580382, 2, "exit"));
        List<Period> periods = findBusiestPeriods(entries);
        periods.forEach(period -> System.out.println("(" + period.start + ", " + period.end + ')'));
    }

    public static List<Period> findBusiestPeriods(List<Entry> entries) {
        entries.sort(SORT_BY_TIMESTAMP_ASC);
        Map<Long, Integer> timeCapacity = calcLinkedPeriods(entries);
        return findBusiestPeriods(timeCapacity);
    }

    private static final Comparator<Entry> SORT_BY_TIMESTAMP_ASC = Comparator.comparingLong(one -> one.timestamp);

    private static Map<Long, Integer> calcLinkedPeriods(List<Entry> sortedEntries) {
        Map<Long, Integer> timeCapacity = new LinkedHashMap<>();
        int capacity = 0;

        for (Entry entry : sortedEntries) {
            if ("enter".equals(entry.type))
                capacity += entry.count;
            else if ("exit".equals(entry.type))
                capacity -= entry.count;
            else
                throw new IllegalArgumentException("Unknown Entry.type: " + entry.type);

            timeCapacity.put(entry.timestamp, capacity);
        }

        return timeCapacity;
    }

    private static final long NULL = -1;

    private static List<Period> findBusiestPeriods(Map<Long, Integer> timeCapacity) {
        int max = 0;

        for (int capacity : timeCapacity.values())
            max = Math.max(max, capacity);

        List<Period> res = new ArrayList<>();
        long prvTimestamp = NULL;

        for (Map.Entry<Long, Integer> entry : timeCapacity.entrySet()) {
            long timestamp = entry.getKey();
            int capacity = entry.getValue();

            if (prvTimestamp != NULL)
                res.add(new Period(prvTimestamp, timestamp));

            prvTimestamp = capacity == max ? timestamp : NULL;
        }

        if (prvTimestamp != NULL)
            res.add(new Period(prvTimestamp, Long.MAX_VALUE));

        return res;
    }

    public static final class Entry {

        public final long timestamp;
        public final int count;
        public final String type;

        public Entry(long timestamp, int count, String type) {
            this.timestamp = timestamp;
            this.count = count;
            this.type = type;
        }
    }

    public static final class Period {

        public final long start;
        public final long end;

        public Period(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }


}
