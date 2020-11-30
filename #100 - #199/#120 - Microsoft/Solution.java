/**
 * @author Oleg Cherednik
 * @since 12.02.2019
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(TwistSingleton.getInstance().id);    // 1
        System.out.println(TwistSingleton.getInstance().id);    // 2
        System.out.println(TwistSingleton.getInstance().id);    // 1
        System.out.println(TwistSingleton.getInstance().id);    // 2
    }

    public static final class TwistSingleton {
        private static final TwistSingleton ODD = new TwistSingleton(1);
        private static final TwistSingleton EVEN = new TwistSingleton(2);
        private static boolean odd = true;

        public static TwistSingleton getInstance() {
            if (odd) {
                odd = false;
                return ODD;
            }

            odd = true;
            return EVEN;
        }

        private final int id;

        private TwistSingleton(int id) {
            this.id = id;
        }

    }

}
