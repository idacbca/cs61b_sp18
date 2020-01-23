import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String A = "a";
        String B = "racecar";
        String C = "horse";
        String D = "Racecar";
        String E = "";

        assertTrue(palindrome.isPalindrome(A));
        assertTrue(palindrome.isPalindrome(B));
        assertFalse(palindrome.isPalindrome(C));
        assertFalse(palindrome.isPalindrome(D));
        assertTrue(palindrome.isPalindrome(E));
    }

    @Test
    public void testIsPalindromeOBO() {
        CharacterComparator offByOne = new OffByOne();

        String A = "a";
        assertTrue(palindrome.isPalindrome(A, offByOne));

        String B = "qadecbr";
        assertTrue(palindrome.isPalindrome(B, offByOne));

        String C = "&%b&%";
        assertTrue(palindrome.isPalindrome(C, offByOne));

        String D = "askhdh";
        assertFalse(palindrome.isPalindrome(D, offByOne));

        String E = "qadcbm";
        assertFalse(palindrome.isPalindrome(E, offByOne));
    }
}
