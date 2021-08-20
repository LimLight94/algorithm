package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1463_clear {
    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException {
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 4; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 6 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }
        }
        System.out.println(arr[N]);
    }
}
