package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class exam12757_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int tmpKey = -1;
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        TreeMap<Integer,Integer> map = new TreeMap<>();
//        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++){
            s = br.readLine().split(" ");
            map.put(Integer.parseInt(s[0]) , Integer.parseInt(s[1]));
        }

        map.put(-2000000000, -1);
        map.put(2000000000, -1);



        for(int j=0 ; j<m ; j++){
            s = br.readLine().split(" ");
            int s0 = Integer.parseInt(s[0]);
            int s1 = Integer.parseInt(s[1]);
            int s2;
            if( s0 == 1){
                map.put(s1 , Integer.parseInt(s[2]));
            }else if(s0 == 2){
                s2 = Integer.parseInt(s[2]);
                int rightKey = map.ceilingKey(s1);
                int leftKey = map.floorKey(s1);

                if (map.get(rightKey) == map.get(leftKey)) {
                    map.put(s1, s2);
                } else if (rightKey - s1 < s1 - leftKey && k >= rightKey - s1) {
                    map.put(rightKey, s2);
                } else if (rightKey - s1 > s1 - leftKey && k >= s1 - leftKey) {
                    map.put(leftKey, s2);
                }
            }else{
                int rightKey = map.ceilingKey(s1);
                int leftKey = map.floorKey(s1);

                if (map.get(rightKey) == map.get(leftKey)) {
                    System.out.println(map.get(s1));
                } else if (rightKey - s1 == s1 - leftKey && k >= rightKey - s1) {
                    System.out.println("?");
                } else if (rightKey - s1 < s1 - leftKey && k >= rightKey - s1) {
                    System.out.println(map.get(rightKey));
                } else if (rightKey - s1 > s1 - leftKey && k >= s1 - leftKey) {
                    System.out.println(map.get(leftKey));
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
