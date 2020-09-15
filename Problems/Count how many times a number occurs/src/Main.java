import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int lenght = sc.nextInt();
        int[] arr = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        int count = 0;

        for (int a : arr) {
            if (a == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}
