/**
 * @author Oleg Cherednik
 * @since 03.04.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(findBalancedString("(()"));  // (());
        System.out.println(findBalancedString("))()("));  // ()();
    }

    public static String findBalancedString(String str) {
        StringBuilder buf = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                count++;
                buf.append('(');
            } else if (ch == ')') {
                if (count > 0) {
                    buf.append(')');
                    count--;
                }
            }
        }

        for (int i = 0; i < count; i++)
            buf.append(')');

        return buf.toString();
    }

}
