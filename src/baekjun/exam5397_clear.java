package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ListIterator;
import java.util.Stack;

public class exam5397_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<Character> s_l = new Stack<>();
            Stack<Character> s_r = new Stack<>();
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '<') {
                    if (!s_l.isEmpty())
                        s_r.push(s_l.pop());
                } else if (c == '>') {
                    if (!s_r.isEmpty())
                        s_l.push(s_r.pop());
                } else if (c == '-') {
                    if (!s_l.isEmpty())
                        s_l.pop();
                } else {
                    s_l.push(c);
                }
            }

            StringBuilder result = new StringBuilder();
            while (!s_r.empty()) {
                s_l.push(s_r.pop());
            }
            while (!s_l.empty()) {
                result.append(s_l.pop());
            }
            System.out.println(result.reverse().toString());
        }
    }
}
