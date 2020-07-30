package DataStructs;

/**
 * Class representing generic node
 *
 * @param <Type> Generic data type of an element
 */
public class Node<Type> {

    public Type item; // element of type 'Type'
    public Node<Type> next; // Node that current node points to
}
