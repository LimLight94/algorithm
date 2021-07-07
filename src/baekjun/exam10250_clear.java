package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam10250_clear {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for(int i=0; i<t ; i++){
            String[] tmp = bf.readLine().split(" ");
            int h = Integer.parseInt(tmp[0]);
            int w = Integer.parseInt(tmp[1]);
            int n = Integer.parseInt(tmp[2]);
            int up = n%h;
            int right = 0;
            if(up==0) {
                up = h;
                right = (n/h);
            }else{
                right = (n/h)+1;
            }
            if(right<10) {
                System.out.printf("%d0%d\n",up,right);
            }else{
                System.out.printf("%d%d\n",up,right);
            }
        }
    }
}
