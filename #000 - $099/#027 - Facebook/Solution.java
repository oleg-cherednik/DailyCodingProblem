import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Oleg Cherednik
 * @since 01.02.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(isBalanced("([])[]({})"));   // true
        System.out.println(isBalanced("([)]"));   // false
        System.out.println(isBalanced("((()"));   // false
    }

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;

                char prv = stack.pop();

                if (prv == '(' && ch != ')')
                    return false;
                if (prv == '[' && ch != ']')
                    return false;
                if (prv == '{' && ch != '}')
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
