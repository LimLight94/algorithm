package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class exam2655_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Block> list = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        list.add(new Block(0, 0, 0, 0));
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            list.add(new Block(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), i + 1));
        }
        list.sort(Comparator.comparingInt(o -> o.w));
        int[] dp = new int[N + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).d > list.get(j).d)
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).h);
            }
        }

        int maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxValue < dp[i]) {
                maxValue = dp[i];
                maxIndex = i;
            }
        }
        while (maxIndex != 0) {
            if (maxValue == dp[maxIndex]) {
                results.add(list.get(maxIndex).num);
                maxValue = maxValue - list.get(maxIndex).h;
            }
            maxIndex--;
        }
        System.out.println(results.size());
        for (int i = results.size() - 1; i >= 0; i--) {
            System.out.println(results.get(i));
        }

    }

    static class Block {
        int d;
        int h;
        int w;
        int num;

        public Block(int d, int h, int w, int num) {
            this.d = d;
            this.h = h;
            this.w = w;
            this.num = num;
        }
    }
}
