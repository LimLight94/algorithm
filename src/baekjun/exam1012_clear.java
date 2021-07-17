package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1012_clear {
    static int[][] arr;
    static int[][] visited;
    static int count;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            String[] tmp = br.readLine().split(" ");
            M = Integer.parseInt(tmp[0]);
            N = Integer.parseInt(tmp[1]);
            int K = Integer.parseInt(tmp[2]);
            arr = new int[N][M];
            visited = new int[N][M];
            for (int j = 0; j < K; j++) {
                String[] tmp2 = br.readLine().split(" ");
                arr[Integer.parseInt(tmp2[1])][Integer.parseInt(tmp2[0])] = 1;
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (visited[n][m] == 0&& arr[n][m]==1) {
                        count++;
                        dfs(n, m);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int n, int m) {
        if (n >= 0 && n < N && m >= 0 && m < M && arr[n][m] == 1 && visited[n][m] == 0) {
            visited[n][m] = 1;
            dfs(n - 1, m);
            dfs(n + 1, m);
            dfs(n, m + 1);
            dfs(n, m - 1);
        }
    }
}
