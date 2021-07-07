package baekjun;

import java.io.*;
import java.util.*;

public class exam12865_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            String[] tmp = br.readLine().split(" ");
            int tmpW = Integer.parseInt(tmp[0]);
            int tmpV = Integer.parseInt(tmp[1]);
            for (int j = 1; j <= K; j++) {
                if (j < tmpW) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i-1][j - tmpW] + tmpV);
                }
            }
        }
        System.out.println(arr[N][K]);
    }
}
