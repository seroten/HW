public class StackMyLinkedList<T> {
    private MyLinkedList<T> stack = new MyLinkedList<T>();

    public void push(T item) {
        stack.insertFirst(item);
    }

    public T pop() {
        return stack.removeFirst();
    }

    public T peek() {
        return stack.getFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
