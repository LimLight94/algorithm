package baekjun;

import java.io.*;
import java.util.*;

public class exam1766_clear {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        List<Integer>[] list = new List[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
        int[] nodeCount = new int[N];
        for (int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            list[a - 1].add(b);
            nodeCount[b - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (nodeCount[i] == 0) {
                pq.add(i + 1);
            }
        }
        while (!pq.isEmpty()) {
            //간선없는것 pq 에 저장
            int b = pq.poll();
            System.out.print(b + " ");
            //간선제거
            for (int a : list[b - 1]) {
                nodeCount[a - 1]--;
                if (nodeCount[a - 1] == 0) {
                    pq.add(a);
                }
            }
        }
    }
}
