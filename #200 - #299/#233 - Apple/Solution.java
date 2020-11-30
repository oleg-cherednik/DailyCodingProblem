/**
 * @author Oleg Cherednik
 * @since 18.02.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(fib(0));    // 0
        System.out.println(fib(1));    // 1
        System.out.println(fib(2));    // 1
        System.out.println(fib(3));    // 2
        System.out.println(fib(4));    // 3
        System.out.println(fib(5));    // 5
        System.out.println(fib(6));    // 8
        System.out.println(fib(22));    // 17711
    }

    public static long fib(int n) {
        long x1 = 1;
        long x2 = 0;

        for(int i = 0; i < n; i++) {
            x2 = x1 + x2;
            x1 = x2 - x1;
        }

        return x2;
    }

}
