package baekjun;

import java.util.*;

public class exam10814_clear {
    public static void main(String[] args) {
        TreeMap<Integer,List<String>> tm = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0 ; i<n ; i++){
            String[] tmp = sc.nextLine().split(" ");
            if(tm.containsKey(Integer.valueOf(tmp[0]))){
                tm.get(Integer.valueOf(tmp[0])).add(tmp[1]);
            }else{
                List<String> stringList = new ArrayList<>();
                stringList.add(tmp[1]);
                tm.put(Integer.valueOf(tmp[0]),stringList);
            }
        }
        for(int a : tm.keySet()){
            for(String s: tm.get(a)){
                System.out.printf("%d %s",a,s);
                System.out.println();
            }
        }
    }
}
