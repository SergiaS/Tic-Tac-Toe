import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean res = true;

        if (size > 1) {
            for (int i = 0; i < arr.length-1; i++) {
                if (
                        (arr[i] == n && arr[i+1] == m) ||
                                (arr[i] == m && arr[i+1] == n)
                ) {
                    res = false;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
