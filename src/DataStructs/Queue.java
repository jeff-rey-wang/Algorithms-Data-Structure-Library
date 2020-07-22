package DataStructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Type> implements Iterable<Type> {

    private Node<Type> first;
    private Node<Type> last;
    private int n;

    /**
     * Initializes empty Queue
     */
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Type item) {
        Node<Type> secLast = last;
        last = new Node<Type>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            secLast.next = last;
        }
        n++;
    }

    public Type dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        Type item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Type peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        return first.item;
    }

    public Iterator<Type> iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<Type> {
        private Node<Type> current;

        public QueueIterator(Node<Type> item) {
            current = item;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Type next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Type item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
