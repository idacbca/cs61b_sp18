package HW0;

public class Max {
	public static int max(int[] m) {
		int x = 0;
		for (int y : m) {
			if (x < y) {
				x = y;
			}
		}
        return x;
    }
	
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       int x = Max.max(numbers);
       System.out.println(x);
    }
}
