import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			
		}




//		if (matrix.length <= 1) {
//			System.out.println("YES");
//			return;
//		} else {
//			for (int i = 0; i <= 1; i++) {
//				for (int j = 0; j < n; j++) {
////				System.out.println(matrix[i][j] + " == " + matrix[j][i]);
//					if (matrix[i][j] != matrix[j][i]) {
//						System.out.println("NO");
//						return;
//					}
//				}
//
//				i = n - 1;
//				for (int j = n - 1; j >= 0; j--) {
////				System.out.println(matrix[j][i] + " == " + matrix[i][j]);
//					if (matrix[j][i] != matrix[i][j]) {
//						System.out.println("NO");
//						return;
//					}
//				}
//			}
//		}
//
//		System.out.println("YES");
	}
}
