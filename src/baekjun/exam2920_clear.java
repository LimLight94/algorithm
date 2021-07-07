package baekjun;

import java.util.Scanner;

public class exam2920_clear {
    public static void main(String[] args) {

        //input
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        boolean as = true;
        boolean ds = true;
        //logic
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                as = false;
            }
            if (arr[i] > arr[i - 1]) {
                ds = false;
            }
        }

        if (as) {
            System.out.println("ascending");
        } else if (ds) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
