import java.util.Iterator;

public class DoubleNodeQueue<T> implements Iterable<T>{

    private int N;
    private DoubleNode first; // ссылка на первый элемент
    private DoubleNode last; // ссылка на последний элемент

    @Override
    public Iterator<T> iterator() {
        return new DoubleNodeIteration();
    }

    private class DoubleNodeIteration implements Iterator<T>{
        DoubleNode current = first;
        @Override
        public boolean hasNext() {
            return current != null ;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
    private class DoubleNode {
        T item;
        DoubleNode next;
        DoubleNode prev;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public void all() {
        for (DoubleNode x = first; x != null; x = x.next) {
            System.out.println(x.item);
        }
    }

    public void addFirst(T item) {
        DoubleNode oldFirst = first;
        if (first ==null) {
            first = new DoubleNode();
            first.item = item;
            last = first;
        }
        else {
            first = new DoubleNode();
            first.item = item;
            first.next = oldFirst;
            oldFirst.prev = first;
            first.prev = null;
        }
        N++;
    }

    public void addLast(T item) {
        DoubleNode oldLast = last;
        if (last == null) {
            last = new DoubleNode();
            last.item = item;
            first = last;
        }
        else {
            last = new DoubleNode();
            last.item = item;
            last.prev = oldLast;
            oldLast.next = last;
            last.next = null;
        }
        N++;
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        else {
            T item = first.item;
            first = first.next;
            N--;
            return item;
        }
    }

    public T removeLast() {
        if (last == null) {
            return null;
        }
        else {
            T item = last.item;
            last = last.prev;
            last.next = null;
            N--;
            return item;
        }
    }

    public void delete (int k) {
        DoubleNode current = first;
        if (k == 0) {
            removeFirst();
        }
        if (k == size() - 1 || k == size()) {
            removeLast();
        }
        if (current == null) {
            throw  new NullPointerException();
        }
        if (k < 0 || k > size()) {
            throw new IndexOutOfBoundsException();
        }
        else {
            for (int i = 0; i < k; i++) {
                current = current.next;
            }
        }
        if (current != null) {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;

        }
        N--;
    }

    public void insertBefore(DoubleNodeQueue doubleNodeQueue, T item, int k) {
        DoubleNode current = first;

        if (k < 0 || k > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (current == null) {
            throw new NullPointerException();
        }

        else {
            for (int i = 0; i < k; i++) {
                current = current.next;
            }
        }
        if (current != null) {
            if (k == 0) {
                addFirst(item);
            } else {
                DoubleNode inserted = new DoubleNode();
                inserted.item = item;
                inserted.next = current;
                inserted.prev = current.prev;
                current.prev.next = inserted;
                current.prev = inserted;
            }
        }
        N++;
    }

    public void insertAfter(DoubleNodeQueue doubleNodeQueue, T item, int k) {
        DoubleNode current = first;

        if (k < 0 || k >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (current == null) {
            throw new NullPointerException();
        }

        else {
            for (int i = 0; i < k; i++) {
                current = current.next;
            }
        }
        if (current != null) {
            if (k == size() - 1) {
                addLast(item);
            }
            else {
                DoubleNode inserted = new DoubleNode();
                inserted.item = item;
                current.next.prev = inserted;
                inserted.next = current.next;
                inserted.prev = current;
                current.next = inserted;
            }
        }
        N++;
    }
}
