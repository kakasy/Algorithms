public class MyQueue<T> {

    private int N; // кол-во элементов в очереди
    private Node first;// самый старый элемент очереди
    private Node last; // самый новый элемент очереди


    private class Node {
        T item; // элемент
        Node next; //ссылка на след элемент
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next; // самый старый элемент это теперь второй элемент
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }
}
