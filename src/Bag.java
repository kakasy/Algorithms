import java.util.Iterator;

public class Bag<T> implements Iterable<T>{

    private Node first;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new BagIteration();
    }

    private class Node {
        T item;
        Node next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void add (T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    private class BagIteration implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

}
