import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Cherednik
 * @since 07.02.2019
 */
public class Solution {

    public static void main(String... args) {
        List<List<Integer>> sortedLists = Arrays.asList(
                Arrays.asList(0, 1, 4, 5, 6, 8, 8),
                Arrays.asList(0, 1, 3, 3, 3, 3, 5, 6, 7),
                Arrays.asList(0, 0, 1, 3, 4, 5, 6, 6, 6, 7, 8, 8, 8)
        );

        System.out.println(merge(sortedLists).stream()
                                   .map(val -> Integer.toString(val))
                                   .collect(Collectors.joining(" ")));
    }

    public static List<Integer> merge(List<List<Integer>> sortedLists) {
        List<Integer> res = new LinkedList<>();
        Iterator<Integer>[] its = sortedLists.stream().map(List::iterator).toArray(Iterator[]::new);
        Integer[] values = new Integer[sortedLists.size()];

        while (true) {
            int minIndex = -1;

            for (int i = 0; i < values.length; i++) {
                values[i] = values[i] == null && its[i].hasNext() ? its[i].next() : values[i];

                if (values[i] != null)
                    minIndex = minIndex == -1 || values[minIndex] != null && values[minIndex] > values[i] ? i : minIndex;
            }

            if (minIndex == -1)
                break;

            res.add(values[minIndex]);
            values[minIndex] = null;
        }

        return res;
    }

}
