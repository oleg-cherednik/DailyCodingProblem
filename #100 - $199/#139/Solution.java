import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Oleg Cherednik
 * @since 14.02.2019
 */
public class Solution {

    public static void main(String... args) {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five");
        PeekableInterface<String> it = new PeekableInterface<>(words);

        int i = 0;

        while (it.hasNext()) {
            if (i++ % 2 == 0)
                System.out.format("next:%s -> peek:%s\n", it.next(), it.hasNext() ? it.peek() : null);
            else
                System.out.format("peek:%s -> next:%s\n", it.peek(), it.next());
        }
    }

    public static final class PeekableInterface<E> implements Iterator<E> {
        private final Iterator<E> it;
        private E next;
        private boolean nextExists;

        public PeekableInterface(Iterable<E> iterable) {
            it = iterable.iterator();
        }

        @Override
        public boolean hasNext() {
            return nextExists || it.hasNext();
        }

        @Override
        public E next() {
            if (nextExists) {
                E e = next;
                nextExists = false;
                next = null;
                return e;
            }

            return it.next();
        }

        public E peek() {
            if (!nextExists)
                next = it.next();

            nextExists = true;
            return next;
        }

    }

}
