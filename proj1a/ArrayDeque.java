public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Makes nextFirst/nextLast pointing at next position. */
    private int forward(int p) {
        return (p + 1) % items.length;
    }

    /** Makes nextFirst/nextLast pointing at previous position. */
    private int back(int p) {
        // Adds an additional item.length since p - 1 could be negative.
        return (p - 1 + items.length) % items.length;
    }

    /** Resize the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int p = forward(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[p];
            p = forward(p);
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private boolean isSparse() {
        return items.length >= 16 && items.length > 4 * size;
    }

    /** Resize the underlying array of lesser than 25% usage and longer than the length of 16. */
    private void resize() {
        resize(items.length / 2);
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = back(nextFirst);
        size = size + 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = forward(nextLast);
        size = size + 1;
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
        for (int i = forward(nextFirst); i < size; i = forward(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        if (size != 0) {
            T x = get(0);
            nextFirst = forward(nextFirst);
            items[nextFirst] = null;
            size = size - 1;
            if (isSparse()) {
                resize();
            }
            return x;
        } else {
            return null;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        if (size != 0) {
            T x = get(size - 1);
            nextLast = back(nextLast);
            items[nextLast] = null;
            size = size - 1;
            if (isSparse()) {
                resize();
            }
            return x;
        } else {
            return null;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. */
    public T get(int index) {
        if (index > items.length) {
            return null;
        }
        int p = forward(nextFirst);
        for (int i = 0; i < index; i++) {
            p = forward(p);
        }
        return items[p];
    }
}
