package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam4153_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            if (a == 0 && b == 0 && c == 0)
                break;
            int[] arr = {a, b, c};
            Arrays.sort(arr);
            if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
