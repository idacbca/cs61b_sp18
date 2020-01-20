public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Resize the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Resize the underlying array of lesser than 25% usage and longer than the length of 16. */
    private void resize() {
        if (size >= 16) {
            if (items.length > 4 * size) {
                resize(size);
            }
        }
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T x) {
        if (size == 0) {
            items[0] = x;
            size = size + 1;
        } else {
            T[] a = (T[]) new Object[items.length + 1];
            System.arraycopy(items, 0, a, 1, size);
            a[0] = x;
            items = a;
            size = size + 1;
            resize();
        }
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size = size + 1;
        resize();
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque.*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println("");
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size != 0) {
            T x = get(0);
            T[] a = (T[]) new Object[items.length];
            System.arraycopy(items, 1, a, 0, size - 1);
            size = size - 1;
            return x;
        } else return null;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size != 0) {
            T x = get(size - 1);
            items[size - 1] = null;
            size = size - 1;
            return x;
        } else return null;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. */
    public T get(int index) {
        if (index > size) return null;
        return items[index];
    }
}
