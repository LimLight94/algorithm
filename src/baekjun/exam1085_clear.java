package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1085_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);
        int h = Integer.parseInt(str[3]);

        int a = w-x;
        int b = x;
        int tmp1 = Math.min(a,b);
        int c = h-y;
        int d = y;
        int tmp2 = Math.min(c,d);
        System.out.println(Math.min(tmp1,tmp2));
    }
}
