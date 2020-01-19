public class BreakContinue {
	  public static void windowPosSum(int[] a, int n) {
	      /** your code here */ 
		  for (int x = 0; x < a.length; x++) {
			  if (a[x] < 0) continue;
			  int  t = 0;
			  for (int y = 1; y <= n; y++) {
				  if (x + y >= a.length) break;
				  t += a[x + y];
			  }
			  a[x] += t;
		  }
	  }

	  public static void main(String[] args) {
	      int[] a = {1, 2, -3, 4, 5, 4};
	      int n = 3;
	      windowPosSum(a, n);
	
	      // Should print 4, 8, -3, 13, 9, 4
	      System.out.println(java.util.Arrays.toString(a));
	  }
}
