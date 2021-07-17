package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class exam1697_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);
        int[] visited = new int[100001];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> countQueue = new ArrayDeque<>();
        queue.add(N);
        countQueue.add(1);
        while (!queue.isEmpty()) {
            int x = queue.pop();
            int c = countQueue.pop();
            if (x < 0 || x > 100000 || visited[x] != 0)
                continue;
            visited[x] = c;
            if(x==K){
                break;
            }
            queue.add(x - 1);
            countQueue.add(c+1);
            queue.add(x + 1);
            countQueue.add(c+1);
            queue.add(2 * x);
            countQueue.add(c+1);
        }
        System.out.println(visited[K]-1);
    }
}
