package DataStructs;

import java.util.NoSuchElementException;

public class Queue<Type> {

    private Node<Type> first;
    private Node<Type> last;
    private int n = 0;

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
}
