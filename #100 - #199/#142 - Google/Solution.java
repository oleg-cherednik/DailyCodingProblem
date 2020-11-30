/**
 * @author Oleg Cherednik
 * @since 28.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isBalanced("(()*")); // true
        System.out.println(isBalanced("(*)"));  // true
        System.out.println(isBalanced(")*("));  // false
    }

    public static boolean isBalanced(String str) {
        int count = 0;
        int star = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*')
                star++;
            else if (str.charAt(i) == '(')
                count++;
            else if (str.charAt(i) == ')') {
                if (--count < 0) {
                    count++;

                    if (--star < 0)
                        return false;
                }
            }
        }

        return Math.abs(count) <= star;
    }

}
