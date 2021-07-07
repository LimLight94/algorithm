package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class exam10816_clear {
    public static void main(String[] args) throws IOException {
        HashMap<Integer,Integer> map = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        str = bf.readLine();
        String[] array = str.split( " ");
        for(int i = 0 ; i<array.length ; i++){
            int tmp = Integer.parseInt(array[i]);
            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }
        str = bf.readLine();
        int m = Integer.parseInt(str);
        str = bf.readLine();
        array = str.split( " ");
        for(int j=0 ; j<array.length ; j++){
            int tmp  = Integer.parseInt(array[j]);
            System.out.print(map.getOrDefault(tmp,0) + " ");
        }
    }
}
