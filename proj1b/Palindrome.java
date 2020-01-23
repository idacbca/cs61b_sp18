public class Palindrome {
    /** Transfer and returns a String to a deque in the same order
     * as a String. */
    public Deque<Character> wordToDeque(String word) {
        char[] wordArray = word.toCharArray();
        LinkedListDeque<Character> lld = new LinkedListDeque<>();
        for (char c : wordArray) {
            lld.addLast(c);
        }
        return lld;
    }

    /** A helper method of isPalindrome. */
    private boolean isPalindrome(Deque<Character> pDeque) {
        if (pDeque.size() == 1 || pDeque.size() == 0) {
            return true;
        }
        if (pDeque.removeFirst() != pDeque.removeLast()) {
            return false;
        }
        return isPalindrome(pDeque);
    }

    /** Checks if a word is a palindrome and returns true/false. */
    public boolean isPalindrome(String word) {
        Deque<Character> pDeque = wordToDeque(word);
        return isPalindrome(pDeque);
    }

    /** A helper method of off-by-one isPalindrome. */
    private boolean isPalindrome(Deque<Character> pDeque, CharacterComparator cc) {
        if (pDeque.size() == 1 || pDeque.size() == 0) {
            return true;
        }
        if (!cc.equalChars(pDeque.removeFirst(), pDeque.removeLast())) {
            return false;
        }
        return isPalindrome(pDeque, cc);
    }

    /** Checks if a word is an off-by-one palindrome and returns true/false. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> pDeque = wordToDeque(word);
        return isPalindrome(pDeque, cc);
    }
}
