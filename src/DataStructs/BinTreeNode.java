package DataStructs;

/**
 * Class representing generic node of binary tree,
 * Where left subtree contains nodes of lesser key values & right subtree contains nodes with greater key values
 *
 * @param <Type> Generic data type of an element
 */
public class BinTreeNode<Type> {

    public boolean colour;
    public int key; // key of node
    public Type value; // element of type 'Type'
    public BinTreeNode<Type> left, right; // Left & right child of node
}
