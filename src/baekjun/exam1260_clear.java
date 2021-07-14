package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class exam1260_clear {
    static StringBuilder resultDfs = new StringBuilder();
    static StringBuilder resultBfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmv = br.readLine().split(" ");
        int N = Integer.parseInt(nmv[0]);
        int M = Integer.parseInt(nmv[1]);
        int V = Integer.parseInt(nmv[2]);
        boolean[][] arr = new boolean[N][N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            arr[Integer.parseInt(tmp[0]) - 1][Integer.parseInt(tmp[1]) - 1] = true;
            arr[Integer.parseInt(tmp[1]) - 1][Integer.parseInt(tmp[0]) - 1] = true;
        }
        visited[V - 1] = true;
        resultDfs.append(V).append(" ");
        dfs(arr, visited, V - 1);
        System.out.println(resultDfs);
        visited = new boolean[N];
        bfs(arr, visited, V - 1);
        System.out.println(resultBfs);

    }

    //dfs
    public static void dfs(boolean[][] arr, boolean[] visited, int started) {
        for (int i = 0; i < arr[started].length; i++) {
            if (arr[started][i] && !visited[i]) {
                visited[i] = true;
                resultDfs.append(i + 1).append(" ");
                dfs(arr, visited, i);
            }
        }
    }

    //bfs
    public static void bfs(boolean[][] arr, boolean[] visited, int started) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(started);
        visited[started] = true;
        resultBfs.append(started + 1).append(" ");
        while(!queue.isEmpty()){
            int tmp = queue.pop();
            for(int i=0 ; i<arr[tmp].length ; i++){
                if(arr[tmp][i] && !visited[i]){
                    visited[i] = true;
                    resultBfs.append(i + 1).append(" ");
                    queue.add(i);
                }
            }
        }
    }

}
