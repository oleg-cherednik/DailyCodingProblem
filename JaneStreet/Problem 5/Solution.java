import java.util.function.Function;

/**
 * @author Oleg Cherednik
 * @since 29.11.2018
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(car(cons(3, 4)));
        System.out.println(cdr(cons(3, 4)));
    }

    private static Function<Function<Pair, Integer>, Integer> cons(int a, int b) {
        return func -> func.apply(new Pair(a, b));
    }

    private static int car(Function<Function<Pair, Integer>, Integer> cons) {
        return cons.apply(pair -> pair.a);
    }

    private static int cdr(Function<Function<Pair, Integer>, Integer> cons) {
        return cons.apply(pair -> pair.b);
    }

    private static class Pair {

        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
