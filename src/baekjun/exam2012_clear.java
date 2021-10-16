package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2012_clear {
    public static void main(String[] args) throws IOException {
        // input 세팅
        int[] arr;
        long moveCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // logic
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            moveCount += Math.abs(i - arr[i]);
        }
        System.out.println(moveCount);
    }
}
