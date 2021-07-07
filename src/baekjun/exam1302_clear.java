package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class exam1302_clear {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> map = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<n ; i++){
            String name = bf.readLine();
            map.put(name,map.getOrDefault(name,0)+1);
        }
        int max = 0;
        String maxName ="";
        for(Map.Entry<String, Integer> tmp : map.entrySet()){
            if(max<tmp.getValue()){
                max = tmp.getValue();
                maxName = tmp.getKey();
            }else if(max==tmp.getValue()){
                if(tmp.getKey().compareTo(maxName)<0)
                    maxName = tmp.getKey();
            }
        }
        System.out.println(maxName);
    }
}
