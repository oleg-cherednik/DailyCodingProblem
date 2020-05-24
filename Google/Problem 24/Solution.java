/**
 * @author Oleg Cherednik
 * @since 24.05.2020
 */
public class Solution {

    public static void main(String... args) {
    }

    public static final class LockBinaryTree {

        private Node root;

        public boolean isLocked(Node node) {
            return node.locked;
        }

        public boolean lock(Node node) {
            return lock(node, true);
        }

        public boolean unlock(Node node) {
            return lock(node, false);
        }

        private static boolean lock(Node node, boolean locked) {
            if (node.isLockAvailable())
                return false;

            node.lock(locked);
            return true;
        }

        public static final class Node {

            private final int val;
            private final Node parent;

            private Node left;
            private Node right;

            private int lockedChildren;
            private boolean locked;

            private Node(int val, Node parent) {
                this.val = val;
                this.parent = parent;
            }

            public int getVal() {
                return val;
            }

            private boolean isLockAvailable() {
                if (lockedChildren > 0)
                    return false;

                Node node = parent;

                while (node != null) {
                    if (node.locked)
                        return false;
                    node = node.parent;
                }

                return true;
            }

            private void lock(boolean locked) {
                this.locked = locked;

                Node node = parent;

                while (node != null) {
                    node.lockedChildren += locked ? 1 : -1;
                    node = node.parent;
                }
            }
        }
    }

}
