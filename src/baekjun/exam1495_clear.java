package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1495_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int M = Integer.parseInt(str[2]);
        String[] tmp = br.readLine().split(" ");
        int[] volArr = new int[tmp.length];
        for (int i = 0; i < volArr.length; i++) {
            volArr[i] = Integer.parseInt(tmp[i]);
        }
        boolean[][] resultArr = new boolean[volArr.length + 1][M + 1];
        resultArr[0][S] = true;

        for (int i = 0; i < resultArr.length - 1; i++) {
            for (int j = 0; j < resultArr[i].length; j++) {
                if (resultArr[i][j]) {
                    if (j + volArr[i] < M + 1 && j + volArr[i] > -1)
                        resultArr[i + 1][j + volArr[i]] = true;
                    if (j - volArr[i] < M + 1 && j - volArr[i] > -1)
                        resultArr[i + 1][j - volArr[i]] = true;
                }
            }
        }
        int result = -1;
        for (int i = 0; i < M + 1; i++) {
            if (resultArr[N][i])
                result = i;
        }
        System.out.println(result);
    }
}
