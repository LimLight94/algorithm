package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam5719_clear {
    static int N, M, S, D;
    static int[] distance = new int[500];
    static List<Pair>[] adj;
    static List<Pair>[] reverseAdj;
    static Queue<Pair> queue;
    static boolean[][] dropArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tmp = br.readLine().split(" ");
            N = Integer.parseInt(tmp[0]);
            M = Integer.parseInt(tmp[1]);
            if (N == 0 && M == 0)
                break;
            adj = new ArrayList[500];
            reverseAdj = new ArrayList[500];
            dropArr = new boolean[500][500];
            Arrays.fill(distance, Integer.MAX_VALUE);
            tmp = br.readLine().split(" ");
            S = Integer.parseInt(tmp[0]);
            D = Integer.parseInt(tmp[1]);
            for (int i = 0; i < M; i++) {
                tmp = br.readLine().split(" ");
                int u = Integer.parseInt(tmp[0]);
                int v = Integer.parseInt(tmp[1]);
                int p = Integer.parseInt(tmp[2]);
                if (adj[u] == null)
                    adj[u] = new ArrayList<>();
                adj[u].add(new Pair(v, p));
                if (reverseAdj[v] == null)
                    reverseAdj[v] = new ArrayList<>();
                reverseAdj[v].add(new Pair(u, p));
            }
            dijkstra();
            bfs();
            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra();
            if (distance[D] != Integer.MAX_VALUE)
                System.out.println(distance[D]);
            else
                System.out.println(-1);
        }
    }

    static void dijkstra() {
        distance[S] = 0;
        queue = new PriorityQueue<>();
        queue.add(new Pair(0, S));
        while (!queue.isEmpty()) {
            Pair tmpPair = queue.poll();
            if (distance[tmpPair.second] < tmpPair.first) continue;
            if (adj[tmpPair.second] == null) continue;
            for (Pair pair : adj[tmpPair.second]) {
                if (dropArr[tmpPair.second][pair.first])
                    continue;
                int nextDist = tmpPair.first + pair.second;
                int next = pair.first;
                if (distance[next] > nextDist) {
                    distance[next] = nextDist;
                    queue.add(new Pair(nextDist, next));
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(D);
        while (!bfsQueue.isEmpty()) {
            int target = bfsQueue.poll();
            if (target == S) continue;
            if (reverseAdj[target] == null) continue;
            for (int i = 0; i < reverseAdj[target].size(); i++) {
                int prev = reverseAdj[target].get(i).first;
                int cost = reverseAdj[target].get(i).second;
                if (distance[target] == cost + distance[prev]) {
                    dropArr[prev][target] = true;
                    if (!bfsQueue.contains(prev))
                        bfsQueue.add(prev);
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return this.first - o.first;
        }
    }
}
