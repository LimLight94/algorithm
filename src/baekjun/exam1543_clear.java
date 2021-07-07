package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1543_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String keyword = bf.readLine();
        int index = 0;
        int count = 0;
        while (true){
            index = str.indexOf(keyword,index);
            if(index==-1){
                System.out.println(count);
                return;
            }else{
                count++;
                index += keyword.length();
            }
        }
    }
}
