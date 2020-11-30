import java.util.*;

/**
 * @author Oleg Cherednik
 * @since 29.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));  // 20
        System.out.println(getLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));    // 32
    }

    public static int getLongestPath(String str) {
        Set<String> files = new HashSet<>();
        addAllFiles(new LinkedList<>(), str.split("\n"), 0, files);
        return files.stream()
                .mapToInt(String::length)
                .max().orElse(0);
    }

    private static void addAllFiles(Deque<String> parent, String[] parts, int i, Set<String> files) {
        if (i >= parts.length)
            return;

        String part = parts[i];
        String trimPart = part.trim();
        int depth = part.length() - trimPart.length();

        if (parent.size() < depth) {
            if (parent.size() + 1 < depth)
                throw new IllegalArgumentException();
        } else
            while (parent.size() > depth)
                parent.removeLast();

        if (isFile(trimPart))
            files.add(buildFilePath(parent, trimPart));
        else
            parent.add(trimPart);

        addAllFiles(parent, parts, i + 1, files);
    }

    private static boolean isFile(String str) {
        return str.contains(".");
    }

    private static String buildFilePath(Queue<String> parent, String fileName) {
        StringBuilder buf = new StringBuilder();

        for (String path : parent) {
            if (buf.length() > 0)
                buf.append('/');
            buf.append(path);
        }

        if (buf.length() > 0)
            buf.append('/');

        buf.append(fileName);
        return buf.toString();
    }

}
