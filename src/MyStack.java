public class MyStack<T> {

    private int N; // кол-во элементов в стеке
    private Node first; // верхний узел стека


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
}
