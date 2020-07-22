package DataStructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class representing a generic bag data structure
 *
 * @param <Type> Generic data type of an element
 */
public class Bag<Type> implements Iterable<Type> {

    private Node<Type> first;
    private int n;

    /**
     * Initializes empty bag
     */
    public Bag() {
        first = null;
        n = 0;
    }

    /**
     * Determines if bag is empty
     *
     * @return true if bag is empty, false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of elements in the bag
     *
     * @return the number of elements in the bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds an item to the bag
     *
     * @param item item being added to the bag
     */
    public void add(Type item) {
        Node<Type> prevFirst = first;
        first.item = item;
        first.next = prevFirst;
        n++;
    }

    /**
     * Returns an iterator to iterate through the items of the bag
     *
     * @return iterator to iterate through the items of the bag
     */
    public Iterator<Type> iterator() {
        return new BagIterator(first);
    }

    /**
     * Iterator used to retrieve items of the bag
     */
    private class BagIterator implements Iterator<Type> {

        private Node<Type> current;

        /**
         * Initializes iterator
         *
         * @param first first element of the bag
         */
        public BagIterator(Node<Type> first) {
            current = first;
        }

        /**
         * Determine if the next element holds data
         *
         * @return true if the next element exists, false otherwise
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Return the next item of the bag, if it exists
         *
         * @return the next item of the bag
         */
        public Type next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Type item = current.item;
            current = current.next;
            return item;
        }
    }
}
