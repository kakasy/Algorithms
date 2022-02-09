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


    public void all() {
        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.item);
        }
    }

    public void delete(int k) {

        Node current = first; // ссылка на первый элемент списка
        /*не нужны*/
//        Node previous = null; // ссылка на элемент перед удаляемым
//        Node ahead = null; // ссылка на элемент после удаляемого

        if(current == null){ // проверяем пуст ли список
            throw new NullPointerException();
        }

        if (k < 0 || k >= size()){ // если k - отрицательное число или больше размера списка
            throw new IndexOutOfBoundsException();
        }

        if (k == 0) { // если удаляемый элемент списка - голова, делаем новой головой следующий за ним
            first = first.next;
        }

        else {
            for (int i = 0; i < k - 1; i++) { // если k != 0
                current = current.next;       // проходим по списку на позицию k
            }
        }
        if (current != null) { // если текущий элемент есть
            current.next = current.next.next; // следующим за ним элементом делаем элемент,
                                             // который стоит после удаляемого
        }
        N--;
    }

    public boolean find(MyStack<T> myStack, T key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.item.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
