import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 1; i <= n; i++) {
            int element = scanner.nextInt();

            if (i != n) {
                arr[i] = element;
            } else {
                arr[0] = element;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
