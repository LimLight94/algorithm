package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1259_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bf.readLine();
            if(s.equals("0"))
                break;
            else{
                cal(s);
            }
        }
    }

    static void cal(String str){
        int mid = str.length()/2;
        if(str.length()%2==0){ //짝수
            String s1 = str.substring(0,mid);
            StringBuilder sb = new StringBuilder(str.substring(mid));
            if(sb.reverse().toString().equals(s1)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }else{
            String s1 = str.substring(0,mid);
            StringBuilder sb = new StringBuilder(str.substring(mid+1));
            if(sb.reverse().toString().equals(s1)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
