package DataStructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class representing a generic stack data structure
 *
 * @param <Type> Generic data type of an element
 */
public class Stack<Type> implements Iterable<Type> {

    private Node<Type> top;
    private int n;

    /**
     * Initializes empty stack
     */
    public Stack() {
        top = null;
        n = 0;
    }

    /**
     * Determines if stack is empty
     *
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return n;
    }

    /**
     * Adds an item to top of the stack
     *
     * @param item item being added to the stack
     */
    public void push(Type item) {
        Node<Type> prevTop = top;
        top.item = item;
        top.next = prevTop;
        n++;
    }

    /**
     * Remove the item at the top of the stack
     *
     * @return the item at the top of the stack
     */
    public Type pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow");
        }
        Type item = top.item;
        top = top.next;
        n--;
        return item;
    }

    /**
     * Return the item at the top of the stack without removal
     *
     * @return the item at the top of the stack
     */
    public Type peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow");
        }
        return top.item;
    }

    /**
     * Returns an iterator to iterate through the items of the stack
     *
     * @return iterator to iterate through the items of the stack
     */
    public Iterator<Type> iterator() {
        return new StackIterator(top);
    }

    /**
     * Iterator used to retrieve items of the stack
     */
    private class StackIterator implements Iterator<Type> {

        private Node<Type> current;

        /**
         * Initializes iterator
         *
         * @param top top element of the stack
         */
        public StackIterator(Node<Type> top) {
            current = top;
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
         * Return the next item of the stack, if it exists
         *
         * @return the next item  of the stack
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
