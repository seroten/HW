import java.util.EmptyStackException;

public class Inverter {
    String text;
    Stack<String> stack;

    public Inverter(String text) {
        this.text = text;
        stack = new Stack<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            stack.push(String.valueOf(text.charAt(i)));
        }
    }

    public String reverse() {
        StringBuilder sb = new StringBuilder();
        System.out.println(stack.size());
        for (int i = stack.size(); i > 0; i--) {
            sb.append(stack.pop());
        }
        System.out.println(stack.size());
        return sb.toString();
    }

    class Stack<T> {
        private int size;
        private T[] list;
        private final int DEFAULT_CAPACITY = 10;

        public Stack() {
            list = (T[]) new Object[DEFAULT_CAPACITY];
        }
        public Stack(int capacity) {
            list = (T[]) new Object[capacity];
        }

        public void push(T item) {
            if(isFull()) reCapacity();
            list[size] = item;
            size++;
        }

        public T pop() {
            T temp = list[size-1];
            size--;
            list[size] = null;
            return temp;
        }

        public T peek() {
            if(isEmpty()) throw new EmptyStackException();
            return list[size-1];
        }

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == list.length;
        }

        public void reCapacity() {
            T[] temp = (T[]) new Object[list.length*2];
            System.arraycopy(list, 0, temp, 0, size);
            list = temp;
        }

//        @Override
//        public String toString() {
//            if(size > 0 ) {
//                StringBuilder sb = new StringBuilder("[");
//                for (int i = 0; i < size; i++) {
//                    sb.append(list[i]);
//                    sb.append(", ");
//                }
//                sb.setLength(sb.length() - 2);
//                sb.append("]");
//                return sb.toString();
//            }
//            return "[]";
//        }
    }
}
