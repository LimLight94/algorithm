package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1003_clear {
    static int[] arr0 = new int[41];
    static int[] arr1 = new int[41];

    public static void main(String[] args) throws IOException {
        arr0[0] = 1;
        arr1[1] = 1;
        for (int i = 2; i <= 40; i++) {
            fibonacci(i);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(arr0[num] + " " + arr1[num]);
        }
    }

    static void fibonacci(int n) {
        arr0[n] = arr0[n - 1] + arr0[n - 2];
        arr1[n] = arr1[n - 1] + arr1[n - 2];
    }
}
