package DataStructs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Type> {

    private Node<Type> top;
    private int n;

    public Stack() {
        top = null;
        n = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return n;
    }

    public void push(Type item) {
        Node<Type> prevTop = top;
        top.item = item;
        top.next = prevTop;
        n++;
    }

    public Type pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow");
        }
        Type item = top.item;
        top = top.next;
        n--;
        return item;
    }

    public Type peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack Underflow");
        }
        return top.item;
    }

    public Iterator<Type> iterator() {
        return new StackIterator(top);
    }

    private class StackIterator implements Iterator<Type> {
        private Node<Type> current;

        public StackIterator(Node<Type> item) {
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
