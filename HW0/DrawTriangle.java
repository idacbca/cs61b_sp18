package HW0;

public class DrawTriangle {

	public static void drawTriangle(int n) {
		for (int x = 0; x < n; x++) {
			int y = 0;
			do {
				System.out.print("*");
				y++;
			} while ( y <= x );
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawTriangle.drawTriangle(10);
	}

}
