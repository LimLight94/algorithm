package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class exam3055_clear {

    static int[] mx = {-1, 1, 0, 0};
    static int[] my = {0, 0, -1, 1};
    static char[][] arr;
    static int[][] dp;
    static Queue<Point> queue;
    static boolean founded;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int R = Integer.parseInt(tmp[0]);
        int C = Integer.parseInt(tmp[1]);
        arr = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        Point st = null;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                arr[i][j] = c;
                if (c == 'S') {
                    st = new Point(j, i, 'S');
                } else if (c == '*') {
                    queue.add(new Point(j, i, '*'));
                }
            }
        }
        queue.add(st);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]);
                founded = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ty = p.y + my[i];
                int tx = p.x + mx[i];
                if (ty >= 0 && ty < R && tx >= 0 && tx < C) {
                    if (p.type == '*') {
                        if (arr[ty][tx] == '.' || arr[ty][tx] == 'S') {
                            arr[ty][tx] = '*';
                            queue.add(new Point(tx, ty, '*'));
                        }
                    } else {
                        if (arr[ty][tx] == '.' || arr[ty][tx] == 'D') {
                            if (dp[ty][tx] == 0) {
                                dp[ty][tx] = dp[p.y][p.x] + 1;

                                queue.add(new Point(tx, ty, arr[ty][tx]));
                            }
                        }
                    }
                }
            }
        }
        if (!founded) {
            System.out.println("KAKTUS");
        }
    }

    static void move(int r, int c) {
        if (arr[r][c] != 'S')
            return;
        //up
        arr[r - 1][c] = 'S';
        arr[r][c] = '.';
        //down
        arr[r + 1][c] = 'S';
        arr[r][c] = '.';
        //left
        arr[r][c - 1] = 'S';
        arr[r][c] = '.';
        //right
        arr[r][c + 1] = 'S';
        arr[r][c] = '.';
    }

    static void bfs_h() {

    }

    static class Point {
        int x;
        int y;
        char type;

        public Point(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
