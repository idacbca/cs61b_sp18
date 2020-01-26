import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testAddRemoveFirst() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int n = 1; n < 257; n++) {
            String massage1 = "";
            for (int i = 0; i < n; i++) {
                sad1.addFirst(i);
                ads1.addFirst(i);
                massage1 = massage1 + "addFirst(" + i + ")\n";
            }
            assertEquals(massage1 + "removeFirst()\n"
                            + "An error occurs following the above sequence.",
                    ads1.removeFirst(), sad1.removeFirst());
        }
    }

    @Test
    public void testAddRemoveLast() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int n = 1; n < 257; n++) {
            String massage1 = "";
            for (int i = 0; i < n; i++) {
                sad1.addLast(i);
                ads1.addLast(i);
                massage1 = massage1 + "addLast(" + i + ")\n";
            }
            assertEquals(massage1 + "removeLast()\n"
                            + "An error occurs following the above sequence.",
                    ads1.removeLast(), sad1.removeLast());
        }
    }

    @Test
    public void testAddRemove() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        String massage1 = "";

        for (int i = 0; i < 256; i++) {
            double randomNum = StdRandom.uniform();
            if (randomNum < 0.5) {
                sad1.addFirst(i);
                ads1.addFirst(i);
                massage1 = massage1 + "addFirst(" + i + ")\n";
            } else {
                sad1.addLast(i);
                ads1.addLast(i);
                massage1 = massage1 + "addLast(" + i + ")\n";
            }
        }

        for (int i = 0; i < 256; i++) {
            double randomNum = StdRandom.uniform();
            if (randomNum < 0.5) {
                massage1 = massage1 + "removeFirst()\n";
                assertEquals(massage1 + "An error occurs following the above sequence.",
                        ads1.removeFirst(), sad1.removeFirst());
            } else {
                massage1 = massage1 + "removeLast()\n";
                assertEquals(massage1 + "An error occurs following the above sequence.",
                        ads1.removeLast(), sad1.removeLast());
            }
        }
    }
}
