import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 0, rowIndex = 0, columnIndex = 0;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int current = sc.nextInt();
                matrix[i][j] = current;

                if (i == 0 & j == 0) {
                    max = current;
                } else if (max < current) {
                    max = current;
                    rowIndex = i;
                    columnIndex = j;
                }
            }
        }

        System.out.println(rowIndex + " " + columnIndex);
    }
}
