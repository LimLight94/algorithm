import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam10282_clear {
    static int T;
    static int N;
    static int D;
    static int C;
    static List<Pair<Integer, Integer>>[] graph;
    static int[] distance = new int[10001];
    static Queue<Pair<Integer, Integer>> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] tmp = br.readLine().split(" ");
            N = Integer.parseInt(tmp[0]);
            D = Integer.parseInt(tmp[1]);
            C = Integer.parseInt(tmp[2]);
            graph = new List[10001];
            Arrays.fill(distance, Integer.MAX_VALUE);
            queue = new PriorityQueue<>();
            for (int j = 0; j < D; j++) {
                String[] tmp2 = br.readLine().split(" ");
                if (graph[Integer.parseInt(tmp2[1])] == null)
                    graph[Integer.parseInt(tmp2[1])] = new ArrayList<>();
                graph[Integer.parseInt(tmp2[1])].add(new Pair<>(Integer.parseInt(tmp2[0]), Integer.parseInt(tmp2[2])));
            }
            dijkstra();
            int count = 0;
            int maxDistance = 0;
            for (int j = 1; j <= N; j++) {
                if (distance[j] != Integer.MAX_VALUE) {
                    count++;
                    maxDistance = Math.max(maxDistance, distance[j]);
                }
            }
            System.out.println(count + " " + maxDistance);
        }
    }

    static void dijkstra() {
        queue.add(new Pair<>(0, C));
        distance[C] = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> tmp = queue.poll();
            if (distance[tmp.second] < tmp.first) continue;
            if (graph[tmp.second] == null) continue;
            for (Pair<Integer, Integer> pair : graph[tmp.second]) {
                int next = pair.first;
                int nextDist = pair.second + tmp.first;
                if (distance[next] > nextDist) {
                    distance[next] = nextDist;
                    queue.add(new Pair<>(nextDist, next));
                }
            }
        }
    }

    static class Pair<T, S> implements Comparable<Pair> {
        T first;
        S second;

        public Pair(T first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            return (Integer) this.first - (Integer) o.first;
        }
    }
}
