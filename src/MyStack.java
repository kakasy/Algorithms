import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

    private int N; // кол-во элементов в стеке
    private Node first; // верхний узел стека

    @Override
    public Iterator<T> iterator() {
        return new StackIteration();
    }


    private class Node {
        private T item;
        private Node next;
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public T peek() {
        T item = first.item;
        return item;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }


    private class StackIteration implements Iterator<T> {

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
