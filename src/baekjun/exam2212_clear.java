package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam2212_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        List<Integer> gapList = new ArrayList<>();
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(tmp[i]));
        }
        if(K>=N){
            System.out.println(0);
            return;
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            gapList.add(list.get(i) - list.get(i-1));
        }
        gapList.sort(Collections.reverseOrder());
        for (int i = 0; i < K-1; i++) {
            gapList.set(i,0);
        }
        int result = 0;
        for (int i=0 ; i< gapList.size() ; i++) {
            result += gapList.get(i);
        }
        System.out.println(result);
    }
}
