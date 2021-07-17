package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2606_clear {
    static int[][] arr;
    static int[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N];
        for (int i = 0; i < K; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = 1;
            arr[Integer.parseInt(tmp[1]) - 1][Integer.parseInt(tmp[0]) - 1] = 1;
        }
        dfs(0);
        System.out.println(count-1);
    }

    public static void dfs(int start) {
        count++;
        visited[start] = 1;
        for (int i = 0; i < arr[start].length; i++) {
            if (arr[start][i] == 1 && visited[i] == 0) {
                dfs(i);
            }
        }
    }
}
