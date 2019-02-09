/**
 * @author Oleg Cherednik
 * @since 09.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(minParenthesesToRemove("(()())((()))")); // 0
        System.out.println(minParenthesesToRemove("()())()")); // 1
        System.out.println(minParenthesesToRemove(")(")); // 2
    }

    public static int minParenthesesToRemove(String str) {
        int count = 0;
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count++;
            else if (str.charAt(i) == ')')
                count--;
            else
                continue;

            if (count >= 0)
                continue;

            res++;
            count = 0;
        }

        return res + Math.abs(count);
    }

}
