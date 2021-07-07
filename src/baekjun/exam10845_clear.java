package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class exam10845_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n ; i++){
            String[] tmp = bf.readLine().split(" ");
            if(tmp[0].equals("push")){
                deque.addLast(Integer.parseInt(tmp[1]));
            }
            if(tmp[0].equals("pop")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else{
                    sb.append(deque.removeFirst()).append("\n");
                }
            }
            if(tmp[0].equals("size")){
                sb.append(deque.size()).append("\n");
            }
            if(tmp[0].equals("empty")){
                if(deque.isEmpty())
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            if(tmp[0].equals("front")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else{
                    sb.append(deque.getFirst()).append("\n");
                }
            }
            if(tmp[0].equals("back")){
                if(deque.isEmpty())
                    sb.append("-1\n");
                else{
                    sb.append(deque.getLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
