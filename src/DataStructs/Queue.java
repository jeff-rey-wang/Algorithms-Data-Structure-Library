package DataStructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class representing a generic queue data structure
 *
 * @param <Type> Generic data type of an element
 */
public class Queue<Type> implements Iterable<Type> {

    private Node<Type> front;
    private Node<Type> last;
    private int n;

    /**
     * Initializes empty queue
     */
    public Queue() {
        front = null;
        last = null;
        n = 0;
    }

    /**
     * Determines if queue is empty
     *
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return n;
    }

    /**
     * Adds an item to the back of the queue
     *
     * @param item item being added to the queue
     */
    public void enqueue(Type item) {
        Node<Type> secLast = last;
        last = new Node<Type>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            front = last;
        } else {
            secLast.next = last;
        }
        n++;
    }

    /**
     * Remove the item at the front of the queue
     *
     * @return the item at the front of the queue
     */
    public Type dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        Type item = front.item;
        front = front.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     * Return the item at the front of the queue without removal
     *
     * @return the item at the front of the queue
     */
    public Type peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        return front.item;
    }

    /**
     * Returns an iterator to iterate through the items of the queue
     *
     * @return iterator to iterate through the items of the queue
     */
    public Iterator<Type> iterator() {
        return new QueueIterator(front);
    }

    /**
     * Iterator used to retrieve items of the queue
     */
    private class QueueIterator implements Iterator<Type> {
        private Node<Type> current;

        /**
         * Initializes iterator
         *
         * @param front front element of the queue
         */
        public QueueIterator(Node<Type> front) {
            current = front;
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
         * Return the next item of the queue, if it exists
         *
         * @return the next item  of the queue
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
