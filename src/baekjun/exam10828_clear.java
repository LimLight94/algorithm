package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class exam10828_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            String[] tmp = bf.readLine().split(" ");
            if(tmp[0].equals("push")){
                stack.push(Integer.parseInt(tmp[1]));
            }
            if(tmp[0].equals("pop")){
                if(stack.isEmpty())
                    sb.append("-1\n");
                else{
                    sb.append(stack.pop()).append("\n");
                }
            }
            if(tmp[0].equals("size")){
                sb.append(stack.size()).append("\n");
            }
            if(tmp[0].equals("empty")){
                if(stack.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            if(tmp[0].equals("top")){
                if(stack.isEmpty())
                    sb.append("-1\n");
                else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
