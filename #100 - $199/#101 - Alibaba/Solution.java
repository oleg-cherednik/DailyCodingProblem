/**
 * @author Oleg Cherednik
 * @since 18.01.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(getMinSum(4));
        System.out.println(getMinSum(50));
    }

    public static Pair getMinSum(int num) {
        for (int a = num / 2; a >= 2; a--)
            if (isPrime(a) && isPrime(num - a))
                return new Pair(a, num - a);

        return null;
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2, sqrt = (int)Math.sqrt(num); i <= sqrt; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    private static final class Pair {
        private final int a;
        private final int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "[" + a + ',' + b + ']';
        }
    }

}
