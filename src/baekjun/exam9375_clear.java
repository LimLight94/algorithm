package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class exam9375_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for( int i = 0 ; i<caseNum ; i++){
            map.clear();
            int n = Integer.parseInt(br.readLine());
            for( int j=0 ; j<n ; j++){
                String type = br.readLine().split(" ")[1];
                map.put(type , map.getOrDefault(type,0)+1);
            }
            int result = 1;
            for(String key :map.keySet()){
                result *= (map.get(key)+1);
            }
            System.out.println(result-1);
        }
    }
}
