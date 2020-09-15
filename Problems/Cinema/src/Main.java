import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int max = 0, indexRow = 0;
		int[][] matrix = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int need = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int freePlaces = 0;
			for (int j = 0; j < m; j++) {
				int current = matrix[i][j];
				if (j != 0) {
					if (matrix[i][j - 1] == 0 && current == 0) {
						freePlaces++;
//						System.out.println("fs1: " + freePlaces + ", i: " + i + ", j: " + j);
					} else if (matrix[i][j - 1] == 0 && current != 0) {
						freePlaces++;
//						System.out.println("fs2: " + freePlaces + ", i: " + i + ", j: " + j + ", max = " + max);
						if (max < freePlaces) {
							max = freePlaces;
							indexRow = i;
							if (max >= need) {
								System.out.println(indexRow + 1);
								return;
							}
						}
						freePlaces = 0;
					}

					if (j == m - 1) {
//						System.out.println("fs3: " + freePlaces + ", i: " + i + ", j: " + j);
						if (current == 0) {
							freePlaces++;
//							System.out.println("fs4: " + freePlaces + ", i: " + i + ", j: " + j);
						}
						if (max < freePlaces) {
//							System.out.println(">> " + max);
							max = freePlaces;
							indexRow = i;

							if (max >= need) {
								System.out.println(indexRow + 1);
								return;
							}
						}
					}
				}
			}
		}
		System.out.println(need <= max ? indexRow + 1 : 0);
	}
}
