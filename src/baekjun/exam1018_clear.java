package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1018_clear {
    public static void main(String[] args) throws IOException {
        int min = 64;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i <= arr.length-8; i++) {
            for (int j = 0; j <= arr[i].length-8; j++) {
                int a = cal(arr,i,j,'W');
                int b = cal(arr,i,j,'B');
                int t = Math.min(a,b);
                if(t<min)
                    min = t;
                if(t<min)
                    min = t;
            }
        }
        System.out.println(min);
    }

    static int cal(char[][] arr, int r, int c, char ch) {
        char state = ch;
        int count = 0;
        for (int i = r; i < r + 8; i++) {
            if(i!=r) {
                if (state == 'W') {
                    state = 'B';
                } else {
                    state = 'W';
                }
            }
            for (int j = c; j < c + 8; j++) {
                if (arr[i][j] != state)
                    count++;
                if (state == 'W') {
                    state = 'B';
                } else {
                    state = 'W';
                }
            }
        }
        return count;
    }
}
