package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam9012_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = bf.readLine();
        }
        for (String s : arr) {
            isVPS(s);
        }
    }

    static void isVPS(String s) {
        Stack<Character> stack = new Stack<>();
        char[] tmp = s.toCharArray();
        for (char c : tmp) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
