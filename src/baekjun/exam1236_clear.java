package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1236_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        int r = Integer.parseInt(tmp[0]);
        int c = Integer.parseInt(tmp[1]);
        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            tmp = bf.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (tmp[j].equals(".")) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        int r_count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    break;
                }
                if (j == c - 1)
                    r_count++;
            }
        }

        int c_count = 0;
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (arr[i][j] == 1) {
                    break;
                }
                if (i == r - 1)
                    c_count++;
            }
        }

        System.out.println(Math.max(r_count,c_count));
    }
}
