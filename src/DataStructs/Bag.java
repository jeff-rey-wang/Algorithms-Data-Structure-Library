package DataStructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Type> implements Iterable<Type> {

    private Node<Type> first;
    private int n;

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Type item) {
        Node<Type> prevFirst = first;
        first.item = item;
        first.next = prevFirst;
        n++;
    }

    public Iterator<Type> iterator() {
        return new BagIterator(first);
    }

    private class BagIterator implements Iterator<Type> {
        private Node<Type> current;

        public BagIterator(Node<Type> first) {
            current = first;
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
