import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>{
    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if(isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        newNode.setPrev(last);
        if(isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T getFirst() {
        if(isEmpty()) throw new NoSuchElementException();
        return first.getValue();
    }

    public T getLast() {
        if(isEmpty()) throw new NoSuchElementException();
        return last.getValue();
    }

    public T removeFirst() {
        T temp = getFirst();
        first = first.getNext();
        if(isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public T removeLast() {
        T temp = last.getValue();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    public final int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current.getNext() != null) {
            if(current.getValue().equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if(index < 0 || index > size) throw new IllegalArgumentException();
        if(index == 0) {
            insertFirst(item);
            return;
        }
        if(index == size) {
            insertLast(item);
            return;
        }
        Node newNode = new Node(item);
        Node current = first;
        int count = 0;
        while(count != index-1) {
            current = current.getNext();
            count++;
        }
        newNode.setNext(current.getNext());
        current.getNext().setPrev(newNode);
        newNode.setPrev(current);
        current.setNext(newNode);
        size++;
    }

    public T remove(int index) {
        if(index < 0 || index > size) throw new IllegalArgumentException();
        if(index == 0) {
            return removeFirst();
        }
        if(index == size- 1) {
            return removeLast();
        }
        Node current = first;
        int count = 0;
        while(count < index) {
            current.getNext();
            count++;
        }
        T temp = current.getValue();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return temp;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current= current.getNext();
            return current.getValue();
        }
    }

    @Override
    public String toString() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                //TODO
            }
            return sb.toString();
        }
        return "[]";
    }

    class Node {
        T value;
        Node prev;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.prev = prev;
        }

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
