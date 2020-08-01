package DataStructs;


/**
 * Class representing a Balanced search tree with key-value pairs, where keys are integes
 *
 * @param <Type> Generic data type of a value
 */
public class BalancedST<Integer, Type> {

    private BinTreeNode<Type> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * Initializes empty balanced ST
     */
    public BalancedST() {
    }

    // HELPER FUNCTIONS

    private boolean isRed(BinTreeNode<Type> node) {
        if (node == null) {
            return false;
        }
        return node.colour == RED;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int key) {
        return search(key) != null;
    }

    private BinTreeNode<Type> rotateR(BinTreeNode<Type> x) {
        BinTreeNode<Type> y = x.left;
        x.left = y.right;
        y.right = x;
        y.colour = y.right.colour;
        y.right.colour = RED;
        return y;
    }

    private BinTreeNode<Type> rotateL(BinTreeNode<Type> x) {
        BinTreeNode<Type> y = x.right;
        x.right = y.left;
        y.left = x;
        y.colour = y.left.colour;
        y.left.colour = RED;
        return y;
    }

    private void flipColours(BinTreeNode<Type> x) {
        x.colour = !x.colour;
        x.left.colour = !x.left.colour;
        x.right.colour = !x.right.colour;
    }

    public Type search(int key) {
        return null;
    }

    public Type search(BinTreeNode<Type> root, int key) {
        return null;
    }

    public void insert(int key, Type value) {
    }

    public void insert(BinTreeNode<Type> root, int key, Type value) {

    }
}
