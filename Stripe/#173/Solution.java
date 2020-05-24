import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Oleg Cherednik
 * @since 28.05.2019
 */
public class Solution {

    public static void main(String... args) {
        Map<String, Object> foo = new LinkedHashMap<>();
        foo.put("a", 5);
        foo.put("bar", Collections.singletonMap("baz", 8));

        Map<String, Object> dic = new LinkedHashMap<>();
        dic.put("key", 3);
        dic.put("foo", foo);

        Map<String, String> map = flatten(dic);
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static Map<String, String> flatten(Map<String, Object> dic) {
        return flatten(null, dic, new LinkedHashMap<>());
    }

    private static Map<String, String> flatten(String prefix, Map<String, Object> dic, Map<String, String> map) {
        for (Map.Entry<String, Object> entry : dic.entrySet()) {
            String key = prefix == null ? entry.getKey() : prefix + '.' + entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Map)
                flatten(key, (Map<String, Object>)value, map);
            else
                map.put(key, String.valueOf(value));
        }

        return map;
    }

}
