package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam1062_clear {
    static int N;
    static int K;
    static boolean[] visited;
    static String[] words;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        K = Integer.parseInt(tmp[1]);
        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            s = s.substring(4, s.length() - 4);
            words[i] = s;
        }
        visited = new boolean[26];
        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        backtracking(0,0);
        System.out.println(max);

    }

    static void backtracking(int alpha, int len){
        if(K-5 == len){
            int count = 0;
            for(int i=0 ; i<N ; i++){
                boolean read = true;
                for(int j=0 ; j< words[i].length() ; j++){
                    if(!visited[words[i].charAt(j)-'a']){
                        read = false;
                        break;
                    }
                }
                if(read)
                    count++;
            }
            max = Math.max(max,count);
            return;
        }
        for(int i=alpha ; i<26 ; i++){
            if(!visited[i]){
                visited[i] = true;
                backtracking(i,len+1);
                visited[i] = false;
            }
        }

    }
}
