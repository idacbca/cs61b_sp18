import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    @Test
    public void libTest() {
        int A = 1234;
        int B = 1234;
        assertTrue(Flik.isSameNumber(A, B));
    }
}
