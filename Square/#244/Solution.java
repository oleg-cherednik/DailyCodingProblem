import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Oleg Cherednik
 * @since 18.02.2020
 */
public class Solution {

    public static void main(String... args) {
        System.out.println(Arrays.toString(getPrimeNumbersLessThan(100)));
    }

    public static int[] getPrimeNumbersLessThan(int n) {
        PrimeNumberGenerator primeGenerator = new PrimeNumberGenerator();
        List<Integer> primes = new LinkedList<>();

        while (true) {
            int prime = primeGenerator.next();

            if (prime >= n)
                break;

            primes.add(prime);
        }

        return primes.stream().mapToInt(i -> i).toArray();
    }

    public static final class PrimeNumberGenerator {

        private final Set<Integer> primes = new HashSet<>();
        private int prime = 1;

        public int next() {
            int n = prime;

            do {
                n++;
            } while (isMarked(n));

            primes.add(n);
            prime = n;

            return prime;
        }

        private boolean isMarked(int n) {
            for (int prime : primes)
                if (n % prime == 0)
                    return true;
            return false;
        }
    }

}
