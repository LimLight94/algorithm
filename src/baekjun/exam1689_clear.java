package baekjun;

import java.io.*;
import java.util.*;

public class exam1689_clear {
    public static void main(String[] args) throws IOException {
        int inputSize = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < inputSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            tm.put(start,tm.getOrDefault(start,0)+1);
            tm.put(last,tm.getOrDefault(last,0)-1);
        }
        int s = 0;
        int r = 0;
        int count = 0;
        for (int val : tm.values()) {
            s += val;
            r = Math.max(r, s);
        }
        System.out.println(r);
    }
}
