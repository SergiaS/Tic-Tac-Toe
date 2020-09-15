import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int size1 = sc.nextInt();
        int size2 = sc.nextInt();

        int[][] arr = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] rotate = new int[size2][size1];

        for (int i = 0; i < size2; i++) {
            int a = 0;
            for (int j = size1-1; j >= 0; j--) {
                rotate[i][j] = arr[a++][i];
            }
        }

        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size1; j++) {
                System.out.print(rotate[i][j] + " ");
            }
            System.out.println();
        }
    }
}
