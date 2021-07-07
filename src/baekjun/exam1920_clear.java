package baekjun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exam1920_clear {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0 ; i<n ; i++){
            map.put(sc.nextInt(), 1);
        }
        int m = sc.nextInt();
        for(int i=0 ; i<m ; i++){
            System.out.println(map.getOrDefault(sc.nextInt(),0));
        }
    }
}
