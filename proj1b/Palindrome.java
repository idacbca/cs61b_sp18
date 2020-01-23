public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        char wordArray[] = word.toCharArray();
        LinkedListDeque<Character> lld = new LinkedListDeque<>();
        for (int i = 0; i < wordArray.length; i++) {
            lld.addLast(wordArray[i]);
        }
        return lld;
    }
}
