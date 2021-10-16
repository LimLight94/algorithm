package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1439_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s + "2";
        char before = s.charAt(0);
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != before) {
                if (before == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                before = c;
            }
        }
        System.out.println(Math.min(zeroCount, oneCount));
    }
}
