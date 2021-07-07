package baekjun;

import java.io.*;
import java.util.*;

public class exam1715_clear {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < T; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < T - 1; i++) {
            int a = pq.poll();
            int b = pq.poll();
            count += a + b;
            pq.add(a + b);
        }
        System.out.println(count);
    }
}
