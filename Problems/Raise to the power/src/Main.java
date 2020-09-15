import java.util.Scanner;

public class Main {

    public static long power(int n, int m) {
        // write your code here
        long res = n != 0 && m != 0 ? n : 1;
        for (int i = 1; i < m; i++) {
            res *= n;
        }
        return res;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        System.out.println(power(n, m));
    }
}
