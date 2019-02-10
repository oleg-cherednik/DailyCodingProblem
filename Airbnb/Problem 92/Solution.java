import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 10.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(String.join(" ", sort(create())));
    }

    private static Map<String, Set<String>> create() {
        Map<String, Set<String>> map = new HashMap<>();
        map.put("CSC300", new HashSet<>(Arrays.asList("CSC100", "CSC200")));
        map.put("CSC200", new HashSet<>(Collections.singletonList("CSC100")));
        map.put("CSC100", Collections.emptySet());
        return map;
    }

    public static List<String> sort(Map<String, Set<String>> map) {
        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (String courseId : map.keySet())
            dfs(courseId, map, visited, res);

        return res;
    }

    private static void dfs(String courseId, Map<String, Set<String>> map, Set<String> visited, List<String> res) {
        if (visited.contains(courseId))
            return;

        visited.add(courseId);

        for (String id : map.getOrDefault(courseId, Collections.emptySet()))
            dfs(id, map, visited, res);

        res.add(courseId);
    }

}
