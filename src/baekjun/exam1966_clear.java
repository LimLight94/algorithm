package baekjun;

import java.util.*;

public class exam1966_clear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total_case = sc.nextInt();
        ArrayDeque<Integer> aq = new ArrayDeque<>();

        for (int i = 0; i < total_case; i++) {
            aq.clear();
            int count = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                aq.addLast(sc.nextInt());
            }


            //logic
            while (true) {
                if (isMax(aq)) {
                    aq.removeFirst();
                    count += 1;
                    if (m == 0) {
                        System.out.println(count);
                        break;
                    } else {
                        m -= 1;
                    }
                } else {
                    int first = aq.removeFirst();
                    aq.addLast(first);
                    if (m == 0) {
                        m += aq.size() - 1;
                    } else {
                        m -= 1;
                    }
                }
            }
        }
    }

    public static boolean isMax(ArrayDeque<Integer> q) {
        int first = q.peekFirst();
        for (int i : q) {
            if (i > first)
                return false;
        }
        return true;
    }
}
