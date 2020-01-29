package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /** Makes first/last pointing at next position. */
    private int forward(int p) {
        return (p + 1) % capacity;
    }

    /** Makes first/last pointing at previous position. */
    private int back(int p) {
        return (p - 1 + capacity) % capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (fillCount < capacity) {
            rb[last] = x;
            fillCount += 1;
            last = forward(last);
        } else {
            throw new RuntimeException("Ring Buffer Overflow");
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T returnItem = rb[first];
            fillCount -= 1;
            first = forward(first);
            return returnItem;
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (!isEmpty()) {
            return rb[first];
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int wizPos;
        private int count;

        ArrayRingBufferIterator() {
            wizPos = first;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < fillCount();
        }

        @Override
        public T next() {
            T returnItem = rb[wizPos];
            wizPos = forward(wizPos);
            count += 1;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
}
