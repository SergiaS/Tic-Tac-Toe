import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        String[][] arr = new String[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = ".";
            }
        }


        for (String[] strings : arr) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }


    }
}
