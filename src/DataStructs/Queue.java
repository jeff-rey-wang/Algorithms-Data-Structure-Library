package DataStructs;

public class Queue<Type> {

    private Node first;
    private Node last;
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Type item) {
        Node secLast = last;
        last = new Node();
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
        Type item = (Type) first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}
