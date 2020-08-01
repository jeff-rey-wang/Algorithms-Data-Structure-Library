package DataStructs;


/**
 * Class representing a Balanced search tree with key-value pairs
 *
 * @param <Type> Generic data type of an element
 */
public class BalancedST<Type> {

    private BinTreeNode<Type> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * Initializes empty balanced ST
     */
    public BalancedST() {
    }

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
        return true;
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
