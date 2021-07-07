package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class exam4195_clear {
    public static Map<String, String> parent = new HashMap<>();
    public static Map<String, Integer> number = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num_case = Integer.parseInt(bf.readLine());
        for(int i =0 ; i<num_case ; i++){
            int n = Integer.parseInt(bf.readLine());
            parent.clear();
            number.clear();
            for(int j=0 ; j<n ; j++){
                String[] tmp = bf.readLine().split(" ");
                String x = tmp[0];
                String y = tmp[1];
                if(!parent.containsKey(x)){
                    parent.put(x,x);
                    number.put(x,1);
                }
                if(!parent.containsKey(y)){
                    parent.put(y,y);
                    number.put(y,1);
                }

                union(x,y);
                System.out.println(number.get(find(y)));
            }
        }
    }

    static String find(String x){
        if(x.equals(parent.get(x)))
            return x;
        else{
            String p = find(parent.get(x));
            parent.put(x,p);
            return parent.get(x);
        }
    }

    static void union(String x, String y){
        x = find(x);
        y = find(y);
        if( !x.equals(y)){
            parent.put(y,x);
            number.put(x,number.getOrDefault(x,0)+number.getOrDefault(y,0));
        }
    }
}
