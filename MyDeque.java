import java.util.Arrays;
import java.util.EmptyStackException;

public class MyDeque<T>  {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;
    public static int temp;

    public MyDeque(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("capacity: " + capacity);
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertEnd(T item) {
        if(isFull()) throw new IllegalStateException();
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertFront(T item) {
        if(isFull()) throw new IllegalStateException();
        begin = previuosIndex(begin);
        list[begin] = item;
        size++;
    }

    public T removeFront() {
        if(isEmpty()) throw new EmptyStackException();
        T temp = peekFront();
        list[begin] = null;
        begin = nextIndex(begin);
        size--;
        return temp;
    }

    public T removeEnd() {
        if(isEmpty()) throw new EmptyStackException();
        T temp = peekEnd();
        list[end-1] = null;
        end = previuosIndex(end);
        size--;
        return temp;
    }

    public T peekFront() {
        if(isEmpty()) throw new EmptyStackException();
        return list[begin];
    }

    public T peekEnd() {
        if(isEmpty()) throw new EmptyStackException();
        return list[end-1];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previuosIndex(int index) {
        if(index == 0) return list.length-1;
        return index-1;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " begin: " + begin + " end: " + end;
    }

}
