/**
 * Universal Value Tree Problem
 */
public class Problem8 {

    public static void main(String[] args) {
        Node root = new Node(0,
                new Node(1),
                new Node(0, new Node(1,
                                        new Node(1),
                                        new Node(1)),
                                new Node(0)));
        System.out.println(root.countUnivalSubtrees()); // O(n)
    }

    private static class Node {
        private final Integer value;
        private final Node left;
        private final Node right;

        Node(Integer val, Node l, Node r) {
            this.value = val;
            this.left = l;
            this.right = r;
        }

        Node(Integer val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }

        int countUnivalSubtrees() {
            Pair result = doCountUnivalSubtrees(this);
            return result.count;
        }

        Pair doCountUnivalSubtrees(Node node) {
            if (node == null) {
                return new Pair(true, 0);
            }
            Pair leftRes = doCountUnivalSubtrees(node.left);
            Pair rightRes = doCountUnivalSubtrees(node.right);

            boolean isUnival = true;
            if (!leftRes.isUnival || !rightRes.isUnival) {
                isUnival = false;
            }
            if (node.left != null && !node.left.value.equals(node.value)) {
                isUnival = false;
            }
            if (node.right != null && !node.right.value.equals(node.value)) {
                isUnival = false;
            }
            if (isUnival) {
                return new Pair(true, leftRes.count + rightRes.count + 1);
            } else {
                return new Pair(false, leftRes.count + rightRes.count);
            }
        }
    }

    private static final class Pair {
        private final boolean isUnival;
        private final int count;

        Pair(boolean isUnival, int count) {
            this.isUnival = isUnival;
            this.count = count;
        }
    }
}
