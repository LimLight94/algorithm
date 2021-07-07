package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9251_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    arr[i][j] = arr[i-1][j-1]+1;
                else
                    arr[i][j] = Math.max(arr[i][j-1],arr[i-1][j]);
            }
        }
        System.out.println(arr[s1.length()][s2.length()]);
    }
}
