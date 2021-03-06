package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
    }

    @Test
    public void testEnqueueDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(10);
        arb.enqueue(9);
        arb.enqueue(8);
        int d1 = arb.dequeue();
        int d2 = arb.dequeue();
        assertEquals(10, d1);
        assertEquals(9, d2);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 1; i < arb.capacity(); i++) {
            arb.enqueue(i);
        }
        String sb = new String();
        for (int x : arb) {
            sb += x;
        }
        assertEquals("123456789", sb);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
