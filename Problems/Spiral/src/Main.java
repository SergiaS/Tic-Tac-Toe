import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// put your code here
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n <= 1) {
			System.out.println(1);
			return;
		}

		int[][] matrix = new int[n][n];

		int h = 0, v = 0, cycle = 0, count = 1;
		while (count+1 != n*n) {

			// right
			for (int i = h; i < n - cycle; i++) {
				matrix[cycle][h] = count++;
				h++;
			}

			// down
			for (int i = v; i < n - cycle - 1; i++) {
				matrix[v+1][h-1] = count++;
				v++;
			}

			// left
			for (int i = h - 2; i >= cycle; i--) {
				matrix[v][i] = count++;
				h--;
			}

			cycle++;

			if (count >= n*n){
				break;
			}

			// up
			for (int i = v - 1; i >= cycle; i--) {
				matrix[v-1][h-1] = count++;
				v--;
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
