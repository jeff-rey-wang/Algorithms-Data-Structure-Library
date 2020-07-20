package DataStructs;

import java.util.NoSuchElementException;

public class Stack<Type> {

    private Node<Type> top;
    private int n = 0;

    private boolean isEmpty() {
        return top == null;
    }

    private int size() {
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
}
