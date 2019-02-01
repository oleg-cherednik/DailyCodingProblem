/**
 * @author Oleg Cherednik
 * @since 01.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(encode("AAAABBBCCDAA")); // 4A3B2C1D2A
        System.out.println(decode("4A3B2C1D2A")); // AAAABBBCCDAA
    }

    public static String encode(String str) {
        StringBuilder buf = new StringBuilder(str.length());
        char ch = '\0';
        int length = 0;


        for (int i = 0; i < str.length(); i++) {
            if (ch == '\0' || ch == str.charAt(i)) {
                ch = str.charAt(i);
                length++;
            } else {
                buf.append(length).append(ch);
                ch = str.charAt(i);
                length = 1;
            }
        }

        if (ch != '\0')
            buf.append(length).append(ch);

        return buf.toString();
    }

    public static String decode(String str) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < str.length(); ) {
            int length = str.charAt(i++) - '0';
            char ch = str.charAt(i++);

            for (int j = 0; j < length; j++)
                buf.append(ch);
        }

        return buf.toString();
    }

}
