package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam5585_clear {
    static int money = 1000;
    static int[] arr = new int[]{500, 100, 50, 10, 5, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        money = money - n;
        for (int j : arr) {
            int tmp = money / j;
            count += tmp;
            money = money - (tmp * j);
        }
        System.out.println(count);
    }
}
