package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class exam1181_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = new String[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = bf.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length()-o2.length();
                }
            }
        });
        String beforStr = "";
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            if(beforStr.equals(s))
                continue;
            sb.append(s+"\n");
            beforStr = s;
        }

        System.out.println(sb);
    }
}
