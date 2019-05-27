import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 28.04.2019
 */
public class Solution {

    public static void main(String... args) {
        String start = "dog";
        String end = "cat";
        Set<String> dic = new HashSet<>(Arrays.asList("dot", "dop", "dat", "cat"));
        List<String> moves = findMinSeq(start, end, dic);
        System.out.println(Arrays.toString(moves.toArray()));
    }

    public static List<String> findMinSeq(String start, String end, Set<String> dic) {
        if (start.equals(end))
            return Collections.singletonList(start);

        Set<String> nextMoves = getNextMoves(start, dic);
        List<String> tail = findMinTail(nextMoves, end, dic);

        if (tail.isEmpty())
            return Collections.emptyList();

        List<String> res = new ArrayList<>(tail.size() + 1);
        res.add(start);
        res.addAll(tail);

        return res;
    }

    private static Set<String> getNextMoves(String word, Set<String> dic) {
        Set<String> res = new HashSet<>();

        for (String candidate : dic) {
            int diff = 0;

            for (int i = 0; i < candidate.length(); i++)
                if (candidate.charAt(i) != word.charAt(i))
                    diff++;

            if (diff == 1)
                res.add(candidate);
        }

        return res;
    }

    private static List<String> findMinTail(Set<String> nextMoves, String end, Set<String> dic) {
        List<String> tail = Collections.emptyList();

        for (String nextMove : nextMoves) {
            Set<String> subDic = new HashSet<>(dic);
            subDic.remove(nextMove);

            List<String> cur = findMinSeq(nextMove, end, subDic);

            if (cur.isEmpty())
                continue;

            if (tail.isEmpty() || cur.size() < tail.size())
                tail = cur;
        }

        return tail;
    }

}
