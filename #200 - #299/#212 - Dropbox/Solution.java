/**
 * @author Oleg Cherednik
 * @since 05.12.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getColumnName(1));       // A
        System.out.println(getColumnName(10));      // J
        System.out.println(getColumnName(100));     // CV
        System.out.println(getColumnName(500));     // SF
        System.out.println(getColumnName(1000));    // ALL
    }

    public static String getColumnName(int num) {
        StringBuilder buf = new StringBuilder();

        while (num > 0) {
            buf.append((char)('A' + num % 26 - 1));
            num /= 26;
        }

        return buf.reverse().toString();
    }

}
