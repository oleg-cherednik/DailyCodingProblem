/**
 * @author Oleg Cherednik
 * @since 22.12.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isNumber("10"));
        System.out.println(isNumber("-10"));
        System.out.println(isNumber("10.1"));
        System.out.println(isNumber("-10.1"));
        System.out.println(isNumber("1e5"));
        System.out.println();
        System.out.println(isNumber("a"));
        System.out.println(isNumber("x 1"));
        System.out.println(isNumber("a-2"));
        System.out.println(isNumber("-"));
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

}
