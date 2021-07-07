package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1749_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //input
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        //calculate

        System.out.println(calculate4(array));
    }

    static int calculate4(int[][] array) {
        int n = array.length;
        int m = array[0].length;

        int[][] S = new int[n][m];

        int result = -10000;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                S[i][j] = Sum(array, i, j);
                if (S[i][j] > result)
                    result = S[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i ; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        if(i==k && j==l){
                            tmp = array[i][j];
                        } else if (i == 0 && j == 0) {
                            tmp = S[k][l];
                        } else if (i == 0) {
                            tmp = S[k][l] - S[k][0];
                        } else if (j == 0) {
                            tmp = S[k][l] - S[0][l];
                        } else {
                            tmp = S[k][l] - S[i - 1][l] - S[k][j - 1] + S[i - 1][j - 1];
                        }
                        if (tmp > result)
                            result = tmp;
                    }
                }
            }
        }
        return result;
    }

    static int Sum(int[][] array, int x, int y) {
        int result = 0;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                result += array[i][j];
            }
        }
        return result;
    }

//    static int calculate3(int[][] array) {
//        int n = array.length;
//        int m = array[0].length;
//        int tmp = 0;
//        int tmpSum = 0;
//        int Sum = 0;
//        int[] tmpArray;
//
//        for (int i = 0; i < n; i++) {
//            tmpArray = new int[m];
//            for (int j = i; j < n; j++) {
//                tmp = 0;
//                tmpSum = 0;
//                for (int k = 0; k < m; k++) {
//                    tmpArray[k] += array[j][k];
//                    tmp += tmpArray[k];
//                    if (tmp > tmpSum) {
//                        tmpSum = tmp;
//                    }
//                    if (tmp < 0) {
//                        tmp = 0;
//                    }
//                }
//                if (tmpSum > Sum)
//                    Sum = tmpSum;
//            }
//        }
//        return Sum;
//    }
}
